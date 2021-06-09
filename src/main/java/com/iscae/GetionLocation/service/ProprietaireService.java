package com.iscae.GetionLocation.service;

import com.iscae.GetionLocation.model.Proprietaire;
import com.iscae.GetionLocation.model.User;
import com.iscae.GetionLocation.repo.ProprietaireRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProprietaireService {

    private final ProprietaireRepo proprietaireRepo;

    public ProprietaireService(ProprietaireRepo proprietaireRepo) {
        this.proprietaireRepo = proprietaireRepo;
    }

    public List<Proprietaire> findAllProprietaire(){
        return (List<Proprietaire>) proprietaireRepo.findAll();
    }

}
