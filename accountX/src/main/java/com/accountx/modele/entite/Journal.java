package com.accountx.modele.entite;
@Entite(table = "journal")
public class Journal {
    @Attribut(colonne = "idjournal") @PrimaryKey
    private Integer idjournal;
    @Attribut(colonne = "dossier")
    private Integer dossier;
    @Attribut(colonne = "type")
    private Integer type;
    @Attribut(colonne = "libelle")
    private String libelle;
    @Attribut(colonne = "code")
    private String code;
    @Attribut(colonne = "commentaire")
    private String commentaire;
    @Attribut(colonne = "solde")
    private double solde;


    public Integer getIdjournal() {
        return idjournal;
    }

    public void setIdjournal(Integer idjournal) {
        this.idjournal = idjournal;
    }

    public Integer getDossier() {
        return dossier;
    }

    public void setDossier(Integer dossier) {
        this.dossier = dossier;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }
}
