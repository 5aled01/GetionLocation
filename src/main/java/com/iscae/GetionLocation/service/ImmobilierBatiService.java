package com.iscae.GetionLocation.service;

import com.iscae.GetionLocation.model.ImmobilierBati;
import com.iscae.GetionLocation.repo.ImmobilierBatiRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class ImmobilierBatiService {
    private  final ImmobilierBatiRepo immobilierBatiRepo;

    public ImmobilierBatiService(ImmobilierBatiRepo immobilierBatiRepo) {
        this.immobilierBatiRepo = immobilierBatiRepo;
    }



    public List<ImmobilierBati> findAllImmobilierBati(){
        return immobilierBatiRepo.findAll();
    }

    public Optional<ImmobilierBati> findImmobilierBatiById(long id){
        return  immobilierBatiRepo.findById(id);
    }
    public void deleteImmoblierBati(Long id){
        immobilierBatiRepo.deleteById(id);
    }

    public ImmobilierBati addImmoblierBati(ImmobilierBati immobilierBati){
        return immobilierBatiRepo.save(immobilierBati);
    }


    public ImmobilierBati updateImmoblierBati(ImmobilierBati immobilierBati){
        return immobilierBatiRepo.save(immobilierBati);
    }

}
