package com.accountx.controleur;

import com.accountx.modele.DAO.AdresseDAO;
import com.accountx.modele.DAO.DossierDAO;
import com.accountx.modele.DAO.RepresentantDAO;
import com.accountx.modele.entite.Adresse;
import com.accountx.modele.entite.Dossier;
import com.accountx.modele.entite.Representant;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletRepresentant", value = "/home/dossier/representant")
public class ServletRepresentant extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/WEB-INF/representant.jsp";
        request.getRequestDispatcher(url).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //récupération des champs
        int tel = 0;
        if (request.getParameter("numero")!= ""){
            tel = Integer.parseInt(request.getParameter("tel"));
        }
        String mail = request.getParameter("mail");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String qualite = request.getParameter("qualite");
        String numadresse = request.getParameter("numadresse");
        String rue = request.getParameter("rue");
        String ville = request.getParameter("ville");
        String pays = request.getParameter("pays");
        String complement = request.getParameter("complement");

        HttpSession httpSession = request.getSession(false);
        //modification de l'attribut de session
        Dossier dossier = (Dossier) httpSession.getAttribute("dossier");
        Representant representant = dossier.getRepresentant();
        Adresse adresseRepresentant = representant.getAdresse();
        //Pas de constructeur personnalisé pour l'instant, car les informations sur les regimes fiscaux ne sont pas encore implémentés.
        representant.setMail(mail);
        representant.setTel(tel);
        representant.setNom(nom);
        representant.setPrenom(prenom);
        representant.setQualite(qualite);
        adresseRepresentant = new Adresse(adresseRepresentant.getIdadresse(),pays,ville,rue,numadresse,complement);

        representant.setAdresse(adresseRepresentant);
        dossier.setRepresentant(representant);
        httpSession.setAttribute("dossier",dossier);
        //modification dans de la BDD
        RepresentantDAO representantDAO = new RepresentantDAO();
        AdresseDAO adresseDAO = new AdresseDAO();
        try {
            representantDAO.insert(dossier.getRepresentant());
            adresseDAO.insert(dossier.getRepresentant().getAdresse());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String url = "../dossier";
        response.sendRedirect(url);
    }
}
