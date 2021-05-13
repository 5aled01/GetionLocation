package com.iscae.GetionLocation.service;

import com.iscae.GetionLocation.exception.UserNotFoundException;
import com.iscae.GetionLocation.model.User;
import com.iscae.GetionLocation.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {


    private final UserRepo userRepo;

 //   private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepo userrepo, UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public User addUser(User user){
       return userRepo.save(user);
    }

    public List<User> findAllUsers(){
        return userRepo.findAll();
    }

    public User updateUser(User user){
        return userRepo.save (user);
    }

    public User findUserByUsernameAndPassword(String username, String password) {
        return userRepo.findUserByUsernameAndPassword(username,password)
                .orElseThrow(() -> new UserNotFoundException("User by name " + username + " was not found"));
    }

    public void deleteUser(Long id){
        userRepo.deleteUserById(id);
    }

}
