package com.iscae.GetionLocation.repo;

import com.iscae.GetionLocation.model.Contrat;
import com.iscae.GetionLocation.model.DecisionVente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratRepo extends JpaRepository<Contrat, Long> {
}
