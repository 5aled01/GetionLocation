package com.iscae.GetionLocation.repo;

import com.iscae.GetionLocation.model.DemandeReservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface DemandeReservationRepo extends JpaRepository<DemandeReservation, Long> {
    void deleteDemandeReservationById(Long id);
    @Query(value = "SELECT * FROM demandereservation WHERE type='interne' order by id_annonce desc ",
            nativeQuery = true)
    List<DemandeReservation> DemandeReservationInterne();
    @Query(value = "SELECT * FROM demandereservation WHERE type='externe'  ",
            nativeQuery = true)
    List<DemandeReservation> DemandeReservationExterne();

    List<DemandeReservation> findAllByOrderByIdAnnonceDesc();
   @Modifying
    @Query(value = "Delete from demandereservation  WHERE id_annonce=:idannonce and id!=:idd  ",
            nativeQuery = true)
    void deleteByIdAnnonce(Long idannonce ,Long idd);

    @Query(value = "SELECT * from demandereservation WHERE id_annonce in (SELECT id from annonceexterne where id_immobilier in(SELECT id from immobilierbati where type_proprietaire ='proc2' And id_proprietaire=:idproc2)) ",
            nativeQuery = true)
    List<DemandeReservation> findProc2Reservation( Long idproc2);
}
