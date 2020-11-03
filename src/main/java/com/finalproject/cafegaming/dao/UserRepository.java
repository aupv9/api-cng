package com.finalproject.cafegaming.dao;

import com.finalproject.cafegaming.model.User;
import com.finalproject.cafegaming.payload.RequestLogin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    Boolean existsUserByEmail(String email);
    Boolean existsUserByUsername(String username);
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String pw);
}
