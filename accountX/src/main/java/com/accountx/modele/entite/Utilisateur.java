package com.accountx.modele.entite;

@Entite(table = "utilisateur")
public class Utilisateur {
    @Attribut(colonne="idutilisateur") @PrimaryKey
    private Long id;
    @Attribut(colonne="mail")
    private String mail;
    @Attribut(colonne="mdp")
    private String mdp;
    @Attribut(colonne="nom")
    private String nom;
    @Attribut(colonne="prenom")
    private String prenom;
    @Attribut(colonne="code")
    private String code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
