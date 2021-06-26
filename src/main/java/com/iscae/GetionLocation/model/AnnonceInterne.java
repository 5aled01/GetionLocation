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



    public long getIdContrat() {
        return idContrat;
    }

    public void setIdContrat(long idContrat) {
        this.idContrat = idContrat;
    }

    public AnnonceInterne(long idImmobilier, Date dateDebut, String type, String description, long idContrat) {
        super(idImmobilier, dateDebut, type ,description);

        this.idContrat = idContrat;
    }





}
