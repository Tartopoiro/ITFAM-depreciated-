package com.accountx.controleur;


import com.accountx.modele.DAO.DossierDAO;
import com.accountx.modele.entite.Dossier;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "ServletInfoDossier", value = "/home/dossier/info")
public class ServletInfoDossier extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/WEB-INF/infodossier.jsp";

        request.getRequestDispatcher(url).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //récupération des champs
        int numero = 0;
        if (request.getParameter("numero")!= ""){
            numero = Integer.parseInt(request.getParameter("numero"));
        }
        String mail = request.getParameter("mail");
        HttpSession httpSession = request.getSession(false);
        //modification de l'attribut de session
        Dossier dossier = (Dossier) httpSession.getAttribute("dossier");
        if (mail != null && numero !=0){
            dossier.setMail(mail);
            dossier.setTel(numero);
            httpSession.setAttribute("dossier",dossier);
        }
        //modification dans de la BDD
        DossierDAO dossierDAO = new DossierDAO();
        try {
            dossierDAO.insert(dossier);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String url = "../dossier";
        response.sendRedirect(url);
    }

}
