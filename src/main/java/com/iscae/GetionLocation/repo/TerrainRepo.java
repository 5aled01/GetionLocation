package com.iscae.GetionLocation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.iscae.GetionLocation.model.Terrain;

public interface TerrainRepo extends   JpaRepository<Terrain, Long> {
}
