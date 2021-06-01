package com.iscae.GetionLocation.model;
import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Etablissement extends Poprietaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String Nom;
    private String Description;
    private String email;

    public Etablissement(Long id, Long telephone, String adresse) {
        super(id, telephone, adresse);
    }

    public Etablissement(Long id, Long telephone, String adresse, Long id1, String nom, String description, String email) {
        super(id, telephone, adresse);
        this.id = id1;
        Nom = nom;
        Description = description;
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
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
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
                ", Nom='" + Nom + '\'' +
                ", Description='" + Description + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
