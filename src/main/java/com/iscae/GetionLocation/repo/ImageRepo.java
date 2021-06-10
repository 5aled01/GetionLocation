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



    List<Image> findAllImageByIdType(long idType);


    @Query(value = "SELECT * FROM Image WHERE id_type = :id_type AND type = :type  ",
            nativeQuery = true)
    List<Image> findAllImageByIdTypeAndTypeNative(@Param("id_type") long id_type,
                                                  @Param("type") String type);

    Image findImageByIdType(long id);
}
