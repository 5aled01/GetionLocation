package com.iscae.GetionLocation.repo;

import com.iscae.GetionLocation.model.ContratVente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContratVenteRepo extends JpaRepository<ContratVente,Long> {
    @Query(value = "SELECT * FROM contratvente WHERE  id not in(select id_contrat from annonceinterne where type='Vente') ",
            nativeQuery = true)
    List<ContratVente> findAllNonAnnonced();
}
