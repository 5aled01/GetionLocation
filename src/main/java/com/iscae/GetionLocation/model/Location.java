package com.iscae.GetionLocation.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
public class Location implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;
    private Long idClient ;
    private Date date_debut ;
    private Date date_fin ;
    private double mont_encais;
    private Long idcontrat_localition;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public double getMont_encais() {
        return mont_encais;
    }

    public void setMont_encais(double mont_encais) {
        this.mont_encais = mont_encais;
    }

    public Long getIdcontrat_localition() {
        return idcontrat_localition;
    }

    public void setIdconytrat_localition(Long idconytrat_localition) {
        this.idcontrat_localition = idconytrat_localition;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", date_debut=" + date_debut +
                ", date_fin=" + date_fin +
                ", mont_encais=" + mont_encais +
                ", idcontrat_localition=" + idcontrat_localition +
                '}';
    }

    public Location(Long id, Date date_debut, Date date_fin, double mont_encais, Long idconytrat_localition) {
        this.id = id;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.mont_encais = mont_encais;
        this.idcontrat_localition = idconytrat_localition;


    }
}
