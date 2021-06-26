package com.iscae.GetionLocation.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
@Entity
@Table(name="Annonce")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Annonce implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private long id;
    private long idImmobilier;
    private Date dateDebut;
    private String type;
    private String description;
    public Annonce(){}


    public Annonce(  long idImmobilier, Date dateDebut, String type, String description) {

        this.idImmobilier = idImmobilier;
        this.dateDebut = dateDebut;
        this.type = type;
        this.description = description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getIdImmobilier() {
        return idImmobilier;
    }

    public void setIdImmobilier(long idImmobilier) {
        this.idImmobilier = idImmobilier;
    }

    public Date getDate_debut() {
        return dateDebut;
    }

    public void setDate_debut(Date date_debut) {
        this.dateDebut = date_debut;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Annonce{" +
                "id=" + id +
                ", idImmobilier=" + idImmobilier +
                ", date_debut=" + dateDebut +
                ", type='" + type + '\'' +
                '}';
    }
}
