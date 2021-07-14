package com.iscae.GetionLocation.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;

@Entity
@Table(name="client")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String Nom;
    private String Prenom;
    private String Authnom;
    private Long nni;
    private Long Telephone;
    private String password ;
    @Lob
    private byte[] image;

    public Client() {
    }

    public Client(Long id, String nom, String prenom,String Authnom ,Long nni, Long telephone, String password, byte[] image) {
        this.id = id;
        Nom = nom;
        Prenom = prenom;
        this.Authnom =Authnom;
        this.nni = nni;
        Telephone = telephone;
        this.password = password;
        this.image = image;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getAuthnom() {
        return Authnom;
    }

    public void setAuthnom(String authnom) {
        Authnom = authnom;
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

    public Long getNni() {
        return nni;
    }

    public void setNni(Long nni) {
        this.nni = nni;
    }

    public Long getTelephone() {
        return Telephone;
    }

    public void setTelephone(Long telephone) {
        Telephone = telephone;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", Nom='" + Nom + '\'' +
                ", Prenom='" + Prenom + '\'' +
                ", Authnom='" + Authnom + '\'' +
                ", nni=" + nni +
                ", Telephone=" + Telephone +
                ", password='" + password + '\'' +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
