package com.iscae.GetionLocation.repo;

import com.iscae.GetionLocation.model.ContratLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContratLocationRepo extends JpaRepository<ContratLocation,Long>{
    @Query(value = "SELECT * FROM contratlocation WHERE  id not in(select id_contrat from annonceinterne where type='Location') ",
            nativeQuery = true)
    List<ContratLocation> findAllNonAnnonced();
}
