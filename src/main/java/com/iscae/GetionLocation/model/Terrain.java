package com.iscae.GetionLocation.model;

import org.springframework.data.geo.Point;

import javax.persistence.Entity;

@Entity
public class Terrain  extends  Immobilier {
    private  String description ;
  public Terrain (){
      super();
  }

    public Terrain(String description) {
        this.description = description;
    }

    public Terrain( String adresse, Point localisation, String numPermie, double longueur, double largeur, int idProprietaire, String description) {
        super( adresse, localisation, numPermie, longueur, largeur, idProprietaire);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Terrain{" +
                "id=" + id +
                ", adresse='" + adresse + '\'' +
                ", localisation=" + localisation +
                ", numPermie='" + numeroPermie + '\'' +
                ", longueur=" + longueur +
                ", largeur=" + largeur +
                ", idProprietaire=" + idProprietaire +
                ", description='" + description + '\'' +
                '}';
    }
}
