package com.iscae.GetionLocation.service;

import com.iscae.GetionLocation.model.Annonce;
import com.iscae.GetionLocation.model.AnnonceExterne;
import com.iscae.GetionLocation.model.AnnonceInterne;
import com.iscae.GetionLocation.repo.AnnonceExterneRepo;
import com.iscae.GetionLocation.repo.AnnonceRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AnnonceExterneService {

    private  final AnnonceExterneRepo annonceExterneRepo;

    public AnnonceExterneService(AnnonceExterneRepo annonceExterneRepo) {
        this.annonceExterneRepo = annonceExterneRepo;
    }


    public List<AnnonceExterne> findAllAnnonceExterne(){
        return annonceExterneRepo.findAll();
    }

    public Optional<AnnonceExterne> findAnnonceExterneById(long id){
        return  annonceExterneRepo.findById(id);
    }


    public AnnonceExterne addannonceExterne(AnnonceExterne annonceExterne){
        return annonceExterneRepo.save(annonceExterne);
    }


    public AnnonceExterne updateAnnonceExterne(AnnonceExterne annonceExterne){
        return annonceExterneRepo.save(annonceExterne);
    }

    public void deleteAnnonceExterneById(Long id) {
         annonceExterneRepo.deleteById(id);
    }
    public boolean updateEtat(Long id) {
        int b = annonceExterneRepo.updateEtat(id);
        if(b==1)
            return  true ;
        else
            return false;
    }

    public void updateEtatsAnnonceExterne(Long id) {
          annonceExterneRepo.updateEtats(id);
    }

    public List<AnnonceExterne> findAllAnnonceExterneProc2(long id) {
        return  annonceExterneRepo.findProc2annonce(id);
    }
}
