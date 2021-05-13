package com.iscae.GetionLocation.repo;

import com.iscae.GetionLocation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long>{

    Optional<User> findUserByUsername(String username);


    @Query("SELECT u FROM User u WHERE u.username = ?1 and u.password = ?2")
    Optional<User> findUserByUsernameAndPassword(String username, String password);

    void deleteUserById(Long id);
}