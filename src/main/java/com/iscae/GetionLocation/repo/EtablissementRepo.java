package com.iscae.GetionLocation.repo;

import com.iscae.GetionLocation.model.Etablissement;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EtablissementRepo extends JpaRepository<Etablissement, Long> {
}
