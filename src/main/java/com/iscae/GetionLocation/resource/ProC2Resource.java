package com.iscae.GetionLocation.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iscae.GetionLocation.model.ProC1;
import com.iscae.GetionLocation.model.ProC2;
import com.iscae.GetionLocation.model.Proprietaire;
import com.iscae.GetionLocation.model.User;
import com.iscae.GetionLocation.service.ProC2Service;
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
@RequestMapping("/proc2")
public class ProC2Resource {


    private final ProC2Service proC2Service;

    public ProC2Resource(ProC2Service proC2Service) {
        this.proC2Service = proC2Service;
    }


    @GetMapping("/all")
    public ResponseEntity<List<ProC2>> getAllProC2() {
        List<ProC2> proC2s = proC2Service.findAllProC2();
        for (ProC2 proC2 : proC2s) {
            if(proC2.getImg()!=null)
            proC2.setImg(decompressBytes(proC2.getImg()));
        }
        return new ResponseEntity<>(proC2s, HttpStatus.OK);
    }

    @GetMapping("/find/{username}&{password}")
    public ResponseEntity<Proprietaire> getProC1ByUsernameAndPassword(@PathVariable("username") String username,
                                                                      @PathVariable("password") String password) {

        boolean auth = proC2Service.findProC2ProNom(username, password);
        if (auth) {
            Proprietaire proC2 = proC2Service.findUserByUsername2(username);
            proC2.setImg(decompressBytes(proC2.getImg()));
            return new ResponseEntity<>(proC2, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }


    @PostMapping(value = "/add")

    public ResponseEntity<ProC2> addProC2(@RequestBody ProC2 proC2 ) throws IOException {

        // ProC2 proC2 = new ObjectMapper().readValue(proC2st, ProC2.class);
        //   boolean is = proC1Service.findProC1ByProNom(proC2.getProNom()).isPresent();
        // if (!is) {
        //    return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        //}



        //  proC2.setImg(compressBytes(imageFile.getBytes()));
        proC2Service.addProC2(proC2);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/updatewithimg")
    public ResponseEntity<ProC2> updateProC2(@RequestParam("proC1") String proC2st, @RequestParam("imageFile") MultipartFile imageFile) throws IOException {

        ProC2 proc2 = new ObjectMapper().readValue(proC2st, ProC2.class);

        proc2.setImg(compressBytes(imageFile.getBytes()));
        ProC2 updateProc2 = proC2Service.updateProC2(proc2);
        return new ResponseEntity<>(updateProc2, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<ProC2> updateProC2(@RequestParam("proC2") String proC2st) throws IOException {

        ProC2 proC2 = new ObjectMapper().readValue(proC2st, ProC2.class);
        ProC2 proC21 = proC2Service.findProC2ById(proC2.getId());
        proC21.setImg(proC21.getImg());
        ProC2 updateProC2 = proC2Service.updateProC2(proC21);
        return new ResponseEntity<>(updateProC2, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProC2(@PathVariable("id") Long id) {
        proC2Service.deleteProC2(id);
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
