package com.iscae.GetionLocation.model;

import org.springframework.data.geo.Point;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="Immobilier")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Immobilier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    protected Long id;
    protected String adresse;
    protected Point localisation;
    protected String numeroPermie;
    protected double longueur;
    protected double largeur;
    protected String idProprietaire;

    public Immobilier(){

    }

    public Immobilier( String adresse, Point localisation, String numeroPermie, double longueur, double largeur, String idProprietaire) {

        this.adresse = adresse;
        this.localisation = localisation;
        this.numeroPermie = numeroPermie;
        this.longueur = longueur;
        this.largeur = largeur;
        this.idProprietaire = idProprietaire;
    }

    public String getIdProprietaire() {
        return idProprietaire;
    }

    public void setIdProprietaire(String idProprietaire) {
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

    public String getNumeroPermie() {
        return numeroPermie;
    }

    public void setNumeroPermie(String numeroPermie) {
        this.numeroPermie = numeroPermie;
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
                ", numeroPermie='" + numeroPermie + '\'' +
                ", longueur=" + longueur +
                ", largeur=" + largeur +
                ", idProprietaire=" + idProprietaire +
                '}';
    }
}
