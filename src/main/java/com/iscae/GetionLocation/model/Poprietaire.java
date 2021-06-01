package com.iscae.GetionLocation.model;
import javax.persistence.*;
import java.io.Serializable;
@MappedSuperclass
public class Poprietaire implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;
    protected Long Telephone;
    protected String adresse;

    public Poprietaire(Long id, Long telephone, String adresse) {
        this.id = id;
        Telephone = telephone;
        this.adresse = adresse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTelephone() {
        return Telephone;
    }

    public void setTelephone(Long telephone) {
        Telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Poprietaire{" +
                "id=" + id +
                ", Telephone=" + Telephone +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
