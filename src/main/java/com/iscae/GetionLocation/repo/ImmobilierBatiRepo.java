package com.iscae.GetionLocation.repo;


import com.iscae.GetionLocation.model.Image;
import com.iscae.GetionLocation.model.ImmobilierBati;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImmobilierBatiRepo extends JpaRepository<ImmobilierBati,Long> {


    ImmobilierBati findImmoblierBatiById(Long id_type);
}
