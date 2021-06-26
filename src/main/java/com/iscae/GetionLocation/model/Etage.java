package com.iscae.GetionLocation.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Etage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private long id ;
    private long numEtage;
    private long idImmobilierBati;
    private String description;
    private long nbrChambre;
    private long nbrCuisin;
    private long nbrDouche;
    private long nbrSalle;
    private long nbrGarage;

    public Etage(long id, long numEtage, long idImmobilierBati, String description, long nbrChambre, long nbrCuisin, long nbrDouche, long nbrSalle, long nbrGarage) {
        this.id = id;
        this.numEtage = numEtage;
        this.idImmobilierBati = idImmobilierBati;
        this.description = description;
        this.nbrChambre = nbrChambre;
        this.nbrCuisin = nbrCuisin;
        this.nbrDouche = nbrDouche;
        this.nbrSalle = nbrSalle;
        this.nbrGarage = nbrGarage;
    }

    public Etage() {
    }

    public long getNbrChambre() {
        return nbrChambre;
    }

    public void setNbrChambre(long nbrChambre) {
        this.nbrChambre = nbrChambre;
    }

    public long getNbrCuisin() {
        return nbrCuisin;
    }

    public void setNbrCuisin(long nbrCuisin) {
        this.nbrCuisin = nbrCuisin;
    }

    public long getNbrDouche() {
        return nbrDouche;
    }

    public void setNbrDouche(long nbrDouche) {
        this.nbrDouche = nbrDouche;
    }

    public long getNbrSalle() {
        return nbrSalle;
    }

    public void setNbrSalle(long nbrSalle) {
        this.nbrSalle = nbrSalle;
    }

    public long getNbrGarage() {
        return nbrGarage;
    }

    public void setNbrGarage(long nbrGarage) {
        this.nbrGarage = nbrGarage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getIdImmobilierBati() {
        return idImmobilierBati;
    }

    public void setIdImmobilierBati(long idImmobilierBati) {
        this.idImmobilierBati = idImmobilierBati;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumEtage() {
        return numEtage;
    }

    public void setNumEtage(long numEtage) {
        this.numEtage = numEtage;
    }


    @Override
    public String toString() {
        return "Etage{" +
                "id=" + id +
                ", numEtage=" + numEtage +
                ", idImmobilierBati=" + idImmobilierBati +
                ", description=" + description +
                '}';
    }
}
