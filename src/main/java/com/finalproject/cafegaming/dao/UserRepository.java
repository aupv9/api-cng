package com.finalproject.cafegaming.dao;

import com.finalproject.cafegaming.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    Boolean existsUserByEmail(String email);
    Boolean existsUserByUsername(String username);
}