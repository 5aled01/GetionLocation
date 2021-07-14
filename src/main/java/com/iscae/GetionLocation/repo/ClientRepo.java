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

    @Query(value = "SELECT * FROM client WHERE Authnom = :Authnom",
            nativeQuery = true)
    Optional<Client> findClientByAuthnom(String Authnom);

    Client findById(long id);

    @Query(value = "SELECT password FROM client WHERE Authnom = :Authnom",
            nativeQuery = true)
    String findPasswordByAuthnomNative(String Authnom);

    @Query(value = "SELECT * FROM client WHERE Authnom = :Authnom",
            nativeQuery = true)
    Client findClientByAuthnom2(@Param("Authnom") String Authnom);



    Client findClientById(long id);
}
