package com.accountx.modele.entite;
@Entite(table="adresse")
public class Adresse {
    @Attribut(colonne="idadresse") @PrimaryKey
    private Integer idadresse;
    @Attribut(colonne="pays")
    private String pays;
    @Attribut(colonne="ville")
    private String ville;
    @Attribut(colonne="rue")
    private String rue;
    @Attribut(colonne="numero")
    private String numero;
    @Attribut(colonne="complement")
    private String complement;


    public Adresse() {
    }

    public Adresse(Integer idadresse, String pays, String ville, String rue, String numero, String complement) {
        this.idadresse = idadresse;
        this.pays = pays;
        this.ville = ville;
        this.rue = rue;
        this.numero = numero;
        this.complement = complement;
    }

    public Integer getIdadresse(){
        return idadresse;
    }

    public void setIdadresse(Integer idadresse){
        this.idadresse=idadresse;
    }

    public String getPays(){
        return pays;
    }

    public void setPays(String pays){
        this.pays=pays;
    }

    public String getVille(){
        return ville;
    }

    public void setVille(String ville){
        this.ville=ville;
    }

    public String getRue(){
        return rue;
    }

    public void setRue(String rue){
        this.rue=rue;
    }

    public String getNumero(){
        return numero;
    }

    public void setNumero(String numero){
        this.numero=numero;
    }

    public String getComplement(){
        return complement;
    }

    public void setComplement(String complement){
        this.complement=complement;
    }


}
