package com.iscae.GetionLocation.model;

import java.io.Serializable;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class ContratLocation extends Contrat{

    private  double prixProprietaire ;
    private  double prixLocation ;


    public ContratLocation(Date dateDebut, Date dateFin, String description, Long idPro, double prixProprietaire, double prixLocation) {
        super(dateDebut, dateFin, description, idPro);
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
