package com.iscae.GetionLocation.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iscae.GetionLocation.model.Image;

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


    @GetMapping("/allbatiproc/{id}")
    public ResponseEntity<List<Image>> getAllImageofbati(@PathVariable("id") long id) {
        List<Image> images = imageService.findAllImagesBatiProc2(id);
        for (Image image : images) {
            if(image.getImage()!=null)
                image.setImage(image.decompressBytes(image.getImage()));
        }
        return new ResponseEntity<>(images, HttpStatus.OK);

    }
    @GetMapping("/all")
    public ResponseEntity<List<Image>> getAllImage() {
        List<Image> etages = imageService.findAllImages();
        return new ResponseEntity<>(etages, HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<Image> addImage(@RequestParam("image") String imagest, @RequestParam("imageFile") MultipartFile imageFile) throws IOException {

         Image image = new ObjectMapper().readValue(imagest, Image.class);
        image.setImage(image.compressBytes(imageFile.getBytes()));
        imageService.addImage(image);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<List<Image>> getImageByIdType(@PathVariable("idcorespondance") Long idCorespondance){

        List<Image> images = imageService.findAllImageByIdCorespondance(idCorespondance);
        for (Image image : images) {
            if(image.getImage()!=null)
                image.setImage(image.decompressBytes(image.getImage()));
        }
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @GetMapping("/finds/{id}")
    public ResponseEntity<List<Image>> getImageByIdTypeAndType(@PathVariable("id") long idCorespondance){

        List<Image> images = imageService.findAllImageByidCorespondance(idCorespondance);
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
    public ResponseEntity<?> deleteImage(@PathVariable("id") long id) {
        imageService.deleteImage(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}