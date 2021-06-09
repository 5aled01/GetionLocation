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
    private Long id;
    private Long idImmobilier;
    private Date dateDebut;
    private String type;

    public Annonce(){}

    public Annonce(Long idImmobilier, Date dateDebut, String type) {

        this.idImmobilier = idImmobilier;
        this.dateDebut = dateDebut;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdImmobilier() {
        return idImmobilier;
    }

    public void setIdImmobilier(Long idImmobilier) {
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
