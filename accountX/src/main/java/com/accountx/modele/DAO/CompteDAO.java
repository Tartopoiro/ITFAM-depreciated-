package com.accountx.modele.DAO;

import com.accountx.modele.entite.Compte;

import java.sql.SQLException;
import java.util.List;

public class CompteDAO extends DAOUtilitaire implements DAO<Compte> {
    @Override
    public Compte findBy(String critere) throws SQLException {
        return null;
    }

    @Override
    public List<Compte> findAll() throws SQLException {
        return null;
    }

    @Override
    public boolean insert(Compte obj) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Compte obj) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Compte obj) throws SQLException {
        return false;
    }
}
