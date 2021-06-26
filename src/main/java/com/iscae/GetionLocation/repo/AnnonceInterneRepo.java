package com.iscae.GetionLocation.repo;


import com.iscae.GetionLocation.model.Annonce;
import com.iscae.GetionLocation.model.AnnonceInterne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnonceInterneRepo extends  JpaRepository<AnnonceInterne, Long>   {
}
