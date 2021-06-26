package com.iscae.GetionLocation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
@Entity
@Table(name="annonceinterne")
public class AnnonceInterne extends  Annonce {
@Column

private  long idContrat ;
    public AnnonceInterne(){}



    public AnnonceInterne(long id, long idImmobilier, Date dateDebut, String type, String etats, String description, long idContrat) {
        super(id, idImmobilier, dateDebut, type, etats, description);
        this.idContrat = idContrat;
    }

    public long getIdContrat() {
        return idContrat;
    }

    public void setIdContrat(long idContrat) {
        this.idContrat = idContrat;
    }






}
