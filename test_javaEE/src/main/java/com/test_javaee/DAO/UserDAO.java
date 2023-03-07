package com.test_javaee.DAO;
import java.sql.*;
import java.util.*;

public class UserDAO implements DAO<User> {


    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean insert(User user) throws SQLException {
        String query = "INSERT INTO users (nom, prenom) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getNom());
            statement.setString(2, user.getPrenom());
            statement.executeUpdate();
            return true;
        }

    }

    @Override
    public User findById(int id) throws SQLException {
        String query = "SELECT * FROM users WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String nom = resultSet.getString("nom");
                    String prenom = resultSet.getString("prenom");
                    return new User(id, nom, prenom);
                }
            }
        }

        return null;
    }


    @Override
    public
    List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<>() {
        };
        String query = "SELECT * FROM users";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                users.add(new User(id, nom, prenom));
            }
        }

        return users;
    }

    @Override
    public boolean update(User user) throws SQLException {
        String query = "UPDATE users SET nom = ?, prenom = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getNom());
            statement.setString(2, user.getPrenom());
            statement.setInt(3, user.getId());
            statement.executeUpdate();
            return true;
        }
    }

    @Override
    public boolean delete(User user) throws SQLException {
        String query = "DELETE FROM users WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, user.getId());
            statement.executeUpdate();
            return true;
        }
    }
}
