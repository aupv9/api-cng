package com.finalproject.cafegaming.service.user;

import com.finalproject.cafegaming.model.User;
import com.finalproject.cafegaming.payload.RequestLogin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<User> findAllUser();
    User findUserById(String id);
    Boolean insertUser(User user);
    Boolean updateUser(User user);
    Boolean delUser(String id);
    Boolean exitUserByEmail(String email);
    Boolean exitUserByUsername(String username);
    User findByUsername(String username);
    Boolean checkLogin(RequestLogin user);
    List<User> findAllByRole(Pageable pageable,String role);

}
