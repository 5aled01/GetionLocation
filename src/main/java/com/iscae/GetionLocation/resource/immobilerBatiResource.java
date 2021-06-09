package com.iscae.GetionLocation.resource;


import com.fasterxml.jackson.databind.ObjectMapper;


import com.iscae.GetionLocation.model.ImmoblierBati;
import com.iscae.GetionLocation.model.ProC1;
import com.iscae.GetionLocation.service.ImmobilierBatiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/immobilierbati")
public class immobilerBatiResource {

    private  final ImmobilierBatiService immobilierBatiService;

    public immobilerBatiResource(ImmobilierBatiService immobilierBatiService) {
        this.immobilierBatiService = immobilierBatiService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ImmoblierBati>> getAllImmoblierBati() {
        List<ImmoblierBati> immoblierBatis = immobilierBatiService.findAllImmobilierBati();

        return new ResponseEntity<>(immoblierBatis, HttpStatus.OK);
    }

    @PostMapping(value = "/add")

    public ResponseEntity<ImmoblierBati> addImmoblierBati (@RequestBody ImmoblierBati immoblierBati ) throws IOException {

        immobilierBatiService.addImmoblierBati(immoblierBati);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<ImmoblierBati> updateImmobilierBati(@RequestBody ImmoblierBati immoblierBati ) throws IOException {

        ImmoblierBati updateImmoblierBati = immobilierBatiService.updateImmoblierBati(immoblierBati);
        return new ResponseEntity<>(updateImmoblierBati, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteImmoblierBati(@PathVariable("id") Long id) {
        immobilierBatiService.deleteImmoblierBati(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
