package com.test_javaee.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {

    // Méthode pour récupérer une instance de DAOFactory
    public static DAOFactory getInstance() {
        return new DAOFactory();
    }

    private static final String MYSQL_DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String MYSQL_URL = "jdbc:mysql://localhost/mydatabase";
    private static final String MYSQL_USER = "root";
    private static final String MYSQL_PASSWORD = "";

    // Méthodes pour récupérer des instances de classes DAO
    public UserDAO getUserDAO() throws SQLException{
        return new UserDAO(getConnection());
    };


    // autres méthodes pour d'autres classes DAO

    // Méthode pour récupérer une connexion à la base de données
    protected Connection getConnection() throws SQLException {
        try {
            Class.forName(MYSQL_DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver MySQL introuvable");
        }
        return DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD);
    }


}