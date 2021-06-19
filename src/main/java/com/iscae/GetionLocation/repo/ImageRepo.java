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
}
