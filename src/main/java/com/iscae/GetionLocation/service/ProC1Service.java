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

    public ProC1 findProC1ById(long id){
        return  proC1Repo.findUserById(id);
     }
    public void deleteProC1(Long id){
        proC1Repo.deleteProC1ById(id);
    }

    public ProC1 addProC1(ProC1 proC1){
        String encodedPassword = bCryptPasswordEncoder.encode(proC1.getPassword());
        proC1.setPassword(encodedPassword);
        return proC1Repo.save(proC1);
    }

    public boolean findProC1ProNom(String proNom, String password) {
        boolean userExists = proC1Repo.findProC1ByProNom(proNom).isPresent();
        if(!userExists) {
            return false;
        }
        String passCode = proC1Repo.findPasswordByProNomNative(proNom);
        if(bCryptPasswordEncoder.matches(password,passCode)){
            return true;
        }
        return false;

    }

    public Optional<ProC1> findProC1ByProNom(String proNom) {
        return proC1Repo.findProC1ByProNom(proNom);
    }


    public ProC1 findUserByUsername2(String nam) {
        return proC1Repo.findProC1ByProNom2(nam);
    }

    public ProC1 updateProC1(ProC1 proC1){

        String encodedPassword = bCryptPasswordEncoder.encode(proC1.getPassword());
        proC1.setPassword(encodedPassword);
        return proC1Repo.save(proC1);

    }
}
