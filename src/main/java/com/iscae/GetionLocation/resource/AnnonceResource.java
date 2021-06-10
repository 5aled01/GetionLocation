package com.iscae.GetionLocation.resource;

import com.iscae.GetionLocation.model.Annonce;
import com.iscae.GetionLocation.model.Client;
import com.iscae.GetionLocation.service.AnnonceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Annonce")
public class AnnonceResource {

    private final AnnonceService annonceService ;

    public AnnonceResource(AnnonceService annonceService) {
        this.annonceService = annonceService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Annonce>> getAllAnnonce() {
        List<Annonce> Annonces = annonceService.findAllAnnonce();

        return new ResponseEntity<>(Annonces, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public Optional<Annonce> findAnnonceById(@RequestParam("id") Long  id) {
        Optional<Annonce> annonce = annonceService.findAnnonceById(id);

        return annonce;
    }

    @PostMapping(value = "/add")

    public ResponseEntity<Annonce> addAnnonce (@RequestBody Annonce annonce ) throws IOException {

        annonceService.addAnnonce(annonce);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<Annonce> updateAnnonce(@RequestBody Annonce annonce ) throws IOException {

        Annonce updateAnnonce = annonceService.updateAnnonce(annonce);
        return new ResponseEntity<>(updateAnnonce, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAnnonce(@PathVariable("id") Long id) {
        annonceService.deleteAnnonceById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
