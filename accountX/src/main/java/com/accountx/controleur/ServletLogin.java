package com.accountx.controleur;

import com.accountx.modele.Connexion;
import com.accountx.modele.entite.Utilisateur;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletLogin", value = "/login")
public class ServletLogin extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/WEB-INF/login.jsp";

        if (request.getSession() == null){
            request.getSession(true);
        }

        request.getRequestDispatcher(url).forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Connexion connexion = new Connexion();

        Utilisateur utilisateur = connexion.login(request);

        request.setAttribute("utilisateur", utilisateur);
        request.setAttribute("connexion", connexion);

        if (connexion.getAuthentification()){
            HttpSession httpSession = request.getSession(false);
            httpSession.setAttribute("utilisateur",utilisateur);
            response.sendRedirect("/accountx/home");

        }else {
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
        }


        ;
    }


}
