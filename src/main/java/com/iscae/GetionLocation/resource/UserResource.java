package com.iscae.GetionLocation.resource;

import com.iscae.GetionLocation.model.User;
import com.iscae.GetionLocation.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> user = userService.findAllUsers();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/find/{username}&{password}")
    public ResponseEntity<User> getUserByUsernameAndPassword (@PathVariable("username") String username,
                                                 @PathVariable("password") String password) {

        boolean auth = userService.findUserByUsername(username,password);
        if(auth) {
            User user1 =  userService.findUserByUsername2(username);
            return new ResponseEntity<>(user1, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
            boolean Test = userService.findUserByUsername(user.getUsername()).isPresent();
            if(!Test){
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            }
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updateUser = userService.updateUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
