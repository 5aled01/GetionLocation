package com.iscae.GetionLocation.repo;

import com.iscae.GetionLocation.model.DemandeReservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeReservationRepo extends JpaRepository<DemandeReservation, Long> {
    void deleteDemandeReservationById(Long id);
}
