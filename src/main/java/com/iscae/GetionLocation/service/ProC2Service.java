package com.iscae.GetionLocation.service;

import com.iscae.GetionLocation.model.ProC2;
import com.iscae.GetionLocation.repo.ProC2Repo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProC2Service {


    private final ProC2Repo proC2Repo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public ProC2Service(ProC2Repo proC2Repo, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.proC2Repo = proC2Repo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    public List<ProC2> findAllProC2(){
        return proC2Repo.findAll();
    }

    public ProC2 findProC2ById(long id){
        return  proC2Repo.findById(id);
    }
    public void deleteProC2(Long id){
        proC2Repo.deleteById(id);
    }

    public ProC2 addProC2(ProC2 proC2){
        String encodedPassword = bCryptPasswordEncoder.encode(proC2.getPassword());
        proC2.setPassword(encodedPassword);
        return proC2Repo.save(proC2);
    }

    public boolean findProC2ProNom(String proNom, String password) {
        boolean userExists = proC2Repo.findProC2ByProNom(proNom).isPresent();
        if(!userExists) {
            return false;
        }
        String passCode = proC2Repo.findPasswordByProNomNative(proNom);
        if(bCryptPasswordEncoder.matches(password,passCode)){
            return true;
        }
        return false;

    }

    public Optional<ProC2> findProC1ByProNom(String proNom) {
        return proC2Repo.findProC2ByProNom(proNom);
    }


    public ProC2 findUserByUsername2(String nam) {
        return proC2Repo.findProC2ByProNom2(nam);
    }

    public ProC2 updateProC2(ProC2 proC2){

        String encodedPassword = bCryptPasswordEncoder.encode(proC2.getPassword());
        proC2.setPassword(encodedPassword);
        return proC2Repo.save(proC2);

    }
}
