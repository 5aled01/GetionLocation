package com.iscae.GetionLocation.model;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="piece")
public class Piece  implements  Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private long Id ;
    private long IdEtage ;
    private String nom;
    private double longueur ;
    private  double largeur ;


    public Piece( String nom, double longueur, double largeur, long IdEtage) {

        this.IdEtage = IdEtage;
        this.nom = nom;
        this.longueur = longueur;
        this.largeur = largeur;

    }

    public long getIdEtage() {
        return IdEtage;
    }

    public void setIdEtage(long idEtage) {
        IdEtage = idEtage;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
        return "Piece{" +
                "Id=" + Id +
                ", IdEtage=" + IdEtage +
                ", nom='" + nom + '\'' +
                ", longueur=" + longueur +
                ", largeur=" + largeur +
                '}';
    }
}
