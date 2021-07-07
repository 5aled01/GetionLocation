package com.iscae.GetionLocation.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="location")
public class Location implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;
    private Long idClient ;
    private Date dateDebut ;
    private Date dateFin ;
    private double montEncais;
    private Long idcontratLocalition;

    public Location() {
    }

    public Location(Long idClient, Date dateDebut, Date dateFin, double montEncais, Long idcontratLocalition) {
        this.idClient = idClient;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.montEncais = montEncais;
        this.idcontratLocalition = idcontratLocalition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public double getMontEncais() {
        return montEncais;
    }

    public void setMontEncais(double montEncais) {
        this.montEncais = montEncais;
    }

    public Long getIdcontratLocalition() {
        return idcontratLocalition;
    }

    public void setIdcontratLocalition(Long idcontratLocalition) {
        this.idcontratLocalition = idcontratLocalition;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", idClient=" + idClient +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", montEncais=" + montEncais +
                ", idcontratLocalition=" + idcontratLocalition +
                '}';
    }
}
