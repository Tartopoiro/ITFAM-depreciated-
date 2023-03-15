package com.accountx.modele.DAO;

import com.accountx.modele.entite.Ecriture;

import java.sql.SQLException;
import java.util.List;

public class EcritureDAO extends DAOUtilitaire implements DAO<Ecriture> {
    @Override
    public Ecriture findBy(String critere) throws SQLException {
        return null;
    }

    @Override
    public List<Ecriture> findAll() throws SQLException {
        return null;
    }

    @Override
    public boolean insert(Ecriture obj) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Ecriture obj) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Ecriture obj) throws SQLException {
        return false;
    }
}
