package com.iscae.GetionLocation.repo;


import com.iscae.GetionLocation.model.Image;
import com.iscae.GetionLocation.model.ImmobilierBati;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImmobilierBatiRepo extends JpaRepository<ImmobilierBati,Long> {


    ImmobilierBati findImmoblierBatiById(Long id);

    @Query(value = "SELECT * FROM immobilierbati WHERE type_proprietaire='proc1' and id not in(select id_immobilier from annonceinterne) ",
            nativeQuery = true)
    List<ImmobilierBati> findImmoblierBatisPc1Notannonced();

    @Query(value = "SELECT * FROM immobilierbati WHERE type_proprietaire='proc1' ",
            nativeQuery = true)
    List<ImmobilierBati> findImmoblierBatisPc1();
    @Query(value = "SELECT * FROM immobilierbati" +
            " WHERE id IN(SELECT id_immobilier FROM annonceexterne) OR" +
            " id IN(SELECT id_immobilier FROM annonceinterne)",
            nativeQuery = true)
    List<ImmobilierBati> findImmoblierBatiAnnonced();


    @Query(value = "SELECT * FROM immobilierbati WHERE type_proprietaire='proc2'  and id not in(select id_immobilier from annonceexterne) ",
            nativeQuery = true)
    List<ImmobilierBati> findImmoblierBatisPc2();
    @Query(value = "SELECT * FROM immobilierbati WHERE type_proprietaire='proc2' and id_proprietaire=:id",
            nativeQuery = true)
    List<ImmobilierBati> findImmoblierBatiscurentPc2(long id);
}
