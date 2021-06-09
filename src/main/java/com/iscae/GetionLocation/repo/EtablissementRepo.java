package com.iscae.GetionLocation.repo;

import com.iscae.GetionLocation.model.Etablissement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtablissementRepo extends JpaRepository<Etablissement, Long> {
}
