package com.iscae.GetionLocation.repo;
import com.iscae.GetionLocation.model.AnnonceInterne;
import org.springframework.data.jpa.repository.JpaRepository;
import com.iscae.GetionLocation.model.AnnonceExterne;
import org.springframework.stereotype.Repository;

@Repository
public interface  AnnonceExterneRepo extends  JpaRepository<AnnonceExterne, Long> {

}


