package com.iscae.GetionLocation.repo;

import com.iscae.GetionLocation.model.Client;
import com.iscae.GetionLocation.model.Vente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenteRepo extends JpaRepository<Vente, Long> {

}
