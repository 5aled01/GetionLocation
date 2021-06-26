package com.iscae.GetionLocation.service;

import com.iscae.GetionLocation.model.Annonce;
import com.iscae.GetionLocation.model.AnnonceInterne;
import com.iscae.GetionLocation.repo.AnnonceInterneRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AnnonceInterneService {

    private  final AnnonceInterneRepo annonceInterneRepo;

    public AnnonceInterneService(AnnonceInterneRepo annonceInterneRepo) {
        this.annonceInterneRepo = annonceInterneRepo;
    }


    public List<AnnonceInterne> findAllAnnonceInterne(){
        return annonceInterneRepo.findAll();
    }

    public Optional<AnnonceInterne> findAnnonceInterneById(long id){
        return  annonceInterneRepo.findById(id);
    }
    public void deleteAnnonceInterne(Long id){
        annonceInterneRepo.deleteById(id);
    }

    public AnnonceInterne addAnnonceInterne(AnnonceInterne annonceInterne){
        return annonceInterneRepo.save(annonceInterne);
    }


    public AnnonceInterne updateAnnonceInterne(AnnonceInterne annonceInterne){
        return annonceInterneRepo.save(annonceInterne);
    }

    public void deleteAnnonceInterneById(Long id) {
        annonceInterneRepo.deleteById(id);
    }
}
