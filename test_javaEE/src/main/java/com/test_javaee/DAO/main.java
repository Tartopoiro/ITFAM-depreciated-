package com.test_javaee.DAO;

import java.sql.SQLException;
import java.util.List;

public class main {
    DAOFactory daoFactory = DAOFactory.getInstance();
    UserDAO userDao = daoFactory.getUserDAO();

    // Récupération de tous les utilisateurs
    List<User> users = userDao.findAll();




    public main() throws SQLException {
    }
}
