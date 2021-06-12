package com.iscae.GetionLocation.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iscae.GetionLocation.model.User;
import com.iscae.GetionLocation.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;


@RestController
@RequestMapping("/user")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> users = userService.findAllUsers();
        for (User user : users) {
            user.setImage(decompressBytes(user.getImage()));
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/find/{username}&{password}")
    public ResponseEntity<User> getUserByUsernameAndPassword(@PathVariable("username") String username,
                                                             @PathVariable("password") String password) {

        boolean auth = userService.findUserByUsername(username, password);
        if (auth) {
            User user1 = userService.findUserByUsername2(username);
            user1.setImage(decompressBytes(user1.getImage()));
            return new ResponseEntity<>(user1, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }


    @PostMapping(value = "/add")

    public ResponseEntity<User> addUser(@RequestParam("user") String userst, @RequestParam("imageFile") MultipartFile imageFile) throws IOException {

        User user = new ObjectMapper().readValue(userst, User.class);

        user.setImage(compressBytes(imageFile.getBytes()));
        userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/updatewithimg")
    public ResponseEntity<User> updateUser(@RequestParam("user") String userst, @RequestParam("imageFile") MultipartFile imageFile) throws IOException {

        User user = new ObjectMapper().readValue(userst, User.class);

        user.setImage(compressBytes(imageFile.getBytes()));
        User updateUser = userService.updateUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestParam("user") String userst) throws IOException {

        User user = new ObjectMapper().readValue(userst, User.class);
        User user1 = userService.findUserById(user.getId());
        user.setImage(user1.getImage());
        User updateUser = userService.updateUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    public static byte[] compressBytes(byte[] data) {

        Deflater deflater = new Deflater();

        deflater.setInput(data);

        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

        byte[] buffer = new byte[1024];

        while (!deflater.finished()) {

            int count = deflater.deflate(buffer);

            outputStream.write(buffer, 0, count);
        }

        try {

            outputStream.close();

        } catch (IOException e) {

        }

        //  System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

        return outputStream.toByteArray();

    }

    public static byte[] decompressBytes(byte[] data) {

        Inflater inflater = new Inflater();

        inflater.setInput(data);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

        byte[] buffer = new byte[1024];

        try {

            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);

                outputStream.write(buffer, 0, count);

            }

            outputStream.close();

        } catch (IOException ioe) {

        } catch (DataFormatException e) {

        }

        return outputStream.toByteArray();

    }


}
