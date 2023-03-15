package com.accountx.controleur;

import com.accountx.modele.DAO.CompteDAO;
import com.accountx.modele.entite.Compte;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletBalance", value = "/home/dossier/balance")
public class ServletBalance extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/WEB-INF/balance.jsp";
        CompteDAO compteDAO = new CompteDAO();
        Compte compte = new Compte();
        try {
            compte = compteDAO.readWhereId(new Compte(),"1");
        } catch (SQLException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("compte",compte);
        request.getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
