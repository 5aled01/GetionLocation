package com.iscae.GetionLocation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class AnnonceExterne extends Annonce{
@Column
    private  double coutAnnonce ;
    private Date dateFinAnnonce ;
    private  double prxiImmobilier ;

    public AnnonceExterne(Long id, Long idImmobilier, Date date_debu, String type, double coutAnnonce, Date dateFinAnnonce, double prxiImmobilier) {
        super(id, idImmobilier, date_debu, type);
        this.coutAnnonce = coutAnnonce;
        this.dateFinAnnonce = dateFinAnnonce;
        this.prxiImmobilier = prxiImmobilier;
    }

    public double getCoutAnnonce() {
        return coutAnnonce;
    }

    public void setCoutAnnonce(double coutAnnonce) {
        this.coutAnnonce = coutAnnonce;
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
                "coutAnnonce=" + coutAnnonce +
                ", dateFinAnnonce=" + dateFinAnnonce +
                ", prxiImmobilier=" + prxiImmobilier +
                '}';
    }
}
