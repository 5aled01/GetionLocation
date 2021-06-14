package com.iscae.GetionLocation.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iscae.GetionLocation.model.Etage;
import com.iscae.GetionLocation.model.Image;
import com.iscae.GetionLocation.model.ProC2;
import com.iscae.GetionLocation.model.Proprietaire;
import com.iscae.GetionLocation.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/image")
public class ImageResource {

    private final ImageService imageService;

    public ImageResource(ImageService imageservice) {
        this.imageService = imageservice;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Image>> getAllImage() {
        List<Image> etages = imageService.findAllImages();
        return new ResponseEntity<>(etages, HttpStatus.OK);

    }

    @GetMapping("/add")
    public ResponseEntity<Image> addImage(@RequestParam("image") String imagest, @RequestParam("imageFile") MultipartFile imageFile) throws IOException {

         Image image = new ObjectMapper().readValue(imagest, Image.class);
        image.setImage(image.compressBytes(imageFile.getBytes()));
        imageService.addImage(image);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<List<Image>> getImageByIdType(@PathVariable("id") Long id_type){

        List<Image> images = imageService.findAllImageByIdType(id_type);
        for (Image image : images) {
            if(image.getImage()!=null)
                image.setImage(image.decompressBytes(image.getImage()));
        }
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @GetMapping("/find/{id}&{type}")
    public ResponseEntity<List<Image>> getImageByIdTypeAndType(@PathVariable("id") Long id,@PathVariable("type") String type){

        List<Image> images = imageService.findAllImageByIdTypeAndType(id,type);
        for (Image image : images) {
            if(image.getImage()!=null)
                image.setImage(image.decompressBytes(image.getImage()));
        }
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Image> updateImage(@RequestParam("image") String imagest, @RequestParam("imageFile") MultipartFile imageFile) throws IOException {

        Image image = new ObjectMapper().readValue(imagest, Image.class);

        image.setImage(image.compressBytes(imageFile.getBytes()));
        Image updateImage = imageService.updateImage(image);
        return new ResponseEntity<>(updateImage, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteImage(@PathVariable("id") Long id) {
        imageService.deleteImage(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}