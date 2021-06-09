package com.iscae.GetionLocation.service;

import com.iscae.GetionLocation.model.ImmoblierBati;
import com.iscae.GetionLocation.model.ProC2;
import com.iscae.GetionLocation.repo.ImmoblierBatiRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class ImmobilierBatiService {
    private  final ImmoblierBatiRepo immoblierBatiRepo;

    public ImmobilierBatiService(ImmoblierBatiRepo immoblierBatiRepo) {
        this.immoblierBatiRepo = immoblierBatiRepo;
    }



    public List<ImmoblierBati> findAllImmobilierBati(){
        return immoblierBatiRepo.findAll();
    }

    public Optional<ImmoblierBati> findImmobilierBatiById(long id){
        return  immoblierBatiRepo.findById(id);
    }
    public void deleteImmoblierBati(Long id){
        immoblierBatiRepo.deleteById(id);
    }

    public ImmoblierBati addImmoblierBati(ImmoblierBati immoblierBati){
        return immoblierBatiRepo.save(immoblierBati);
    }


    public ImmoblierBati updateImmoblierBati(ImmoblierBati immoblierBati){
        return immoblierBatiRepo.save(immoblierBati);
    }

}
