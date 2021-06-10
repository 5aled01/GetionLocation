package com.iscae.GetionLocation.service;


import com.iscae.GetionLocation.model.ContratVente;
import com.iscae.GetionLocation.repo.ContratVenteRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ContratVenteService {
    private final ContratVenteRepo contratVenteRepo ;

    public ContratVenteService(ContratVenteRepo contratVenteRepo) {
        this.contratVenteRepo = contratVenteRepo;
    }


    public List<ContratVente> findAllContratVente(){
        return contratVenteRepo.findAll();
    }

    public Optional<ContratVente> findContratVenteById(long id){
        return  contratVenteRepo.findById(id);
    }
    public void deleteContratVente(Long id){
        contratVenteRepo.deleteById(id);
    }

    public ContratVente addContratVente(ContratVente contratVente){
        return contratVenteRepo.save(contratVente);
    }


    public ContratVente updateContratVente(ContratVente contratVente){
        return contratVenteRepo.save(contratVente);
    }
}
