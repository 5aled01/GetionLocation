package com.iscae.GetionLocation.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class DecisionVente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String description;
    private double prix;

    public DecisionVente(Long id, String description, double prix) {
        this.id = id;
        this.description = description;
        this.prix = prix;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Decision_vente{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                '}';
    }

}
