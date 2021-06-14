package com.iscae.GetionLocation.model;

import javax.persistence.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;
import java.util.Arrays;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;


@Entity
public class Image implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;
    private Long idcorespondance;
    private String Corespondance;
    private byte[] image ;


    public Image(Long id, Long idcorespondance, String corespondance, byte[] image) {

        this.id = id;
        this.idcorespondance = idcorespondance;
        Corespondance = corespondance;
        this.image = image;
    }

    public Long getIdcorespondance() {
        return idcorespondance;
    }

    public void setIdcorespondance(Long idcorespondance) {
        this.idcorespondance = idcorespondance;
    }

    public String getCorespondance() {
        return Corespondance;
    }

    public void setCorespondance(String corespondance) {
        Corespondance = corespondance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", idcorespondance=" + idcorespondance +
                ", Corespondance='" + Corespondance + '\'' +
                ", image=" + Arrays.toString(image) +
                '}';
    }

    public static byte[] compressBytes(byte[] data) {

        Deflater deflater = new Deflater();

        deflater.setInput(data);

        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

        byte[] buffer = new byte[1024];

        while (!deflater.finished()) {

            int count = deflater.deflate(buffer);

            outputStream.write(buffer, 0, count);
        }

        try {

            outputStream.close();

        } catch (IOException e) {

        }

        //  System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

        return outputStream.toByteArray();

    }

    public static byte[] decompressBytes(byte[] data) {

        Inflater inflater = new Inflater();

        inflater.setInput(data);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

        byte[] buffer = new byte[1024];

        try {

            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);

                outputStream.write(buffer, 0, count);

            }

            outputStream.close();

        } catch (IOException ioe) {

        } catch (DataFormatException e) {

        }

        return outputStream.toByteArray();

    }

}
