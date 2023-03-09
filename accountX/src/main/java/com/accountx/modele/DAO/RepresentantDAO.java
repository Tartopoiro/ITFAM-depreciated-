package com.accountx.modele.DAO;

import com.accountx.modele.entite.Representant;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class RepresentantDAO extends DAOUtilitaire implements DAO<Representant> {
    @Override
    public Representant findBy(String critere) throws SQLException {
        return null;
    }

    @Override
    public List<Representant> findAll() throws SQLException {
        return null;
    }

    @Override
    public boolean insert(Representant obj) throws SQLException {
        Connection connection = getConnection();
        CallableStatement callableStatement = connection.prepareCall("{call update_representant (?,?,?,?,?,?)}");
        callableStatement.setObject(1,obj.getIdrepresentant());
        callableStatement.setObject(2,obj.getTel());
        callableStatement.setObject(3,obj.getMail());
        callableStatement.setObject(4,obj.getNom());
        callableStatement.setObject(5,obj.getPrenom());
        callableStatement.setObject(6,obj.getQualite());

        callableStatement.executeUpdate();
        callableStatement.close();
        connection.close();
        return true;
    }

    @Override
    public boolean update(Representant obj) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Representant obj) throws SQLException {
        return false;
    }
}
