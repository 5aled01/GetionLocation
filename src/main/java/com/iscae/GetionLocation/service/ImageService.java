package com.iscae.GetionLocation.service;

import com.iscae.GetionLocation.model.Image;
import com.iscae.GetionLocation.repo.ImageRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ImageService {

    private final ImageRepo imageRepo;

    public ImageService(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;
    }


    public Image addImage(Image image){
        return imageRepo.save(image);
    }

    public List<Image> findAllImages(){
        return imageRepo.findAll();
    }

    public Optional<Image> findImageById(long id){
        return imageRepo.findById(id);
    }

    public List<Image> findAllImageByIdType(long id_type){
        return imageRepo.findAllImageByIdType(id_type);
    }

    public Image findImageByIdType(long id){
        return imageRepo.findImageByIdType(id);
    }


    public List<Image> findAllImageByIdTypeAndType(long id,String type){
        return imageRepo.findAllImageByIdTypeAndTypeNative(id,type);
    }

    public Optional<Image> findById(long id){
        return imageRepo.findById(id);
    }

    public void deleteImage(long id){imageRepo.deleteById(id);}

    public Image updateImage(Image image) {
        return imageRepo.save(image);
    }



}
