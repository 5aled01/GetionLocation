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
    private long description;




    public Etage(long id, long numEtage, long idImmobilierBati, long description) {
        this.id = id;
        this.numEtage = numEtage;
        this.idImmobilierBati = idImmobilierBati;
        this.description = description;
    }

    public Etage() {
    }

    public long getDescription() {
        return description;
    }

    public void setDescription(long description) {
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
