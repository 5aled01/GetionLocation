package com.iscae.GetionLocation.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
@Entity
public class DemandeReservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;
    private Long idProprietaire;
    private Long idAnnonce ;
    private Long idClient;
    private Date date ;
    private String etats;
    private String duree;

    public   DemandeReservation(Long id, Long idProprietaire, Long idAnnonce, Long idClient, Date date, String etats, String duree) {
        this.id = id;
        this.idProprietaire = idProprietaire;
        this.idAnnonce = idAnnonce;
        this.idClient = idClient;
        this.date = date;
        this.etats = etats;
        this.duree = duree;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProprietaire() {
        return idProprietaire;
    }

    public void setIdProprietaire(Long idProprietaire) {
        this.idProprietaire = idProprietaire;
    }

    public Long getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(Long idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEtats() {
        return etats;
    }

    public void setEtats(String etats) {
        this.etats = etats;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    @Override
    public String toString() {
        return "DemandeReservation{" +
                "id=" + id +
                ", idProprietaire=" + idProprietaire +
                ", idAnnonce=" + idAnnonce +
                ", idClient=" + idClient +
                ", date=" + date +
                ", etats='" + etats + '\'' +
                ", duree='" + duree + '\'' +
                '}';
    }
}
