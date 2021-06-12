package com.iscae.GetionLocation.model;

import java.io.Serializable;
import javax.persistence.*;
import java.io.Serializable;
@Entity
public class ProC2 extends Proprietaire {

    private String nom;
    private String prenom;
    private int nni;
    private Long numComp;
    private String pronom ;
    private String password;
    public ProC2() {
           }

    public ProC2(String nom, String prenom, int nni, Long numCompe, String pronom, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.nni = nni;
        this.numComp = numComp;
        this.pronom = pronom;
        this.password = password;
    }

    public ProC2(Long telephone, byte[] img, String nom, String prenom, int NNI, Long numComp, String pronom, String password) {
        super(telephone, img);
        this.nom = nom;
        this.prenom = prenom;
        this.nni = NNI;
        this.numComp = numComp;
        this.pronom = pronom;
        this.password = password;
    }

    @Override
    public String toString() {
        return "ProC2{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", NNI=" + nni +
                ", numCompe=" + numComp +
                ", proNom='" + pronom + '\'' +
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

    public int getNNI() {
        return nni;
    }

    public void setNNI(int NNI) {
        this.nni = NNI;
    }

    public Long getNumCompe() {
        return numComp ;
    }

    public void setNumCompe(Long numCompe) {
        this.numComp = numCompe;
    }

    public Long getNumComp() {
        return numComp;
    }

    public void setNumComp(Long numComp) {
        this.numComp = numComp;
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

