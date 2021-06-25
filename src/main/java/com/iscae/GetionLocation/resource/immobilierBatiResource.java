package com.iscae.GetionLocation.resource;


import com.iscae.GetionLocation.model.Image;
import com.iscae.GetionLocation.model.ImmobilierBati;
import com.iscae.GetionLocation.service.ImmobilierBatiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/immobilierbati")
public class immobilierBatiResource {

    private  final ImmobilierBatiService immobilierBatiService;

    public immobilierBatiResource(ImmobilierBatiService immobilierBatiService) {
        this.immobilierBatiService = immobilierBatiService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ImmobilierBati>> getAllImmoblierBati() {
        List<ImmobilierBati> immobilierBatis = immobilierBatiService.findAllImmobilierBati();

        return new ResponseEntity<>(immobilierBatis, HttpStatus.OK);
    }

    @GetMapping("/pc1")
    public ResponseEntity<List<ImmobilierBati>> findImmoblierBatispc1(){

        List<ImmobilierBati> immobilierBatis = immobilierBatiService.findImmoblierBatispc1();
        return new ResponseEntity<>(immobilierBatis, HttpStatus.OK);
    }

    @GetMapping("/pc2")
    public ResponseEntity<List<ImmobilierBati>> findImmoblierBatispc2(){

        List<ImmobilierBati> immobilierBatis = immobilierBatiService.findImmoblierBatispc2();
        return new ResponseEntity<>(immobilierBatis, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<ImmobilierBati> findImmoblierBatiById(@PathVariable("id") Long id){

        ImmobilierBati immobilierBati = immobilierBatiService.findImmoblierBatiById(id);
        return new ResponseEntity<>(immobilierBati, HttpStatus.OK);
    }
    @PostMapping(value = "/add")

    public ResponseEntity<ImmobilierBati> addImmobilierBati(@RequestBody ImmobilierBati immobilierBati) throws IOException {

        immobilierBatiService.addImmoblierBati(immobilierBati);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<ImmobilierBati> updateImmobilierBati(@RequestBody ImmobilierBati immobilierBati) throws IOException {


        ImmobilierBati updateImmobilierBati = immobilierBatiService.updateImmoblierBati(immobilierBati);
        return new ResponseEntity<>(updateImmobilierBati, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteImmobilierBati(@PathVariable("id") Long id) {
        immobilierBatiService.deleteImmoblierBati(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
