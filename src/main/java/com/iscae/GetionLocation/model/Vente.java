package com.iscae.GetionLocation.model;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="vente")
public class Vente implements  Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;
    private Date date_vente;
    private Long idcontrat_vent;
    private Long id_decision;
    private Long id_Client;
    private Long id_immobilier;

    public Vente() {
    }

    public Vente(Date date_vente, Long idcontrat_vent, Long id_decision, Long id_Client, Long id_immobilier) {

        this.date_vente = date_vente;
        this.idcontrat_vent = idcontrat_vent;
        this.id_decision = id_decision;
        this.id_Client = id_Client;
        this.id_immobilier = id_immobilier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate_vente() {
        return date_vente;
    }

    public void setDate_vente(Date date_vente) {
        this.date_vente = date_vente;
    }


    public Long getIdcontrat_vent() {
        return idcontrat_vent;
    }

    public void setIdcontrat_vent(Long idcontrat_vent) {
        this.idcontrat_vent = idcontrat_vent;
    }

    public Long getId_decision() {
        return id_decision;
    }

    public void setId_decision(Long id_decision) {
        this.id_decision = id_decision;
    }

    public Long getId_Client() {
        return id_Client;
    }

    public void setId_Client(Long id_Client) {
        this.id_Client = id_Client;
    }

    public Long getId_immobilier() {
        return id_immobilier;
    }

    public void setId_immobilier(Long id_immobilier) {
        this.id_immobilier = id_immobilier;
    }

    @Override
    public String toString() {
        return "Vente{" +
                "id=" + id +
                ", date_vente=" + date_vente +
                ", idcontrat_vent=" + idcontrat_vent +
                ", id_decision=" + id_decision +
                ", id_Client=" + id_Client +
                ", id_immobilier=" + id_immobilier +
                '}';
    }
}
