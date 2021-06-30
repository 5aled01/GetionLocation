package com.iscae.GetionLocation.model;

import org.springframework.data.geo.Point;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="terrain")
public class Terrain  extends  Immobilier {
    private  String description ;
  public Terrain (){
      super();
  }

    public Terrain(String description) {
        this.description = description;
    }

    public Terrain(Long id, String adresse, Point localisation, String numeroPermie, double longueur, double largeur, long idProprietaire, String typeProprietaire, String description) {
        super(id, adresse, localisation, numeroPermie, longueur, largeur, idProprietaire, typeProprietaire);
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
