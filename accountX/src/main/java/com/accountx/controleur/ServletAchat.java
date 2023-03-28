package com.accountx.controleur;

import com.accountx.modele.DAO.CompteAuxDAO;
import com.accountx.modele.DAO.CompteDAO;
import com.accountx.modele.entite.Attribut;
import com.accountx.modele.entite.Compte;
import com.accountx.modele.entite.CompteAux;
import com.accountx.modele.entite.Dossier;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.json.JSONArray;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletAchat", value = "/home/dossier/achat")
public class ServletAchat extends HttpServlet {
    JSONArray compteAuxList = new JSONArray();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/WEB-INF/saisieAchat.jsp";
        CompteDAO compteDAO = new CompteDAO();
        List<Compte> compte = new ArrayList<>();
        //Récupération des comptes de la société
        Dossier dossier = (Dossier) request.getSession(false).getAttribute("dossier");
        try {
            String fk = Compte.class.getDeclaredField("dossier").getAnnotation(Attribut.class).colonne();
            compte = compteDAO.readWhereFkId(new Compte(), fk, dossier.getIddossier());
        } catch (NoSuchFieldException | SQLException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
        //Récupération des comptes auxiliaires
        CompteAuxDAO compteAuxDAO = new CompteAuxDAO();
        List<CompteAux> compteAux = new ArrayList<>();
        List<String> fournisseurs =new ArrayList<>();
        try {
            String fk = CompteAux.class.getDeclaredField("compteRattachement").getAnnotation(Attribut.class).colonne();
            List<Integer> integerList = new ArrayList<>() ;
            for (Compte comptes : compte){
                integerList.add(comptes.getIdcompte());
            }
            compteAux = compteAuxDAO.readWhereFkInList(new CompteAux(), fk, integerList);
            for (CompteAux compteAux1 : compteAux){
                if (compteAux1.getType() == 1){
                    fournisseurs.add(compteAux1.getLibelle());
                }
            }

        } catch (NoSuchFieldException | SQLException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
        try {
            compteAuxList = ServletUtilitaire.listToAutoComplete(fournisseurs);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("compteAuxList",compteAuxList);
        request.getRequestDispatcher(url).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
