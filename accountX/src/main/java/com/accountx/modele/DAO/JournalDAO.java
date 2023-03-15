package com.accountx.modele.DAO;

import com.accountx.modele.entite.Journal;

import java.sql.SQLException;
import java.util.List;

public class JournalDAO extends DAOUtilitaire implements DAO<Journal> {

    @Override
    public Journal findBy(String critere) throws SQLException {
        return null;
    }

    @Override
    public List<Journal> findAll() throws SQLException {
        return null;
    }

    @Override
    public boolean insert(Journal obj) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Journal obj) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Journal obj) throws SQLException {
        return false;
    }
}
