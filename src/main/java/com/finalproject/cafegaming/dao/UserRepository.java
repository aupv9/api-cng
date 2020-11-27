package com.finalproject.cafegaming.dao;

import com.finalproject.cafegaming.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    Boolean existsUserByEmail(String email);
    Boolean existsUserByUsername(String username);
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String pw);
    Page<User> findAll(Pageable pageable);
}
