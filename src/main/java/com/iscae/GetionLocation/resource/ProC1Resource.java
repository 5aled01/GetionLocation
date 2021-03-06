package com.iscae.GetionLocation.resource;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.iscae.GetionLocation.model.ProC1;
import com.iscae.GetionLocation.model.Proprietaire;
import com.iscae.GetionLocation.service.ProC1Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@RequestMapping("/proc1")
public class ProC1Resource {
    private final ProC1Service proC1Service;

    public ProC1Resource(ProC1Service proC1Service) {
        this.proC1Service = proC1Service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProC1>> getAllProC1() {
        List<ProC1> proC1s = proC1Service.findAllProC1();
        for (ProC1 proC1 : proC1s) {
            if(proC1.getImg()!=null)
            proC1.setImg(decompressBytes(proC1.getImg()));
        }
        return new ResponseEntity<>(proC1s, HttpStatus.OK);
    }



    @GetMapping("/findnom/{id}")
    public ProC1 getProNom(@PathVariable("id") int id
                                                                     ) {
        ProC1 p = proC1Service.findProC1ById(id);
        return p ;
    }
    @GetMapping("/find/{id}")
    public ProC1 getProC1(@PathVariable("id") Long id) {
       return   proC1Service.findProC1ById(id);
    }

    @PostMapping(value = "/add")

    public ResponseEntity<ProC1> addProC1(@RequestParam("proC1") String proC1st ,@RequestParam("imageFile") MultipartFile imageFile ) throws IOException {

        ProC1 proC1 = new ObjectMapper().reader().forType(ProC1.class).readValue(proC1st);


        proC1.setImg(compressBytes(imageFile.getBytes()));
        proC1Service.addProC1(proC1);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/updatewithimg")
    public ResponseEntity<ProC1> updateUser(@RequestParam("proC1") String proC1st, @RequestParam("imageFile") MultipartFile imageFile) throws IOException {

        ProC1 proc1 = new ObjectMapper().reader().forType(ProC1.class).readValue(proC1st);

        proc1.setImg(compressBytes(imageFile.getBytes()));
        ProC1 updateProc1 = proC1Service.updateProC1(proc1);
        return new ResponseEntity<>(updateProc1, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<ProC1> updateProC1(@RequestParam("proC1") String proC1st) throws IOException {

        ProC1 proC1 = new ObjectMapper().reader().forType(ProC1.class).readValue(proC1st);
        ProC1 proC11 = proC1Service.findProC1ById(proC1.getId());
        proC1.setImg(proC11.getImg());
        ProC1 updateProC1 = proC1Service.updateProC1(proC1);
        return new ResponseEntity<>(updateProC1, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProC1(@PathVariable("id") Long id) {
        proC1Service.deleteProC1(id);
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
