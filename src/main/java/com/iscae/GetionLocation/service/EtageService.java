package com.iscae.GetionLocation.service;

import com.iscae.GetionLocation.model.Etage;
import com.iscae.GetionLocation.repo.EtageRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EtageService {

    private final EtageRepo etageRepo;


    public EtageService(EtageRepo etageRepo) {
        this.etageRepo = etageRepo;
    }

    public Etage addEtage(Etage etage){
        return etageRepo.save(etage);
    }

    public List<Etage> findAllEtages(){
        return etageRepo.findAll();
    }

    public Optional<Etage> findById(long id){
        return etageRepo.findById(id);
    }

    public void deleteEtage(long id){etageRepo.deleteById(id);}

    public Etage updateEtage(Etage etage) {
        return etageRepo.save(etage);
    }



    public List<Etage> findEtagesByIdImmobilierBati(Long id) {
        return etageRepo.findEtagesByIdImmobilier(id);
    }
}
