package com.iscae.GetionLocation.service;

import com.iscae.GetionLocation.model.Etage;
import com.iscae.GetionLocation.model.Piece;
import com.iscae.GetionLocation.repo.PieceRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PieceService {

    private final PieceRepo pieceRepo;


    public PieceService(PieceRepo pieceRepo) {
        this.pieceRepo = pieceRepo;
    }

    public Piece addPiece(Piece piece){
        return pieceRepo.save(piece);
    }

    public List<Piece> findAllPiece(){
        return pieceRepo.findAll();
    }

    public Optional<Piece> findById(long id){
        return pieceRepo.findById(id);
    }

    public void deletePiece(long id){pieceRepo.deleteById(id);}

    public Piece updatePiece(Piece piece) {
        return pieceRepo.save(piece);
    }
}
