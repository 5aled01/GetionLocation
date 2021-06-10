package com.iscae.GetionLocation.repo;

import com.iscae.GetionLocation.model.Contrat;
import com.iscae.GetionLocation.model.DecisionVente;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@Primary

public interface ContratRepo extends JpaRepository<Contrat, Long> {
    
}
