package com.iscae.GetionLocation.repo;

import com.iscae.GetionLocation.model.Client;
import com.iscae.GetionLocation.model.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenteRepo extends JpaRepository<Vente, Long> {

}
