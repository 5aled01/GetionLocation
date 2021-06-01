package com.iscae.GetionLocation.model;

import java.io.Serializable;
import javax.persistence.*;
import java.io.Serializable;
@Entity
public class ProC2 extends Poprietaire implements Serializable {

    private String Nom;
    private String Prenom;
    private Long NNI;
    private Long Num_compe;

    public ProC2(Long id, Long telephone, String adresse) {
        super(id, telephone, adresse);
    }

    public ProC2(Long id, Long telephone, String adresse, Long id1, String nom, String prenom, Long NNI, Long num_compe) {
        super(id, telephone, adresse);
        Nom = nom;
        Prenom = prenom;
        this.NNI = NNI;
        Num_compe = num_compe;
    }



    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public Long getNNI() {
        return NNI;
    }

    public void setNNI(Long NNI) {
        this.NNI = NNI;
    }

    public Long getNum_compe() {
        return Num_compe;
    }

    public void setNum_compe(Long num_compe) {
        Num_compe = num_compe;
    }

    @Override
    public String toString() {
        return "Pro_c2{" +
                "Telephone=" + Telephone +
                ", adresse='" + adresse + '\'' +
                ", Nom='" + Nom + '\'' +
                ", Prenom='" + Prenom + '\'' +
                ", NNI=" + NNI +
                ", Num_compe=" + Num_compe +
                '}';
    }
}

