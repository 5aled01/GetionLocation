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

    public Etage(long id, long numEtage, long idImmobilierBati) {
        this.id = id;
        this.numEtage = numEtage;
        this.idImmobilierBati = idImmobilierBati;
    }

    public Etage() {
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




}
