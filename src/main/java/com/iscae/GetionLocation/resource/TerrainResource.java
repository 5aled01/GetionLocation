package com.iscae.GetionLocation.resource;

import com.iscae.GetionLocation.model.Terrain;
import com.iscae.GetionLocation.service.TerrainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/terrain")
public class TerrainResource {
    private final TerrainService terrainService;

    public TerrainResource(TerrainService terrainService) {
        this.terrainService = terrainService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Terrain>> getAllTerrain() {
        List<Terrain> terrains = terrainService.findAllTerrain();

        return new ResponseEntity<>(terrains, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public Optional<Terrain> findTerrainById(@RequestParam("id") Long  id) {
        Optional<Terrain> terrains = terrainService.findTerrainById(id);

        return terrains;
    }

    @PostMapping(value = "/add")

    public ResponseEntity<Terrain> addTerrain (@RequestBody Terrain terrain ) throws IOException {

        terrainService.addTerrain(terrain);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<Terrain> updateTerrain(@RequestBody Terrain terrain ) throws IOException {

        Terrain updateTerrain = terrainService.updateTerrain(terrain);
        return new ResponseEntity<>(updateTerrain, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTerrain(@PathVariable("id") Long id) {
        terrainService.deleteTerrain(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
