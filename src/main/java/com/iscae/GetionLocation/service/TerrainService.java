package com.iscae.GetionLocation.service;

import com.iscae.GetionLocation.model.Terrain;
import com.iscae.GetionLocation.repo.TerrainRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class TerrainService {
 private final TerrainRepo terrainRepo;

    public TerrainService(TerrainRepo terrainRepo) {
        this.terrainRepo = terrainRepo;
    }

    public List<Terrain> findAllTerrain(){
        return terrainRepo.findAll();
    }

    public Optional<Terrain> findTerrainById(long id){
        return  terrainRepo.findById(id);
    }
    public void deleteTerrain(Long id){
        terrainRepo.deleteById(id);
    }

    public Terrain addTerrain(Terrain terrain){
        return terrainRepo.save(terrain);
    }


    public Terrain updateTerrain(Terrain terrain){
        return terrainRepo.save(terrain);
    }
}
