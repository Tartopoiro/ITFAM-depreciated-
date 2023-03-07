package com.accountx.modele.entite;
@Entite(table = "representant")
public class Representant {
    @Attribut(colonne="idrepresentant") @PrimaryKey
    private Integer idrepresentant;
    @Attribut(colonne="tel")
    private Integer tel;
    @Attribut(colonne="mail")
    private String mail;
    @Attribut(colonne="nom")
    private String nom;
    @Attribut(colonne="prenom")
    private String prenom;
    @Attribut(colonne="adresse")
    private Adresse adresse;
    @Attribut(colonne="qualite")
    private String qualite;


    public Integer getIdrepresentant(){
        return idrepresentant;
    }

    public void setIdrepresentant(Integer idrepresentant){
        this.idrepresentant=idrepresentant;
    }

    public Integer getTel(){
        return tel;
    }

    public void setTel(Integer tel){
        this.tel=tel;
    }

    public String getMail(){
        return mail;
    }

    public void setMail(String mail){
        this.mail=mail;
    }

    public String getNom(){
        return nom;
    }

    public void setNom(String nom){
        this.nom=nom;
    }

    public String getPrenom(){
        return prenom;
    }

    public void setPrenom(String prenom){
        this.prenom=prenom;
    }

    public Adresse getAdresse(){
        return adresse;
    }

    public void setAdresse(Adresse adresse){
        this.adresse=adresse;
    }

    public String getQualite(){
        return qualite;
    }

    public void setQualite(String qualite){
        this.qualite=qualite;
    }


}
