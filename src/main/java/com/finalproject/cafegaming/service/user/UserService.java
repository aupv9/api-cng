package com.finalproject.cafegaming.service.user;

import com.finalproject.cafegaming.dao.UserRepository;
import com.finalproject.cafegaming.model.User;

import java.util.List;

public interface UserService {
    List<User> findAllUser();
    User findUserById(String id);
    Boolean insertUser(User user);
    Boolean updateUser(User user);
    void delUser(String id);
    Boolean exitUserByEmail(String email);
    Boolean exitUserByUsername(String username);
}
