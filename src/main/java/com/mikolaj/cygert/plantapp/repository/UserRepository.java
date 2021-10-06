package com.mikolaj.cygert.plantapp.repository;

import com.mikolaj.cygert.plantapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByPasswordAndUserName(String password, String userName);

    Optional<User> findByUserName(String userName);
}
