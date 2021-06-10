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


    public Etage( long numEtage) {
        this.numEtage = numEtage;

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
