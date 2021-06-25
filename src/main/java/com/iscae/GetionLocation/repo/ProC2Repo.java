package com.iscae.GetionLocation.repo;

import com.iscae.GetionLocation.model.ProC1;
import com.iscae.GetionLocation.model.ProC2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public interface ProC2Repo extends JpaRepository<ProC2,Long> {

    Optional<ProC2> findProC2ByPronom(String proNom);
    ProC2 findById(long id);

    @Query(value = "SELECT password FROM ProC2 WHERE pronom = :pronom",
            nativeQuery = true)
    String findPasswordByProNomNative(String pronom);

    @Query(value = "SELECT * FROM ProC2 WHERE pronom = :pronom",
            nativeQuery = true)
    ProC2 findProC2ByPronom2(@Param("pronom") String pronom);

}
