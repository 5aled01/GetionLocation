package com.iscae.GetionLocation.service;

import com.iscae.GetionLocation.model.ProC1;
import com.iscae.GetionLocation.repo.ProC1Repo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProC1Service {

    private final ProC1Repo proC1Repo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public ProC1Service(ProC1Repo proC1Repo, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.proC1Repo = proC1Repo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public List<ProC1> findAllProC1(){
        return proC1Repo.findAll();
    }

    public ProC1 findProC1ById(Long id){
        return  proC1Repo.findProC1ById(id);
     }
    public void deleteProC1(Long id){
        proC1Repo.deleteProC1ById(id);
    }

    public ProC1 addProC1(ProC1 proC1){

        return proC1Repo.save(proC1);
    }





    public ProC1 updateProC1(ProC1 proC1){


        return proC1Repo.save(proC1);

    }

    public ProC1 findProC1ById(int id) {
        return proC1Repo.findById(id);
    }
}
