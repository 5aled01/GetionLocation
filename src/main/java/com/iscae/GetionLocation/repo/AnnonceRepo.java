package com.iscae.GetionLocation.repo;

import com.iscae.GetionLocation.model.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnonceRepo extends JpaRepository<Annonce, Long> {
}
