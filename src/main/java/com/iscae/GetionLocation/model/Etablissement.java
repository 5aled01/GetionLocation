package com.iscae.GetionLocation.model;
import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="Etablissement")
public class Etablissement extends Proprietaire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String nom;
    private String description;
    private String email;

    public Etablissement(Long id, String nom, String description, String email) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.email = email;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Etablissement{" +
                "id=" + id +
                ", Nom='" + nom + '\'' +
                ", Description='" + description + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
