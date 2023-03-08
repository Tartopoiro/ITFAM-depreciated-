package com.accountx.modele.DAO;

import com.accountx.modele.entite.Adresse;
import com.accountx.modele.entite.Dossier;

import java.io.UnsupportedEncodingException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AdresseDAO extends DAOUtilitaire implements DAO<Adresse>{

    @Override
    public Adresse findBy(String critere) throws SQLException {
        return null;
    }

    @Override
    public List<Adresse> findAll() throws SQLException {
        return null;
    }

    @Override
    public boolean insert(Adresse obj) throws SQLException {
        Connection connection = getConnection();
        CallableStatement callableStatement = connection.prepareCall("{call update_adresse (?,?,?,?,?,?)}");
        callableStatement.setObject(1,obj.getIdadresse());
        callableStatement.setObject(2,obj.getRue());
        callableStatement.setObject(3,obj.getVille());
        callableStatement.setObject(4,obj.getNumero());
        callableStatement.setObject(5,obj.getComplement());
        callableStatement.setObject(6,obj.getPays());

        callableStatement.executeUpdate();
        callableStatement.close();
        connection.close();
        return true;
    }

    @Override
    public boolean update(Adresse obj) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Adresse obj) throws SQLException {
        return false;
    }
}
