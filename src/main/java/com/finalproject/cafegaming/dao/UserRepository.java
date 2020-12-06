package com.finalproject.cafegaming.dao;

import com.finalproject.cafegaming.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, String> {
    Boolean existsUserByEmail(String email);
    Boolean existsUserByUsername(String username);
    User findByUsername(String username);
    Page<User> findAllByRolesContaining(Pageable pageable, String role);
    Page<User> findAllByStatus(String s,Pageable pageable);
    Page<User> findAllByIsActive(Boolean aBoolean,Pageable pageable);

}
