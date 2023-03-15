package com.accountx.modele.entite;
@Entite(table = "compte")
public class Compte {
    @Attribut(colonne = "idcompte") @PrimaryKey
    private Integer idcompte;
    @Attribut(colonne = "numero_compte")
    private Integer numCompte;
    @Attribut(colonne = "libelle")
    private String libelle;
    @Attribut(colonne = "dossier")
    private Integer dossier;
    @Attribut(colonne = "solde")
    private double solde;


    public Integer getIdcompte() {
        return idcompte;
    }

    public void setIdcompte(Integer idcompte) {
        this.idcompte = idcompte;
    }

    public Integer getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(Integer numCompte) {
        this.numCompte = numCompte;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getDossier() {
        return dossier;
    }

    public void setDossier(Integer dossier) {
        this.dossier = dossier;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }
}
