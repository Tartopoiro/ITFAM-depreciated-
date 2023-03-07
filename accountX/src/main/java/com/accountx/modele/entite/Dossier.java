package com.accountx.modele.entite;
@Entite(table = "dossier")
public class Dossier {
    @Attribut(colonne="iddossier") @PrimaryKey
    private Integer iddossier;
    @Attribut(colonne="tel")
    private Integer tel;
    @Attribut(colonne="mail")
    private String mail;
    @Attribut(colonne="denomination_sociale")
    private String denominationSociale;
    @Attribut(colonne="forme_juridique")
    private String formeJuridique;
    @Attribut(colonne="regime_fiscal")
    private Integer regimeFiscal;
    @Attribut(colonne="regime_fiscal")
    private Integer regimeTva;
    @Attribut(colonne="capital")
    private Float capital;
    @Attribut(colonne="representant")
    private Representant representant;
    @Attribut(colonne="adresse")
    private Adresse adresse;
    @Attribut(colonne="commentaire")
    private String commentaire;

    public Dossier() {
    }


    public Integer getIddossier(){
        return iddossier;
    }

    public void setIddossier(Integer iddossier){
        this.iddossier=iddossier;
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

    public String getDenominationSociale(){
        return denominationSociale;
    }

    public void setDenominationSociale(String denominationSociale){
        this.denominationSociale=denominationSociale;
    }

    public String getFormeJuridique(){
        return formeJuridique;
    }

    public void setFormeJuridique(String formeJuridique){
        this.formeJuridique=formeJuridique;
    }

    public Integer getRegimeFiscal(){
        return regimeFiscal;
    }

    public void setRegimeFiscal(Integer regimeFiscal){
        this.regimeFiscal=regimeFiscal;
    }

    public Integer getRegimeTva(){
        return regimeTva;
    }

    public void setRegimeTva(Integer regimeTva){
        this.regimeTva=regimeTva;
    }

    public Float getCapital(){
        return capital;
    }

    public void setCapital(Float capital){
        this.capital=capital;
    }

    public Representant getRepresentant(){
        return representant;
    }

    public void setRepresentant(Representant representant){
        this.representant=representant;
    }

    public Adresse getAdresse(){
        return adresse;
    }

    public void setAdresse(Adresse adresse){
        this.adresse=adresse;
    }

    public String getCommentaire(){
        return commentaire;
    }

    public void setCommentaire(String commentaire){
        this.commentaire=commentaire;
    }


}
