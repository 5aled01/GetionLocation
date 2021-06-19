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


    @Query(value = "SELECT * FROM Image WHERE idcorespondance = :id    ",
            nativeQuery = true)
    List<Image> findAllImageByIdcorespondance(long id );


    Image findImageByIdcorespondance(long id);

    Image findImageById(long id);
}
