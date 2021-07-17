package com.iscae.GetionLocation.repo;

import com.iscae.GetionLocation.model.ProC1;
import com.iscae.GetionLocation.model.Proprietaire;
import com.iscae.GetionLocation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProC1Repo extends JpaRepository<ProC1,Long>  {


    ProC1 findProC1ById(Long id);







    void deleteProC1ById(Long id);


    ProC1 findById(int id);
}
