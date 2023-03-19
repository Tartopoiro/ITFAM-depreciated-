package com.accountx.modele.DAO;

import com.accountx.modele.entite.Compte;
import com.accountx.modele.entite.Dossier;

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

    public Compte readWhereId(Compte objet, String id) throws SQLException, IllegalAccessException {
        return super.readWhereId (objet, id);
    }

    public List<Compte> readWhereFkId(Compte objet, String fk, Integer fkid) throws SQLException, IllegalAccessException, InstantiationException {
        return super.readWhereFkId(objet, fk, fkid);
    }

}
