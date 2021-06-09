package com.iscae.GetionLocation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
@Entity
@Table(name="AnnonceInterne")
public class AnnonceInterne extends  Annonce {
@Column
    private String description ;

    public AnnonceInterne(){}
    public AnnonceInterne( Long idImmobilier, Date dateDebu, String type, String description) {
        super( idImmobilier, dateDebu, type);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "AnnonceInterne{" +
                "description='" + description + '\'' +
                '}';
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
