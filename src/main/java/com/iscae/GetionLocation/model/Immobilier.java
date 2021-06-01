package com.iscae.GetionLocation.model;

import org.springframework.data.geo.Point;

import javax.persistence.*;
import java.io.Serializable;
@MappedSuperclass
public class Immobilier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    protected Long id;
    protected String adresse;
    protected Point localisation;
    protected String numPermie;
    protected double longueur ;
    protected double largeur ;
    protected int idProprietaire;


public Immobilier(Long id,int idProprietaire, String adresse, Point localisation, String nPermie, double longueur, double largeur) {
        this.id = id;
        this.adresse = adresse;
        this.localisation = localisation;
        this.numPermie = nPermie;
        this.longueur = longueur;
        this.largeur = largeur;
        this.idProprietaire=idProprietaire;
    }

    public int getIdProprietaire() {
        return idProprietaire;
    }

    public void setIdProprietaire(int idProprietaire) {
        this.idProprietaire = idProprietaire;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Point getLocalisation() {
        return localisation;
    }

    public void setLocalisation(Point localisation) {
        this.localisation = localisation;
    }

    public String getnPermie() {
        return numPermie;
    }

    public void setnPermie(String nPermie) {
        this.numPermie = nPermie;
    }

    public double getLongueur() {
        return longueur;
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    @Override
    public String toString() {
        return "Immobilier{" +
                "id=" + id +
                ", adresse='" + adresse + '\'' +
                ", localisation=" + localisation +
                ", numPermie='" + numPermie + '\'' +
                ", longueur=" + longueur +
                ", largeur=" + largeur +
                ", idProprietaire=" + idProprietaire +
                '}';
    }
}
