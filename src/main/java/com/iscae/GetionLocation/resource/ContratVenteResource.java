package com.iscae.GetionLocation.resource;

import com.iscae.GetionLocation.model.Client;
import com.iscae.GetionLocation.model.ContratLocation;
import com.iscae.GetionLocation.model.ContratVente;
import com.iscae.GetionLocation.service.ContratVenteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contratvente")
public class ContratVenteResource {
    private final ContratVenteService contratVenteService;

    public ContratVenteResource(ContratVenteService contratVenteService) {
        this.contratVenteService = contratVenteService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<ContratVente>> getAllContratVentes() {
        List<ContratVente> contratVente = contratVenteService.findAllContratVente();

        return new ResponseEntity<>(contratVente, HttpStatus.OK);
    }
    @GetMapping("/allNonAnnonced")
    public ResponseEntity<List<ContratVente>> getAllContratVenteNonAnnonced() {
        List<ContratVente> contratVente = contratVenteService.findAllContratVenteNonAnnonced();

        return new ResponseEntity<>(contratVente, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public Optional<ContratVente> findContratVenteById(@PathVariable("id") Long  id) {
        Optional<ContratVente> contratVente = contratVenteService.findContratVenteById(id);

        return contratVente;
    }

    @PostMapping(value = "/add")

    public ResponseEntity<ContratVente> addContratVente (@RequestBody ContratVente contratVente ) throws IOException {

        contratVenteService.addContratVente(contratVente);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<ContratVente> updateContratVente(@RequestBody ContratVente contratVente ) throws IOException {

        ContratVente updateContratVente = contratVenteService.updateContratVente(contratVente);
        return new ResponseEntity<>(updateContratVente, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteContratVente(@PathVariable("id") Long id) {
        contratVenteService.deleteContratVente(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
