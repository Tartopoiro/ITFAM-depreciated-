package com.accountx.modele;

import com.accountx.modele.entite.Compte;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import org.apache.commons.io.IOUtils;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class PDFgenerator {
    //Méthode de génération de PDF pour les balances avec ITEXT
    public byte[] balancePDF (List<Compte> comptes) throws DocumentException {
        Document document = new Document(PageSize.A4.rotate());
        document.setMargins(30f, 30f, 30f, 40f);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document,baos);
        document.open();

        Paragraph title = new Paragraph("AccountX", new Font(Font.FontFamily.HELVETICA,24,Font.BOLD));
        title.setAlignment(Element.ALIGN_CENTER);


        Paragraph spacer = new Paragraph(" ");
        spacer.setSpacingBefore(20f);
        document.add(title);
        document.add(spacer);

        PdfPCell num;
        PdfPCell libelle;
        PdfPCell solde;


        String classeTableau = "";
        PdfPTable balance = new PdfPTable(new float[]{10,75,15});
        balance.setWidthPercentage(100);
        for (Compte compte : comptes){

            String classeCompte = String.valueOf(compte.getNumCompte().toString().charAt(0));
            if (classeCompte.equals(classeTableau)){
                num = new PdfPCell(new Phrase(compte.getNumCompte().toString()));
                libelle = new PdfPCell(new Phrase(compte.getLibelle()));
                solde = new PdfPCell(new Phrase(String.valueOf(compte.getSolde())));
                balance.addCell(num);
                balance.addCell(libelle);
                balance.addCell(solde);

            } else {
                if (!classeTableau.equals("")){
                    document.add(balance);
                    document.newPage();
                }
                classeTableau = String.valueOf(compte.getNumCompte().toString().charAt(0));
                Paragraph subtitle = new Paragraph("Compte de classe : " + classeTableau ,new Font(Font.FontFamily.HELVETICA, 16,Font.BOLD));
                subtitle.setAlignment(Element.ALIGN_CENTER);
                document.add(subtitle);
                document.add(spacer);
                balance = new PdfPTable(new float[]{10,75,15});
                balance.setWidthPercentage(100);

                num = new PdfPCell(new Phrase("Numéro"));
                libelle = new PdfPCell(new Phrase("Libellé"));
                solde = new PdfPCell(new Phrase("Solde (D/+) (C/-)"));
                balance.addCell(num);
                balance.addCell(libelle);
                balance.addCell(solde);

                num = new PdfPCell(new Phrase(compte.getNumCompte().toString()));
                libelle = new PdfPCell(new Phrase(compte.getLibelle()));
                solde = new PdfPCell(new Phrase(String.valueOf(compte.getSolde())));
                balance.addCell(num);
                balance.addCell(libelle);
                balance.addCell(solde);
            }


        }

        document.add(balance);
        document.close();

        return baos.toByteArray();
    }

}
