package com.iscae.GetionLocation.resource;


import com.iscae.GetionLocation.model.Client;
import com.iscae.GetionLocation.model.DemandeReservation;
import com.iscae.GetionLocation.service.DemandeReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservation")
public class DemandeReservationResource {
    private final DemandeReservationService demandeReservationService ;

    public DemandeReservationResource(DemandeReservationService demandeReservationService) {
        this.demandeReservationService = demandeReservationService;
    }




    @GetMapping("/interne")
    public ResponseEntity<List<DemandeReservation>> getAllDemendeReservationInterne() {
        List<DemandeReservation> demandeReservations = demandeReservationService.findAllDemandeReservationinterne();

        return new ResponseEntity<>(demandeReservations, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<DemandeReservation>> getAllDemendeReservation() {
        List<DemandeReservation> demandeReservations = demandeReservationService.findAllDemandeReservation();

        return new ResponseEntity<>(demandeReservations, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public Optional<DemandeReservation> findDemandeReservationsById(@RequestParam("id") Long  id) {
        Optional<DemandeReservation> demandeReservations = demandeReservationService.findDemandeReservationById(id);

        return demandeReservations;
    }

    @PostMapping("/add")
    public ResponseEntity<DemandeReservation> addDemandeReservation (@RequestBody DemandeReservation demandeReservation ) {

        demandeReservationService.addDemandeReservation(demandeReservation);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<DemandeReservation> updateDemandeReservation(@RequestBody DemandeReservation demandeReservation ) throws IOException {

        DemandeReservation updateDemandeReservation = demandeReservationService.updateDemandeReservation(demandeReservation);
        return new ResponseEntity<>(updateDemandeReservation, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDemandeReservation(@PathVariable("id") Long id) {
        demandeReservationService.deleteDemandeReservation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
