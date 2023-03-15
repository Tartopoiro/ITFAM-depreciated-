package com.accountx.modele.DAO;

import com.accountx.modele.entite.Attribut;
import com.accountx.modele.entite.Entite;
import com.accountx.modele.entite.PrimaryKey;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

//Classe Mere pour toutes les classes JavaBeanDAO pour ne pas récrire certaines méthodes récurrentes
//Note pour plus tard : !!! personnalisation des exceptions !!!
public class DAOUtilitaire {

    //Méthode de connexion à la BDD
    public Connection getConnection() throws SQLException {
        String url ="";
        String user ="";
        String mdp ="";
        String driver ="";
        String path = "../../../../../accountX/src/main/webapp/WEB-INF/DAO.properties";
        //chargement des informations du properties
        try {
            InputStream inputStream = new FileInputStream(path);

            Properties properties = new Properties();
            properties.load(inputStream);
            driver = properties.getProperty("driver");
            url = properties.getProperty( "url" );
            user = properties.getProperty( "user" );
            mdp = properties.getProperty( "mdp" );
            Logger logger = Logger.getLogger(getClass().getName());
            logger.info("infodev --> "+user+" --- "+mdp+" --- "+url);

        } catch (IOException e){
            e.printStackTrace();
        }
        try {

            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connection = DriverManager.getConnection(url,user,mdp);
        return connection;
    }

    //méthode retournant un resultset
    protected ResultSet read(String requete, Connection connection) throws SQLException {
        CallableStatement stmt = connection.prepareCall(requete);
        return stmt.executeQuery();
    }

    //Méthode retournant un objet de la table par son ID avec récursivité
    protected <T> T recursiveReadById (T objet, String id) throws SQLException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //Note : méthode ne fonctionnant que pour des tables à PK unique de type int
        //On récupère les attributs de l'objet
        Field[] fields = objet.getClass().getDeclaredFields();
        //On récupère l'objet dans la table recherché par son id
        Connection connection = getConnection();
        String table = objet.getClass().getAnnotation(Entite.class).table();
        String requete = "call readWhereID (\""+table+"\","+id+");";
        ResultSet resultSet = connection.prepareCall(requete).executeQuery();
        //On affecte le resultset aux attributs de l'objet
        if (resultSet.next()){
            //affectation des autres attributs et application de la recursivité
            for (Field field : fields){
                field.setAccessible(true);
                //on verifie que l'attribut n'est pas une FK
                if (!field.getType().getPackage().equals(objet.getClass().getPackage())){
                    field.set(objet, resultSet.getObject(field.getAnnotation(Attribut.class).colonne()));
                } else {
                    String idfk = String.valueOf(resultSet.getInt(field.getAnnotation(Attribut.class).colonne()));
                    Object objetfk = field.getType().getDeclaredConstructor().newInstance();
                    field.set(objet, recursiveReadById(objetfk,idfk));
                }
            }

        }
        connection.close();
        return objet;
    }

    //Méthode retournant un objet de la table par son ID sans récursivité
    protected <T> T readWhereId (T objet, String id) throws SQLException, IllegalAccessException {
        //On récupère les attributs de l'objet
        Field[] fields = objet.getClass().getDeclaredFields();
        //On récupère l'objet dans la table recherché par son id
        Connection connection = getConnection();
        String table = objet.getClass().getAnnotation(Entite.class).table();
        String requete = "call readWhereID (\""+table+"\","+id+");";
        ResultSet resultSet = connection.prepareCall(requete).executeQuery();

        //On affecte le resultset aux attributs de l'objet
        if (resultSet.next()){
            for (Field field : fields){
                field.setAccessible(true);
                field.set(objet, resultSet.getObject(field.getAnnotation(Attribut.class).colonne()));
            }

        }

        return objet;
    }




}
