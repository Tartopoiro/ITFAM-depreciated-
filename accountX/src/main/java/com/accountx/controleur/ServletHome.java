package com.accountx.controleur;

import com.accountx.modele.DAO.DossierDAO;
import com.accountx.modele.entite.Dossier;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.json.JSONArray;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

@WebServlet(name = "ServletHome", value = "/home")
public class ServletHome extends HttpServlet {

    JSONArray dossierlist = new JSONArray();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession(false);

        if (httpSession.getAttribute("dossier")!=null){
            httpSession.removeAttribute("dossier");
        }

        String url = "WEB-INF/home.jsp";
        dossierlist = getDossierlist();
        request.setAttribute("dossierlist",dossierlist);
        request.getRequestDispatcher(url).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String root = request.getParameter("root");
        String url = "/accountx/home";
        String dossier = request.getParameter("dossier");
        dossierlist = getDossierlist();

        //redirection
            //deconnexion
        if (root.equals("exit")){
            HttpSession session = request.getSession(false);
            session.invalidate();
            response.sendRedirect("/accountx/login");
        }
            //Accès dossier
        if (root.equals("dossier")) {
            if (ServletUtilitaire.stringInJSONArray(dossier,dossierlist)) {
                try {
                    dossier =dossier.substring(0, dossier.indexOf(' '));
                    HttpSession httpSession = request.getSession(false);
                    //récupération du dossier
                    DossierDAO dossierDAO = new DossierDAO();
                    Dossier dossierEnCours = null;
                    try {
                        dossierEnCours = dossierDAO.recursiveReadById(new Dossier(), dossier);
                    } catch (SQLException | IllegalAccessException | InstantiationException | NoSuchMethodException |
                             InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                    httpSession.setAttribute("dossier",dossierEnCours);
                    url = "/accountx/home/dossier";
                    response.sendRedirect(url);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            } else {
                response.sendRedirect(url);
            }
        }
    }

    //Méthode de récupération des dossiers utilisés pour do GET et do POST
    protected JSONArray getDossierlist(){
        DossierDAO dossierDAO = new DossierDAO();
        try {
            List<Dossier> dossier = dossierDAO.findAll();
            dossierlist = ServletUtilitaire.listToAutoComplete(dossier);
            return dossierlist;

        } catch (SQLException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    };
}
