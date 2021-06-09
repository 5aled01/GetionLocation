package com.iscae.GetionLocation.repo;

import com.iscae.GetionLocation.model.Immobilier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface ImmoblierRepo extends JpaRepository<Immobilier, Long> {

}
