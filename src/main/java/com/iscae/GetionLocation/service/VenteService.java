package com.iscae.GetionLocation.service;

import com.iscae.GetionLocation.model.Terrain;
import com.iscae.GetionLocation.model.Vente;
import com.iscae.GetionLocation.repo.VenteRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VenteService {

    private final VenteRepo venteRepo;

    public VenteService(VenteRepo venteRepo) {
        this.venteRepo = venteRepo;
    }


    public List<Vente> findAllVente(){
        return venteRepo.findAll();
    }

    public Optional<Vente> findVenteById(long id){
        return  venteRepo.findById(id);
    }
    public void deleteVente(Long id){
        venteRepo.deleteById(id);
    }

    public Vente addVente(Vente vente){
        return venteRepo.save(vente);
    }


    public Vente updateVente(Vente vente){
        return venteRepo.save(vente);
    }

}
