package com.iscae.GetionLocation.repo;

import com.iscae.GetionLocation.model.ContratLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratLocationRepo extends JpaRepository<ContratLocation,Long>{
}
