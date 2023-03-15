package com.accountx.modele.DAO;

import com.accountx.modele.entite.CompteAux;

import java.sql.SQLException;
import java.util.List;

public class CompteAuxDAO extends DAOUtilitaire implements DAO<CompteAux> {
    @Override
    public CompteAux findBy(String critere) throws SQLException {
        return null;
    }

    @Override
    public List<CompteAux> findAll() throws SQLException {
        return null;
    }

    @Override
    public boolean insert(CompteAux obj) throws SQLException {
        return false;
    }

    @Override
    public boolean update(CompteAux obj) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(CompteAux obj) throws SQLException {
        return false;
    }
}
