package com.iscae.GetionLocation.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String username;
    private String password;
    private String role;
    @Lob
    private byte[] image ;
    public User(){}

    public User(Long id, String username, String password, String role, byte[] image) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
