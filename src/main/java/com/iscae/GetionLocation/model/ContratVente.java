package com.iscae.GetionLocation.model;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="contratvente")
public class ContratVente extends Contrat{
    private Long PrixProprietaire;
    private Long CommutionAgence;

    public ContratVente(Date dateDebut, Date dateFin, String description, Long idPro, Long prixProprietaire, Long commutionAgence) {
        super(dateDebut, dateFin, description, idPro);
        PrixProprietaire = prixProprietaire;
        CommutionAgence = commutionAgence;
    }

    public ContratVente() {
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
