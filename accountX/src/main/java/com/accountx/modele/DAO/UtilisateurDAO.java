package com.accountx.modele.DAO;
import com.accountx.modele.entite.Utilisateur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UtilisateurDAO extends DAOUtilitaire implements DAO<Utilisateur>   {




    public Utilisateur customFind( String mail, String mdp) {
        Utilisateur utilisateur = new Utilisateur();
        String requete = "call read_utilisateur"+"(\""+ mail +"\",\""+ mdp +"\")";
        try {
            ResultSet resultSet = read(requete,getConnection());
            if (resultSet.next()) {
                utilisateur.setCode(resultSet.getString("code"));
                utilisateur.setMail(resultSet.getString("mail"));
                utilisateur.setNom(resultSet.getString("nom"));
                utilisateur.setPrenom(resultSet.getString("prenom"));
            } else {
                utilisateur = null;
            }
            getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return utilisateur;

    }


    @Override
    public Utilisateur findBy(String critere) throws SQLException {
        return null;
    }

    @Override
    public List<Utilisateur> findAll() throws SQLException {
        return null;
    }

    @Override
    public boolean insert(Utilisateur obj) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Utilisateur obj) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Utilisateur obj) throws SQLException {
        return false;
    }
}
