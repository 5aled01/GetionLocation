package com.iscae.GetionLocation.repo;

import com.iscae.GetionLocation.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {

    Client findClientById(long id);
}
