package com.iscae.GetionLocation.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="AnnonceInterne")
public class Client implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String Nom;
    private String Prenom;
    private Long NNI;
    private Long Telephone;
    private String image;

    public Client( String nom, String prenom, Long NNI, Long telephone, String image) {

        Nom = nom;
        Prenom = prenom;
        this.NNI = NNI;
        Telephone = telephone;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getTelephone() {
        return Telephone;
    }

    public void setTelephone(Long telephone) {
        Telephone = telephone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", Nom='" + Nom + '\'' +
                ", Prenom='" + Prenom + '\'' +
                ", NNI=" + NNI +
                ", Telephone=" + Telephone +
                ", image='" + image + '\'' +
                '}';
    }
}
