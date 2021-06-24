package com.iscae.GetionLocation.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
@Entity
@Table(name="DemandeReservation")
public class DemandeReservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String idAnnonce ;
    private String type;
    private Long idClient;
    private Date date ;
    private String etats;
    private Date duree;

    public DemandeReservation(Long id, String idAnnonce, String type, Long idClient, Date date, String etats, Date duree) {
        this.id = id;
        this.idAnnonce = idAnnonce;
        this.type = type;
        this.idClient = idClient;
        this.date = date;
        this.etats = etats;
        this.duree = duree;
    }

    public DemandeReservation() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(String idAnnonce) {
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

    public Date getDuree() {
        return duree;
    }

    public void setDuree(Date duree) {
        this.duree = duree;
    }

    @Override
    public String toString() {
        return "DemandeReservation{" +
                "id=" + id +

                ", idAnnonce=" + idAnnonce +
                ", idClient=" + idClient +
                ", date=" + date +
                ", etats='" + etats + '\'' +
                ", duree='" + duree + '\'' +
                '}';
    }
}
