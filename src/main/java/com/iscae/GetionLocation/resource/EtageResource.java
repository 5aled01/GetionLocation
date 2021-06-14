package com.iscae.GetionLocation.resource;


import com.iscae.GetionLocation.model.Etage;
import com.iscae.GetionLocation.service.EtageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


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
            return new ResponseEntity<>(etages, HttpStatus.OK);

    }

    @GetMapping("/add")
    public ResponseEntity<Etage> addEtage(@RequestBody Etage etage){


        etageService.addEtage(etage);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<List<Etage>> getEtage(@PathVariable("id") Long id){
     List<Etage> etages =   etageService.findEtagesByIdImmobilierBati(id);
     return   new  ResponseEntity<>(etages ,HttpStatus.OK) ;
    }



    @PutMapping("/update")
    public ResponseEntity<Etage> updateUser(@RequestBody Etage etage)  {


        Etage updateEtage = etageService.updateEtage(etage);
        return new ResponseEntity<>(updateEtage, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        etageService.deleteEtage(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
