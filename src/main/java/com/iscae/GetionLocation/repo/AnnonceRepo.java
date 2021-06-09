package com.iscae.GetionLocation.repo;

import com.iscae.GetionLocation.model.Annonce;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface AnnonceRepo extends JpaRepository<Annonce, Long> {



}
