package com.iscae.GetionLocation.service;

import com.iscae.GetionLocation.model.User;
import com.iscae.GetionLocation.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    private final UserRepo userRepo;


    @Autowired
    public UserService(BCryptPasswordEncoder bCryptPasswordEncoder, UserRepo userRepo){
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepo = userRepo;
    }

    public User addUser(User user){
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
       return userRepo.save(user);
    }



    public List<User> findAllUsers(){
        return userRepo.findAll();
    }

    public User updateUser(User user){
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepo.save(user);
    }

    public boolean findUserByUsername(String username, String password) {
        boolean userExists = userRepo.findUserByUsername(username).isPresent();
        if(!userExists) {
            return false;
        }
        String passCode = userRepo.findPasswordByUsernameNative(username);
            if(bCryptPasswordEncoder.matches(password,passCode)){
                    return true;
            }
        return false;

        }
/*
    public Optional<User> findUser(String username, String password) {
        boolean userExists = userRepo.findUserByUsername(username).isPresent();
        if(!userExists) {
            return null;
        }
        String passCode = userRepo.findPasswordByUsernameNative(username);
        if(bCryptPasswordEncoder.matches(password,passCode)){
            return userRepo.findUserByUsername(username);
        }
        return userRepo.findUserByUsername(username);

    }
    */


    public Optional<User> findUserByUsername(String username) {
        return userRepo.findUserByUsername(username);
    }
    public User findUserByUsername2(String username) {
        return userRepo.findUserByUsername2(username);
    }

    public void deleteUser(long id){
        userRepo.deleteUserById(id);
    }

     public  User findUserById(long id){
        return  userRepo.findUserById(id);
     }
}
