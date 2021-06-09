package com.iscae.GetionLocation.model;
import javax.persistence.*;
import java.io.Serializable;
@Entity
public class ProC1 extends Proprietaire {

    private String nom;
    private String prenom;
    private Long NNI;
    private Long numcompo;
    private String proNom ;
    private String password;


    public  ProC1 (){
        super();
    }
    public ProC1(Long telephone, String adresse, byte[] img, String nom, String prenom, Long NNI, Long numcompo, String proNom, String password) {
        super(telephone, adresse, img);
        this.nom = nom;
        this.prenom = prenom;
        this.NNI = NNI;
        this.numcompo = numcompo;
        this.proNom = proNom;
        this.password = password;
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

    public Long getNNI() {
        return NNI;
    }

    public void setNNI(Long NNI) {
        this.NNI = NNI;
    }

    public Long getNumcompo() {
        return numcompo;
    }

    public void setNumcompo(Long numcompo) {
        this.numcompo = numcompo;
    }

    public String getProNom() {
        return proNom;
    }

    public void setProNom(String proNom) {
        this.proNom = proNom;
    }

    public String getPassword() {
        return password;
    }

    public String setPassword(String password) {
        return this.password = password;
    }

    @Override
    public String toString() {
        return "ProC1{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", NNI=" + NNI +
                ", numcompo=" + numcompo +
                ", proNom='" + proNom + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}


