package com.iscae.GetionLocation.repo;


import com.iscae.GetionLocation.model.Annonce;
import com.iscae.GetionLocation.model.AnnonceInterne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnnonceInterneRepo extends  JpaRepository<AnnonceInterne, Long>   {
    @Modifying
    @Query(value = "UPDATE annonceinterne SET etats = 'Indisponible' WHERE id=:id ",
            nativeQuery = true)
   int updateEtat(Long id);
    @Modifying
    @Query(value = "UPDATE annonceinterne SET etats = 'Indisponible' WHERE id=:id ",
            nativeQuery = true)
    void updateEtats(long id);
}
