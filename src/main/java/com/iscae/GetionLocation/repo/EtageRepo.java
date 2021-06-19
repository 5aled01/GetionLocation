package com.iscae.GetionLocation.repo;

import com.iscae.GetionLocation.model.Etage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtageRepo extends JpaRepository<Etage, Long> {

    @Query(value = "SELECT * FROM Etage WHERE id_immobilier_bati = :id   ",
            nativeQuery = true)
    List<Etage> findEtagesByIdImmobilier(Long id);

}
