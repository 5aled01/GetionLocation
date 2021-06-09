package com.iscae.GetionLocation.model;

import org.springframework.data.geo.Point;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class ImmoblierBati extends Immobilier {
    private  String nom ;
    private  double longueurBati;
    private  double largeurBati;




    public ImmoblierBati( int idProprietaire, String adresse, Point localisation, String nPermie, double longueur, double largeur, String nom, double longueurBati, double largeurBati) {
        super(idProprietaire, adresse, localisation, nPermie, longueur, largeur);
        this.nom = nom;
        this.longueurBati = longueurBati;
        this.largeurBati = largeurBati;

    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getLongueurBati() {
        return longueurBati;
    }

    public void setLongueurBati(double longueurBati) {
        this.longueurBati = longueurBati;
    }

    public double getLargeurBati() {
        return largeurBati;
    }

    public void setLargeurBati(double largeurBati) {
        this.largeurBati = largeurBati;
    }

    @Override
    public String toString() {
        return "ImmoblierBati{" +
                "id=" + id +
                ", adresse='" + adresse + '\'' +
                ", localisation=" + localisation +
                ", numPermie='" + numPermie + '\'' +
                ", longueur=" + longueur +
                ", largeur=" + largeur +
                ", idProprietaire=" + idProprietaire +
                ", nom='" + nom + '\'' +
                ", longueurBati=" + longueurBati +
                ", largeurBati=" + largeurBati +
                '}';
    }
}

