package com.iscae.GetionLocation.resource;

import com.iscae.GetionLocation.model.Client;
import com.iscae.GetionLocation.model.ContratLocation;
import com.iscae.GetionLocation.service.ContratLocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contratlocation")
public class ContratLocationResource {
    private final ContratLocationService contratLocationService ;

    public ContratLocationResource(ContratLocationService contratLocationService) {
        this.contratLocationService = contratLocationService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<ContratLocation>> getAllContratLocation() {
        List<ContratLocation> contratLocations = contratLocationService.findAllContratLocation();

        return new ResponseEntity<>(contratLocations, HttpStatus.OK);
    }
    @GetMapping("/allNonAnnonced")
    public ResponseEntity<List<ContratLocation>> getAllContratLocationNonAnonced() {
        List<ContratLocation> contratLocations = contratLocationService.findAllContratLocationNonAnnonced();

        return new ResponseEntity<>(contratLocations, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public Optional<ContratLocation> findContratLocationById(@RequestParam("id") Long  id) {
        Optional<ContratLocation> contratLocation = contratLocationService.findContratLocationById(id);

        return contratLocation;
    }

    @PostMapping(value = "/add")

    public ResponseEntity<ContratLocation> addContratLocation (@RequestBody ContratLocation contratLocation ) throws IOException {

        contratLocationService.addContratLocation(contratLocation);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<ContratLocation> updateContratLocation(@RequestBody ContratLocation contratLocation ) throws IOException {

        ContratLocation updateContratLocation = contratLocationService.updateContratLocation(contratLocation);
        return new ResponseEntity<>(updateContratLocation, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteContratLocation(@PathVariable("id") Long id) {
        contratLocationService.deleteContratLocation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
