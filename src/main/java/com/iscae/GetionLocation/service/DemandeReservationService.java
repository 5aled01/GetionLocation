package com.iscae.GetionLocation.service;

import com.iscae.GetionLocation.model.DemandeReservation;
import com.iscae.GetionLocation.repo.DemandeReservationRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DemandeReservationService {

    private  final DemandeReservationRepo demandeReservationRepo;

    public DemandeReservationService(DemandeReservationRepo demandeReservationRepo) {
        this.demandeReservationRepo = demandeReservationRepo;
    }




    public List<DemandeReservation> findAllDemandeReservation(){
        return demandeReservationRepo.findAllByOrderByIdAnnonceDesc( );
    }

    public Optional<DemandeReservation> findDemandeReservationById(long id){
        return demandeReservationRepo.findById(id);
    }

    public void deleteDemandeReservationRepo(Long id){
        demandeReservationRepo.deleteById(id);
    }

    public  DemandeReservation addDemandeReservation(DemandeReservation demandeReservation){
        return demandeReservationRepo.save(demandeReservation);
    }


    public DemandeReservation updateDemandeReservation(DemandeReservation demandeReservation){
        return demandeReservationRepo.save(demandeReservation);
    }

    public void deleteDemandeReservation(Long id) {
        demandeReservationRepo.deleteDemandeReservationById(id);
    }

    public List<DemandeReservation> findAllDemandeReservationinterne() {
        return  demandeReservationRepo.DemandeReservationInterne();
    }

    public void deleteDemandeReservationByAnnonce(Long idannonce ,Long id) {
        demandeReservationRepo.deleteByIdAnnonce(idannonce,id);
    }
}
