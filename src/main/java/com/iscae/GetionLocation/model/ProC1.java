package com.iscae.GetionLocation.model;
import javax.persistence.*;
import java.io.Serializable;
@Entity
public class ProC1 extends Proprietaire {

    private String nom;
    private String prenom;
    private Long NNI;
    private Long numcomp;
    private String pronom ;
    private String password;


    public  ProC1 (){
        super();
    }

    public ProC1(String nom, String prenom, Long NNI, Long numcomp, String pronom, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.NNI = NNI;
        this.numcomp = numcomp;
        this.pronom = pronom;
        this.password = password;
    }

    public ProC1(Long telephone, byte[] img, String nom, String prenom, Long NNI, Long numcomp, String pronom, String password) {
        super(telephone, img);
        this.nom = nom;
        this.prenom = prenom;
        this.NNI = NNI;
        this.numcomp = numcomp;
        this.pronom = pronom;
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
        return numcomp;
    }

    public void setNumcompo(Long numcompo) {
        this.numcomp = numcompo;
    }




    public String getPassword() {
        return password;
    }

    public String setPassword(String password) {
        return this.password = password;
    }

    public Long getNumcomp() {
        return numcomp;
    }

    public void setNumcomp(Long numcomp) {
        this.numcomp = numcomp;
    }

    public String getPronom() {
        return pronom;
    }

    public void setPronom(String pronom) {
        this.pronom = pronom;
    }

    @Override
    public String toString() {
        return "ProC1{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", NNI=" + NNI +
                ", numcompo=" + numcomp +
                ", proNom='" + pronom + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}


