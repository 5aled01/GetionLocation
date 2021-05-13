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
    public ResponseEntity<List<User>> getAllEmployees(){
        List<User> employees = userService.findAllUsers();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{username}&{password}")
    public ResponseEntity<User> getEmployeeByUsernameAndPassword (@PathVariable("username") String username,
                                                 @PathVariable("password") String password) {


        User employee = userService.findUserByUsernameAndPassword(username,password);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addEmployee(@RequestBody User user) {
            User newUser = userService.findUserByUsername(user);
            if(newUser.getUsername() == "Test"){
                return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
            }
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<User> updateEmployee(@RequestBody User user) {
        User updateUser = userService.updateUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}