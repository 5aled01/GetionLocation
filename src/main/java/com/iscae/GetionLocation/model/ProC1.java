package com.iscae.GetionLocation.model;
import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="proc1")
public  class ProC1 extends Proprietaire implements Serializable {

    public String nom;
    public String prenom;
    public Long nni;
    public Long numcomp;




    public ProC1(Long telephone, byte[] img, String nom, String prenom, Long nni, Long numcomp ) {
        super(telephone, img);
        this.nom = nom;
        this.prenom = prenom;
        this.nni = nni;
        this.numcomp = numcomp;

    }

    public ProC1() {
        super();
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
        return nni;
    }

    public void setNNI(Long NNI) {
        this.nni = NNI;
    }

    public Long getNumcompo() {
        return numcomp;
    }

    public void setNumcompo(Long numcompo) {
        this.numcomp = numcompo;
    }





    public Long getNumcomp() {
        return numcomp;
    }

    public void setNumcomp(Long numcomp) {
        this.numcomp = numcomp;
    }


    @Override
    public String toString() {
        return "ProC1{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", NNI=" + nni +
                ", numcompo=" + numcomp +

                '}';
    }

}


