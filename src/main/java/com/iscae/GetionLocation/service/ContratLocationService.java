package com.iscae.GetionLocation.service;

import com.iscae.GetionLocation.model.Client;
import com.iscae.GetionLocation.model.ContratLocation;
import com.iscae.GetionLocation.repo.ContratLocationRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ContratLocationService {
    private final ContratLocationRepo contratLocationRepo ;


    public ContratLocationService(ContratLocationRepo contratLocationRepo) {
        this.contratLocationRepo = contratLocationRepo;
    }

    public List<ContratLocation> findAllContratLocation(){
        return contratLocationRepo.findAll();
    }

    public Optional<ContratLocation> findContratLocationById(long id){
        return  contratLocationRepo.findById(id);
    }
    public void deleteContratLocation(Long id){
        contratLocationRepo.deleteById(id);
    }

    public ContratLocation addContratLocation(ContratLocation contratLocation){
        return contratLocationRepo.save(contratLocation);
    }


    public ContratLocation updateContratLocation(ContratLocation contratLocation){
        return contratLocationRepo.save(contratLocation);
    }

    public List<ContratLocation> findAllContratLocationNonAnnonced() {
        return contratLocationRepo.findAllNonAnnonced();
    }
}
