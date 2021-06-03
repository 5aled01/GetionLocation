package com.iscae.GetionLocation.repo;

import com.iscae.GetionLocation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long>{

    Optional<User> findUserByUsername(String username);

    @Query(value = "SELECT * FROM User WHERE username = :username",
            nativeQuery = true)
    User findUserByUsername2(@Param("username") String username);

    @Query(value = "SELECT password FROM User WHERE username = :username",
            nativeQuery = true)
    String findPasswordByUsernameNative(@Param("username") String username);


    void deleteUserById(Long id);
}
