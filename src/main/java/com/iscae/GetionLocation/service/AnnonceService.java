package com.iscae.GetionLocation.service;

import com.iscae.GetionLocation.model.Annonce;
import com.iscae.GetionLocation.model.Client;
import com.iscae.GetionLocation.repo.AnnonceRepo;
import com.iscae.GetionLocation.repo.ClientRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AnnonceService {


    private  final AnnonceRepo annonceRepo;

    public AnnonceService(AnnonceRepo annonceRepo) {
        this.annonceRepo = annonceRepo;
    }


    public List<Annonce> findAllAnnonce(){
        return annonceRepo.findAll();
    }

    public Optional<Annonce> findAnnonceById(long id){
        return  annonceRepo.findById(id);
    }
    public void deleteAnnonce(Long id){
        annonceRepo.deleteById(id);
    }

    public Annonce addAnnonce(Annonce annonce){
        return annonceRepo.save(annonce);
    }


    public Annonce updateAnnonce(Annonce annonce){
        return annonceRepo.save(annonce);
    }


    public void deleteAnnonceById(Long id) {
         annonceRepo.deleteById(id);
    }
}
