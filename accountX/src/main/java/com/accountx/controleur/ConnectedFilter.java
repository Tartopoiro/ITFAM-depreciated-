package com.accountx.controleur;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.logging.Logger;

@WebFilter(filterName = "ConnectedFilter", urlPatterns = {"/home","/home/*"})
public class ConnectedFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //cast et récuperation de la session
        HttpServletRequest requestFilter = (HttpServletRequest) request;
        HttpServletResponse responseFilter = (HttpServletResponse) response;
        HttpSession httpSession = requestFilter.getSession();

        if (httpSession.getAttribute("utilisateur")==null){
            responseFilter.sendRedirect("/accountx/login");
        } else {
            chain.doFilter(request, response);
        }
    }
}
