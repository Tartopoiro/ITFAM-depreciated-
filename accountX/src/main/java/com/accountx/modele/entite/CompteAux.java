package com.accountx.modele.entite;
@Entite(table = "compte_auxiliaire")
public class CompteAux {
    @Attribut(colonne = "idcompte_auxilaire")@PrimaryKey
    private Integer idcompteAux;
    @Attribut(colonne = "compte_rattachement")
    private Integer compteRattachement;
    @Attribut(colonne = "libelle")
    private String libelle;
    @Attribut(colonne = "type")
    private Integer type;
    @Attribut(colonne = "solde")
    private double solde;


    public Integer getIdcompteAux() {
        return idcompteAux;
    }

    public void setIdcompteAux(Integer idcompteAux) {
        this.idcompteAux = idcompteAux;
    }

    public Integer getCompteRattachement() {
        return compteRattachement;
    }

    public void setCompteRattachement(Integer compteRattachement) {
        this.compteRattachement = compteRattachement;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }
}
