package com.iscae.GetionLocation.resource;

import com.iscae.GetionLocation.model.Annonce;
import com.iscae.GetionLocation.model.AnnonceExterne;
import com.iscae.GetionLocation.model.AnnonceInterne;
import com.iscae.GetionLocation.service.AnnonceInterneService;
import com.iscae.GetionLocation.service.AnnonceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/annonceinterne")
public class AnnonceInterneResource {
    private final AnnonceInterneService annonceInterneService ;

    public AnnonceInterneResource(AnnonceInterneService annonceInterneService) {
        this.annonceInterneService = annonceInterneService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<AnnonceInterne>> getAllAnnonceInterne() {
        List<AnnonceInterne> AnnoncesInterne = annonceInterneService.findAllAnnonceInterne();

        return new ResponseEntity<>(AnnoncesInterne, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public Optional<AnnonceInterne> findAnnonceInterneById(@PathVariable("id") Long  id) {
        Optional<AnnonceInterne> annonceInterne = annonceInterneService.findAnnonceInterneById(id);

        return annonceInterne;
    }
    @GetMapping("/updateetat/{idAnnonce}")
    public  Boolean testAnnonceInterne(@PathVariable("id") Long  id) {
        return annonceInterneService.updateEtat(id);
    }

    @PostMapping(value = "/add")

    public ResponseEntity<Annonce> addAnnonceInterne (@RequestBody AnnonceInterne annonceInterne ) throws IOException {

        annonceInterneService.addAnnonceInterne(annonceInterne);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<Annonce> updateInterne(@RequestBody AnnonceInterne annonceInterne ) throws IOException {

        Annonce updateAnnonceInterne = annonceInterneService.updateAnnonceInterne(annonceInterne);
        return new ResponseEntity<>(updateAnnonceInterne, HttpStatus.OK);
    }
    @PutMapping("/updateetats")
    public ResponseEntity<?> updateEtatsInterne(@PathVariable("id") Long id) throws IOException {

         annonceInterneService.updateEtsatsAnnonceInterne(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAnnonceInterne(@PathVariable("id") Long id) {
        annonceInterneService.deleteAnnonceInterneById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
