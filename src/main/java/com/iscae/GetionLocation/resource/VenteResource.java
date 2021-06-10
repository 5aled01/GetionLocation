package com.iscae.GetionLocation.resource;

import com.iscae.GetionLocation.model.Terrain;
import com.iscae.GetionLocation.model.Vente;
import com.iscae.GetionLocation.service.TerrainService;
import com.iscae.GetionLocation.service.VenteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/vente")
public class VenteResource {
    private final VenteService venteService;

    public VenteResource(VenteService venteService) {
        this.venteService = venteService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Vente>> getAllVente() {
        List<Vente> vente = venteService.findAllVente();

        return new ResponseEntity<>(vente, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public Optional<Vente> findVenteById(@RequestParam("id") Long  id) {
        Optional<Vente> ventes = venteService.findVenteById(id);

        return ventes;
    }

    @PostMapping(value = "/add")

    public ResponseEntity<Vente> addVente (@RequestBody Vente vente ) throws IOException {

        venteService.addVente(vente);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<Vente> updateVente(@RequestBody Vente vente ) throws IOException {

        Vente updateVente = venteService.updateVente(vente);
        return new ResponseEntity<>(updateVente, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVente(@PathVariable("id") Long id) {
        venteService.deleteVente(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
