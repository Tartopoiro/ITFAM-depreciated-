package com.test_javaee;

import java.io.*;
import java.util.logging.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       request.getRequestDispatcher("WEB-INF/hello.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String root = request.getParameter("root");
        String url = "WEB-INF/hello.jsp";
        if (root.equals("home")) {
            url = "home";

            response.sendRedirect(url);
            Logger log = Logger.getLogger(getClass().getName());
            log.info("Info utilisateur root to home " + url);
        } else {
            request.getRequestDispatcher(url).forward(request, response);

        }
    }
}