package com.accountx.controleur;

import com.accountx.modele.DAO.CompteDAO;
import com.accountx.modele.PDFgenerator;
import com.accountx.modele.entite.Attribut;
import com.accountx.modele.entite.Compte;
import com.accountx.modele.entite.Dossier;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletPDF", value = "/home/dossier/pdf")
public class ServletPDF extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // set content type
        response.setContentType("application/pdf");

        // set header pour le pdf
        response.setHeader("Content-Disposition", "attachment;filename=AccountX.pdf");

        try {
            CompteDAO compteDAO = new CompteDAO();
            List<Compte> compte = new ArrayList<>();
            Dossier dossier = (Dossier) request.getSession(false).getAttribute("dossier");
            try {
                String fk = Compte.class.getDeclaredField("dossier").getAnnotation(Attribut.class).colonne();
                compte = compteDAO.readWhereFkId(new Compte(), fk, dossier.getIddossier());
            } catch (NoSuchFieldException | SQLException | IllegalAccessException | InstantiationException e) {
                throw new RuntimeException(e);
            }
            // create new PDF generator
            PDFgenerator pdfGenerator = new PDFgenerator();
            byte[] pdfBytes = pdfGenerator.balancePDF(compte);

            // write pdf bytes to response output stream
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(pdfBytes);
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }



        response.sendRedirect(request.getHeader("referer"));
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
