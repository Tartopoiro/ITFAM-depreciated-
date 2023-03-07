package com.accountx.modele.DAO;

import com.accountx.modele.Connexion;
import com.accountx.modele.entite.Dossier;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DossierDAO extends DAOUtilitaire implements DAO<Dossier> {

    //Remplacé par la méthode recursiveReadById
    @Override @Deprecated
    public Dossier findBy(String critere) throws SQLException {
        String requete = "call readWhereID (\"dossier\","+critere+");";
        Dossier dossier = new Dossier();
        ResultSet resultSet = read (requete,getConnection());
        if (resultSet.next()){
            Field[] fields = dossier.getClass().getDeclaredFields();
            int i = 1;
            for (Field field : fields){
                field.setAccessible(true);
                try {
                    field.set(dossier,resultSet.getObject(i));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                i++;
            }
        }

        return dossier;
    }
    //Permet de récupérer tous les dossiers (utile pour l'autocompletion)
    @Override
    public List<Dossier> findAll() throws SQLException {
        String requete = "call read_all(\"dossier\")";
        List<Dossier> dossier = new ArrayList<>();
        ResultSet resultSet = read (requete,getConnection());
        while (resultSet.next()) {
            Dossier dossier1 = new Dossier();
            dossier1.setIddossier(resultSet.getInt(1));
            dossier1.setDenominationSociale(resultSet.getString(4));
            dossier.add(dossier1);
        }
        return dossier;
    }
    //permet de modifier les contacts du dossier
    @Override
    public boolean insert(Dossier obj) throws SQLException {
        String requete = "call update_contact("+obj.getIddossier()+","+obj.getTel()+",\""+obj.getMail()+"\")";
        Connection connection = getConnection();
        CallableStatement callableStatement = connection.prepareCall(requete);
        callableStatement.executeUpdate();
        callableStatement.close();
        connection.close();
        return true;
    }

    @Override
    public boolean update(Dossier obj) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Dossier obj) throws SQLException {
        return false;
    }

    public Dossier recursiveReadById(Dossier objet, String id) throws SQLException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        return super.recursiveReadById(objet, id);
    }
}
