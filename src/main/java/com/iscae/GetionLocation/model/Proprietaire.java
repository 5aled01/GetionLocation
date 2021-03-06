package com.iscae.GetionLocation.model;
import javax.persistence.*;
import java.io.Serializable;



@MappedSuperclass
public class Proprietaire implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;
    protected Long Telephone;
    @Lob
    private  byte[] img ;
    public Proprietaire(){

    }

    public Proprietaire( Long telephone,  byte[] img){
        this.img=img ;
        Telephone = telephone;

    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
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



    @Override
    public String toString() {
        return "Proprietaire{" +
                "id=" + id +
                ", Telephone=" + Telephone +

                '}';
    }
}
