package com.accountx.controleur;

import com.accountx.modele.DAO.DAOUtilitaire;
import com.accountx.modele.DAO.DossierDAO;
import com.accountx.modele.entite.Dossier;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.logging.Logger;

@WebServlet(name = "ServletDossier", value = "/home/dossier")
public class ServletDossier extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/WEB-INF/dossier.jsp";
        request.getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String root = request.getParameter("root");
        String url = "/WEB-INF/dossier.jsp";
        if (root.equals("home")) {
            url = "/accountX-1.0-SNAPSHOT/home";
            response.sendRedirect(url);

        } else {
            request.getRequestDispatcher(url).forward(request, response);

        }
    }
}