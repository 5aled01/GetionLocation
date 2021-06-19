package com.iscae.GetionLocation.resource;


import com.iscae.GetionLocation.model.Annonce;
import com.iscae.GetionLocation.model.AnnonceExterne;
import com.iscae.GetionLocation.service.AnnonceExterneService;
import com.iscae.GetionLocation.service.AnnonceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/annonceexterne")
public class AnnonceExterneResource {

    private final AnnonceExterneService annonceExterneService ;

    public AnnonceExterneResource(AnnonceExterneService annonceExterneService) {
        this.annonceExterneService = annonceExterneService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<AnnonceExterne>> getAllAnnonceExterne() {
        List<AnnonceExterne> AnnoncesExterne = annonceExterneService.findAllAnnonceExterne();

        return new ResponseEntity<>(AnnoncesExterne, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public Optional<AnnonceExterne> findAnnonceExterneById(@RequestParam("id") Long  id) {
        Optional<AnnonceExterne> annonceExterne = annonceExterneService.findAnnonceExterneById(id);

        return annonceExterne;
    }

    @PostMapping(value = "/add")

    public ResponseEntity<AnnonceExterne> addAnnonceExterne(@RequestBody AnnonceExterne annonceExterne ) throws IOException {

        annonceExterneService.addannonceExterne(annonceExterne);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<AnnonceExterne> updateAnnonceExterne(@RequestBody AnnonceExterne annonceExterne ) throws IOException {

        AnnonceExterne updateAnnonceExterne = annonceExterneService.updateAnnonceExterne(annonceExterne);
        return new ResponseEntity<>(updateAnnonceExterne, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAnnonceExterne(@PathVariable("id") Long id) {
        annonceExterneService.deleteAnnonceExterneById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
