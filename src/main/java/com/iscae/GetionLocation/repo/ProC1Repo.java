package com.iscae.GetionLocation.repo;

import com.iscae.GetionLocation.model.ProC1;
import com.iscae.GetionLocation.model.Proprietaire;
import com.iscae.GetionLocation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProC1Repo extends JpaRepository<ProC1,Long>  {



    Optional<ProC1> findProC1ByProNom(String proNom);
    ProC1 findUserById(long id);

    @Query(value = "SELECT password FROM ProC1 WHERE pro_nom = :proNom",
            nativeQuery = true)
     String findPasswordByProNomNative(String proNom);

    @Query(value = "SELECT * FROM ProC1 WHERE pro_nom = :proNom",
            nativeQuery = true)
    ProC1 findProC1ByProNom2(@Param("proNom") String proNom);




    void deleteProC1ById(Long id);



}
