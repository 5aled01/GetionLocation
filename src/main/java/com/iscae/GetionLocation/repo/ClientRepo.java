package com.iscae.GetionLocation.repo;

import com.iscae.GetionLocation.model.Client;
import com.iscae.GetionLocation.model.ProC2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {

    @Query(value = "SELECT * FROM client WHERE Nom = :Nom",
            nativeQuery = true)
    Optional<Client> findClientByNom(String Nom);

    Client findById(long id);

    @Query(value = "SELECT password FROM client WHERE Nom = :Nom",
            nativeQuery = true)
    String findPasswordByNomNative(String Nom);

    @Query(value = "SELECT * FROM client WHERE Nom = :Nom",
            nativeQuery = true)
    Client findClientByNom2(@Param("Nom") String nom);



    Client findClientById(long id);
}
