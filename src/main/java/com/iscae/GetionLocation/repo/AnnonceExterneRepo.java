package com.iscae.GetionLocation.repo;
import com.iscae.GetionLocation.model.AnnonceInterne;
import org.springframework.data.jpa.repository.JpaRepository;
import com.iscae.GetionLocation.model.AnnonceExterne;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface  AnnonceExterneRepo extends  JpaRepository<AnnonceExterne, Long> {
    @Modifying
    @Query(value = "update annonceexterne set etats='Indisponible' WHERE id=:id",
            nativeQuery = true)
   int updateEtat(Long id);
    @Modifying
    @Query(value = "update annonceexterne set etats='Indisponible' WHERE id=:id ",
            nativeQuery = true)
    void updateEtats(Long id);
    @Query(value = "select *from annonceexterne where etats='Disponible' and id_immobilier in (select id FROM  immobilierbati where type_proprietaire='proc2' and id_proprietaire=:id)",
            nativeQuery = true)
    List<AnnonceExterne> findProc2annonce(long id);
}


