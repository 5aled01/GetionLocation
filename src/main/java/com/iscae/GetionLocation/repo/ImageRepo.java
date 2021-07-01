package com.iscae.GetionLocation.repo;

import com.iscae.GetionLocation.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageRepo extends JpaRepository<Image, Long> {


    @Query(value = "SELECT * FROM image WHERE idCorespondance = :idCorespondance   ",
            nativeQuery = true)
    List<Image> findAllImageByIdCorespondance(long idCorespondance);


    @Query(value = "SELECT * FROM image WHERE id_corespondance = :id ",
            nativeQuery = true)
    List<Image> findAllImageByidCorespondanceNative(@Param("id") long idCorespondance);



    Image findImageById(long id);

    @Query(value = "SELECT * FROM image WHERE corespondance='immobilierBati' and id_corespondance in (SELECT id from immobilierbati where type_proprietaire='proc2' and id_proprietaire=:id )",
            nativeQuery = true)
    List<Image> findAllImageByidProc2(long id);

    @Query(value = "SELECT * FROM image WHERE id_corespondance IN(SELECT id_immobilier " +
            "FROM annonceexterne) OR " +
            "id_corespondance IN(SELECT id_immobilier FROM annonceinterne) and corespondance= 'immobilierBati'",
            nativeQuery = true)
    List<Image> findAllImageofbatiAnnonced();
}
