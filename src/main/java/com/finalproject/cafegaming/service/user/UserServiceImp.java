package com.finalproject.cafegaming.service.user;

import com.finalproject.cafegaming.dao.UserRepository;
import com.finalproject.cafegaming.exception.ResourceException;
import com.finalproject.cafegaming.model.User;
import com.finalproject.cafegaming.payload.RequestLogin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(String id) {
        return userRepository.findById(id).orElseThrow(ResourceException::new);
    }

    @Override
    public Boolean insertUser(User user) {
        return userRepository.save(user) instanceof User;
    }

    @Override
    public Boolean updateUser(User user) {
        User user1 =findUserById(user.getId());
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setAddress(user.getAddress());
        user1.setBirthday(user.getBirthday());
        user1.setEmail(user.getEmail());
        user1.setProfile(user.getProfile());
        user1.setRoles(user.getRoles());
        return userRepository.save(user1) instanceof User;
    }

    @Override
    public Boolean delUser(String id) {
        User user1 =findUserById(id);
        user1.setIsActive(false);
        return userRepository.save(user1) instanceof User;
    }

    @Override
    public Boolean exitUserByEmail(String email) {
        return userRepository.existsUserByEmail(email);
    }

    @Override
    public Boolean exitUserByUsername(String username) {
        return userRepository.existsUserByUsername(username);
    }

    @Override
    public User loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Boolean checkLogin(@Validated RequestLogin user) {
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword()) != null;
    }

    @Override
    public List<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable).getContent();
    }


}
