package com.iscae.GetionLocation.repo;
import com.iscae.GetionLocation.model.AnnonceInterne;
import org.springframework.data.jpa.repository.JpaRepository;
import com.iscae.GetionLocation.model.AnnonceExterne;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  AnnonceExterneRepo extends  JpaRepository<AnnonceExterne, Long> {

    @Query(value = "SELECT * FROM annonceexterne WHERE idImmobilier=:id ",
            nativeQuery = true)
    Optional<AnnonceExterne> existImmob(Long id);
    @Modifying
    @Query(value = "update annonceexterne set etats='Indisponible' WHERE id=:id ",
            nativeQuery = true)
    void updateEtats(Long id);
}


