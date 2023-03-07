package com.accountx.modele;

import com.accountx.modele.DAO.UtilisateurDAO;
import com.accountx.modele.entite.Utilisateur;
import jakarta.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Properties;
import java.util.logging.Logger;

public class Connexion {

    private static final String email = "email";
    private static final String motDePasse ="motdepasse";
    private String erreur =null;

    private Boolean authentification = false;


    public Boolean getAuthentification() {
        return authentification;
    }

    public String getErreur() {
        return erreur;
    }

    //Methode de récupération de contenu d'un champ
    private static String getContent (HttpServletRequest request, String fieldName){
        String content = request.getParameter(fieldName);
        if (content == null || content.trim().length() == 0) {
            return null;
        } else {
            return content.trim();
        }
    }
    //Methode de connexion
    public Utilisateur login (HttpServletRequest request){
        Utilisateur utilisateur = new Utilisateur();

        String mailSaisie = getContent(request, email);
        String mdpSaisie = getContent(request,motDePasse);

        //Controle des champs id et mdp non null sinon erreur
        if ((mailSaisie == null || mailSaisie.trim().length() == 0) && (mdpSaisie == null || mdpSaisie.trim().length() == 0)){
            erreur = "Veuillez remplir le formulaire";

        } else if (mdpSaisie == null || mdpSaisie.trim().length() == 0) {
            utilisateur.setMail(mailSaisie.trim());
            erreur = "Veuillez remplir le formulaire";
        } else {
            //Transformation du Mdp en String crypté (SHA 256)
                //recupération du SEL
            String hashMDP ="";
            String sel ="";
            String selPath = "../../../../../accountX/src/main/webapp/WEB-INF/SEL.properties";
            Properties properties = new Properties();
            InputStream inputStream = null;
            
            try {
                inputStream = new FileInputStream(selPath);
                properties.load(inputStream);
                sel = properties.getProperty("sel");


            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
                //Hashage
            MessageDigest messageDigest = null;
            try {
                messageDigest = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
            hashMDP = Base64.getEncoder().encodeToString(messageDigest.digest((mdpSaisie+sel).getBytes()));


            //Tentative de connexion en accedant à la BDD
            UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
            utilisateur = utilisateurDAO.customFind(mailSaisie,hashMDP);
            if (utilisateur==null){
                erreur = "Mail ou mot de passe incorrect";
                utilisateur = new Utilisateur();
            } else {
                authentification = true;
            }

        }
        return utilisateur;
    }
}
