package com.iscae.GetionLocation.model;

import org.springframework.data.geo.Point;

import javax.persistence.Entity;
import java.io.Serializable;
@Entity
public class Terrain  extends  Immobilier {
    private  String description ;
  public Terrain (){
      super();
  }

    public Terrain(String description) {
        this.description = description;
    }

    public Terrain(Long id, String adresse, Point localisation, String numPermie, double longueur, double largeur, int idProprietaire, String description) {
        super(id, adresse, localisation, numPermie, longueur, largeur, idProprietaire);
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
                ", numPermie='" + numPermie + '\'' +
                ", longueur=" + longueur +
                ", largeur=" + largeur +
                ", idProprietaire=" + idProprietaire +
                ", description='" + description + '\'' +
                '}';
    }
}
