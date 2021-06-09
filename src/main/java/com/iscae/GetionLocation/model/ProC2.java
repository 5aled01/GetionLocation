package com.iscae.GetionLocation.model;

import java.io.Serializable;
import javax.persistence.*;
import java.io.Serializable;
@Entity
public class ProC2 extends Proprietaire {

    private String nom;
    private String prenom;
    private Long NNI;
    private Long numCompe;
    private String proNom ;
    private String password;
    public ProC2() {
           }

    @Override
    public String toString() {
        return "ProC2{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", NNI=" + NNI +
                ", numCompe=" + numCompe +
                ", proNom='" + proNom + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public ProC2(Long telephone, String adresse, byte[] img, String nom, String prenom, Long NNI, Long numCompe, String proNom, String password) {
        super(telephone, adresse, img);
        this.nom = nom;
        this.prenom = prenom;
        this.NNI = NNI;
        this.numCompe = numCompe;
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

    public Long getNumCompe() {
        return numCompe;
    }

    public void setNumCompe(Long numCompe) {
        this.numCompe = numCompe;
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

    public void setPassword(String password) {
        this.password = password;
    }
}

