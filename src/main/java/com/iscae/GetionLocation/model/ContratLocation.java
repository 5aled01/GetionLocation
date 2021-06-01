package com.iscae.GetionLocation.model;

import java.io.Serializable;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class ContratLocation extends Contrat implements Serializable {

    private  double prixProprietaire ;
    private  double prixLocation ;

    public ContratLocation(Long id, Date date_debut, Date date_fin, String description, double prixProprietaire, double prixLocation) {
        super(id, date_debut, date_fin, description);
        this.prixProprietaire = prixProprietaire;
        this.prixLocation = prixLocation;
    }

    public double getPrixProprietaire() {
        return prixProprietaire;
    }

    public void setPrixProprietaire(double prixProprietaire) {
        this.prixProprietaire = prixProprietaire;
    }

    public double getPrixLocation() {
        return prixLocation;
    }

    public void setPrixLocation(double prixLocation) {
        this.prixLocation = prixLocation;
    }
}
