package com.iscae.GetionLocation.model;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class ContratVente extends Contrat implements Serializable{
    private Long PrixProprietaire;
    private Long CommutionAgence;

    public ContratVente(Long id, Date dateDebut, Date dateFin, String description, Long prixProprietaire, Long commutionAgence) {
        super(id, dateDebut, dateFin, description);
        PrixProprietaire = prixProprietaire;
        CommutionAgence = commutionAgence;
    }

    public Long getPrixProprietaire() {
        return PrixProprietaire;
    }

    public void setPrixProprietaire(Long prixProprietaire) {
        PrixProprietaire = prixProprietaire;
    }

    public Long getCommutionAgence() {
        return CommutionAgence;
    }

    public void setCommutionAgence(Long commutionAgence) {
        CommutionAgence = commutionAgence;
    }

    @Override
    public String toString() {
        return "ContratVente{" +
                "PrixProprietaire=" + PrixProprietaire +
                ", CommutionAgence=" + CommutionAgence +
                '}';
    }
}
