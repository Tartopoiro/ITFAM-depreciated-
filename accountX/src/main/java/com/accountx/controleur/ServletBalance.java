package com.accountx.controleur;

import com.accountx.modele.DAO.CompteDAO;
import com.accountx.modele.entite.Attribut;
import com.accountx.modele.entite.Compte;
import com.accountx.modele.entite.Dossier;
import com.mysql.cj.log.Log;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@WebServlet(name = "ServletBalance", value = "/home/dossier/balance")
public class ServletBalance extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/WEB-INF/balance.jsp";
        CompteDAO compteDAO = new CompteDAO();
        List<Compte> compte = new ArrayList<>();
        Dossier dossier = (Dossier) request.getSession(false).getAttribute("dossier");
        try {
            String fk = Compte.class.getDeclaredField("dossier").getAnnotation(Attribut.class).colonne();
            compte = compteDAO.readWhereFkId(new Compte(), fk, dossier.getIddossier());
        } catch (NoSuchFieldException | SQLException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("compte",compte);
        request.getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
