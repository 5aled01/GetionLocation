package com.iscae.GetionLocation.repo;


import com.iscae.GetionLocation.model.Proprietaire;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface ProprietaireRepo extends CrudRepository<Proprietaire, Long> {


}
