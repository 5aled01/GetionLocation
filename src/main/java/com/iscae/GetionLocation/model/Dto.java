package com.iscae.GetionLocation.model;
import org.springframework.web.multipart.MultipartFile;


public class Dto   {

        public User user;
        public MultipartFile imageFile;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }


}
