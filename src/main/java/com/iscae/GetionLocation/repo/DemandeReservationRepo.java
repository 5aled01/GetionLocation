package com.iscae.GetionLocation.repo;

import com.iscae.GetionLocation.model.DemandeReservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandeReservationRepo extends JpaRepository<DemandeReservation, Long> {
    void deleteDemandeReservationById(Long id);
    @Query(value = "SELECT * FROM demande_reservation WHERE type='interne'",
            nativeQuery = true)
    List<DemandeReservation> DemandeReservationInterne();
    @Query(value = "SELECT * FROM demande_reservation WHERE type='externe'",
            nativeQuery = true)
    List<DemandeReservation> DemandeReservationExterne();
}
