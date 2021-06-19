package com.iscae.GetionLocation.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="annonceexterne")
public class AnnonceExterne extends Annonce{
@Column
    private  double fraisAnnonce ;
    private Date dateFinAnnonce ;
    private  double prxiImmobilier ;

    public AnnonceExterne() {
    }

    public AnnonceExterne(long idImmobilier, Date dateDebu, String type, String description, double fraisAnnonce, Date dateFinAnnonce, double prxiImmobilier) {
        super(idImmobilier, dateDebu, type ,description);
        this.fraisAnnonce = fraisAnnonce;
        this.dateFinAnnonce = dateFinAnnonce;
        this.prxiImmobilier = prxiImmobilier;
    }

    public double getFraisAnnonce() {
        return fraisAnnonce;
    }

    public void setFraisAnnonce(double fraisAnnonce) {
        this.fraisAnnonce = fraisAnnonce;
    }

    public double getCoutAnnonce() {
        return fraisAnnonce;
    }

    public void setCoutAnnonce(double coutAnnonce) {
        this.fraisAnnonce = coutAnnonce;
    }

    public Date getDateFinAnnonce() {
        return dateFinAnnonce;
    }

    public void setDateFinAnnonce(Date dateFinAnnonce) {
        this.dateFinAnnonce = dateFinAnnonce;
    }

    public double getPrxiImmobilier() {
        return prxiImmobilier;
    }

    public void setPrxiImmobilier(double prxiImmobilier) {
        this.prxiImmobilier = prxiImmobilier;
    }

    @Override
    public String toString() {
        return "AnnonceExterne{" +
                "coutAnnonce=" + fraisAnnonce +
                ", dateFinAnnonce=" + dateFinAnnonce +
                ", prxiImmobilier=" + prxiImmobilier +
                '}';
    }
}
