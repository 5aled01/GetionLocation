package com.iscae.GetionLocation.resource;


import com.iscae.GetionLocation.model.Etage;
import com.iscae.GetionLocation.model.Piece;
import com.iscae.GetionLocation.service.PieceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/piece")
public class PieceResource {

    private final PieceService pieceService;

    public PieceResource(PieceService pieceService) {
        this.pieceService = pieceService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Piece>> getAllPiece() {
        List<Piece> pieces = pieceService.findAllPiece();

        return new ResponseEntity<>(pieces, HttpStatus.OK);

    }

    @GetMapping("/add")
    public ResponseEntity<Etage> addEtage(@RequestBody Piece piece) {
        pieceService.addPiece(piece);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping("/find/{id}")
    public Optional<Piece> getPiece(@PathVariable("id") Long id){

        return pieceService.findById(id);

    }


    @PutMapping("/update")
    public ResponseEntity<Piece> updateEtage(@RequestBody Piece piece) throws IOException {

        Piece updatePiece = pieceService.updatePiece(piece);
        return new ResponseEntity<>(updatePiece, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePiece(@PathVariable("id") Long id) {
        pieceService.deletePiece(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
