package com.iscae.GetionLocation.resource;

import com.iscae.GetionLocation.model.Location;
import com.iscae.GetionLocation.model.Vente;
import com.iscae.GetionLocation.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/location")
public class LocationResource {

    private final LocationService locationService;

    public LocationResource(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Location>> getAllLocation() {
        List<Location> locations = locationService.findAllLocation();

        return new ResponseEntity<>(locations, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public Optional<Location> findLocationById(@RequestParam("id") Long  id) {
        Optional<Location> locations = locationService.findLocationById(id);

        return locations;
    }

    @PostMapping(value = "/add")

    public ResponseEntity<Location> addLocation (@RequestBody Location location ) throws IOException {

        locationService.addLocation(location);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<Location> updateLocation(@RequestBody Location location ) throws IOException {

        Location updateLocation = locationService.updateLocation(location);
        return new ResponseEntity<>(updateLocation, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteLocation(@PathVariable("id") Long id) {
        locationService.deleteLocation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
