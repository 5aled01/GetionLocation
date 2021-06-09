package com.iscae.GetionLocation.resource;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.iscae.GetionLocation.model.Etage;
import com.iscae.GetionLocation.model.User;
import com.iscae.GetionLocation.service.EtageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@RequestMapping("/etage")
public class EtageResource {
    private final EtageService etageService;

    public EtageResource(EtageService etageService) {
        this.etageService = etageService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Etage>> getAllEtage() {
        List<Etage> etages = etageService.findAllEtages();
        for (Etage etage : etages) {
            if (!etage.getImage().equals(null)) {
                etage.setImage(decompressBytes(etage.getImage()));
            } }
            return new ResponseEntity<>(etages, HttpStatus.OK);

    }

    public ResponseEntity<Etage> addEtage(@RequestParam("etage") String etagest, @RequestParam("imageFile") MultipartFile imageFile) throws IOException {

        Etage etage = new ObjectMapper().readValue(etagest, Etage.class);
         etage.setImage(compressBytes(imageFile.getBytes()));
        etageService.addEtage(etage);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }


    @PutMapping("/updatewithimg")
    public ResponseEntity<Etage> updateEtage(@RequestParam("etage") String etagest, @RequestParam("imageFile") MultipartFile imageFile) throws IOException {

        Etage etage = new ObjectMapper().readValue(etagest, Etage.class);

        etage.setImage(compressBytes(imageFile.getBytes()));
        Etage updateEtage = etageService.updateEtage(etage);
        return new ResponseEntity<>(updateEtage, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Etage> updateUser(@RequestParam("etage") String etagest) throws IOException {

        Etage etage = new ObjectMapper().readValue(etagest, Etage.class);
        Optional<Etage> etage1 = etageService.findById(etage.getId());
        etage.setImage(etage.getImage());
        Etage updateEtage = etageService.updateEtage(etage);
        return new ResponseEntity<>(updateEtage, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        etageService.deleteEtage(id);
        return new ResponseEntity<>(HttpStatus.OK);
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
