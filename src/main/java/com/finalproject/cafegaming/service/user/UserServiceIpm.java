package com.finalproject.cafegaming.service.user;

import com.finalproject.cafegaming.dao.UserRepository;
import com.finalproject.cafegaming.exception.ResourceException;
import com.finalproject.cafegaming.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceIpm implements UserService{

    private final UserRepository userRepository;

    public UserServiceIpm(UserRepository userRepository) {
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
        return null;
    }

    @Override
    public void delUser(String id) {
        User user1 =userRepository.findById(id).orElseThrow(ResourceException::new);
        userRepository.deleteById(user1.getId());
    }

    @Override
    public Boolean exitUserByEmail(String email) {
        return userRepository.existsUserByEmail(email);
    }

    @Override
    public Boolean exitUserByUsername(String username) {
        return userRepository.existsUserByUsername(username);
    }
}
