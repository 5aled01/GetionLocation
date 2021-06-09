package com.iscae.GetionLocation.repo;

import com.iscae.GetionLocation.model.Etage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtageRepo extends JpaRepository<Etage, Long> {

}
