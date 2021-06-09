package com.iscae.GetionLocation.model;
import javax.persistence.*;
import java.io.Serializable;
@Entity
public class ProC1 extends Poprietaire {

    private String Nom;
    private String Prenom;
    private Long NNI;
    private Long Numcompo;

    public ProC1(Long id, Long telephone, String adresse, String nom, String prenom, Long NNI, Long numcompo) {

        super(id, telephone, adresse);
        this.Nom = nom;
        this.Prenom = prenom;
        this.NNI = NNI;
        this.Numcompo = numcompo;

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

    public Long getNumcompo() {
        return Numcompo;
    }

    public void setNumcompo(Long numcompo) {
        Numcompo = numcompo;
    }

    @Override
    public String toString() {
        return "Pro_c1{" +
                "Telephone=" + Telephone +
                ", adresse='" + adresse + '\'' +
                ", Nom='" + Nom + '\'' +
                ", Prenom='" + Prenom + '\'' +
                ", NNI=" + NNI +
                ", Numcompo=" + Numcompo +
                '}';
    }
}


