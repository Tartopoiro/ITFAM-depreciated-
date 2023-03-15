package com.accountx.modele.entite;

import java.sql.Time;
import java.sql.Timestamp;

@Entite(table = "ecriture_comptable")
public class Ecriture {
    @Attribut(colonne="idecriture_comptable")@PrimaryKey
    private Integer idecriture;
    @Attribut(colonne = "date_saisie")
    private Timestamp dateSaisie;
    @Attribut(colonne = "date_validation")
    private Timestamp dateValidation;
    @Attribut(colonne = "operateur")
    private Integer operateur;
    @Attribut(colonne = "code_operation")
    private Integer code;
    @Attribut(colonne = "debit")
    private double debit;
    @Attribut(colonne = "credit")
    private double credit;
    @Attribut(colonne = "num_compte")
    private Integer numCompte;
    @Attribut(colonne = "num_compte_aux")
    private Integer numCompteAux;
    @Attribut(colonne = "num_facture")
    private String numFacture;
    @Attribut(colonne = "libelle")
    private String libelle;
    @Attribut(colonne = "date_facture")
    private Timestamp dateFacture;
    @Attribut(colonne = "journal")
    private Integer journal;
    @Attribut(colonne = "lettrage")
    private String lettrage;
    @Attribut(colonne = "date_lettrage")
    private Timestamp dateLettrage;
    @Attribut(colonne = "montant_devise")
    private double devise;
    @Attribut(colonne = "type_devise")
    private Integer typeDevise;


    public Integer getIdecriture() {
        return idecriture;
    }

    public void setIdecriture(Integer idecriture) {
        this.idecriture = idecriture;
    }

    public Timestamp getDateSaisie() {
        return dateSaisie;
    }

    public void setDateSaisie(Timestamp dateSaisie) {
        this.dateSaisie = dateSaisie;
    }

    public Timestamp getDateValidation() {
        return dateValidation;
    }

    public void setDateValidation(Timestamp dateValidation) {
        this.dateValidation = dateValidation;
    }

    public Integer getOperateur() {
        return operateur;
    }

    public void setOperateur(Integer operateur) {
        this.operateur = operateur;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public Integer getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(Integer numCompte) {
        this.numCompte = numCompte;
    }

    public Integer getNumCompteAux() {
        return numCompteAux;
    }

    public void setNumCompteAux(Integer numCompteAux) {
        this.numCompteAux = numCompteAux;
    }

    public String getNumFacture() {
        return numFacture;
    }

    public void setNumFacture(String numFacture) {
        this.numFacture = numFacture;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Timestamp getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Timestamp dateFacture) {
        this.dateFacture = dateFacture;
    }

    public Integer getJournal() {
        return journal;
    }

    public void setJournal(Integer journal) {
        this.journal = journal;
    }

    public String getLettrage() {
        return lettrage;
    }

    public void setLettrage(String lettrage) {
        this.lettrage = lettrage;
    }

    public Timestamp getDateLettrage() {
        return dateLettrage;
    }

    public void setDateLettrage(Timestamp dateLettrage) {
        this.dateLettrage = dateLettrage;
    }

    public double getDevise() {
        return devise;
    }

    public void setDevise(double devise) {
        this.devise = devise;
    }

    public Integer getTypeDevise() {
        return typeDevise;
    }

    public void setTypeDevise(Integer typeDevise) {
        this.typeDevise = typeDevise;
    }
}
