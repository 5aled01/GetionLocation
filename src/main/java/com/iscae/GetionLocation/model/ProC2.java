package com.iscae.GetionLocation.model;

import java.io.Serializable;
import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="proc2")
public class ProC2 extends Proprietaire implements Serializable{

    private String nom;
    private String prenom;
    private Long nni;
  private  Long  numcomp;
    private String pronom ;
    private String password;
    public ProC2() {
        super();
           }

    public ProC2(Long telephone, byte[] img, String nom, String prenom, Long nni, Long numcomp, String pronom, String password) {
        super(telephone, img);
        this.nom = nom;
        this.prenom = prenom;
        this.nni = nni;
        this.numcomp = numcomp;
        this.pronom = pronom;
        this.password = password;
    }

    public Long getNni() {
        return nni;
    }

    public void setNni(Long nni) {
        this.nni = nni;
    }

    public Long getNumcomp() {
        return numcomp;
    }

    public void setNumcomp(Long numcomp) {
        this.numcomp = numcomp;
    }

    @Override
    public String toString() {
        return "ProC2{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", NNI=" + nni +
                ", numCompe=" + numcomp +
                ", pronom='" + pronom + '\'' +
                ", password='" + password + '\'' +
                '}';
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



    public String getPronom() {
        return pronom;
    }

    public void setPronom(String pronom) {
        this.pronom = pronom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

