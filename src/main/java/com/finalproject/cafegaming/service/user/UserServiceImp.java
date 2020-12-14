package com.finalproject.cafegaming.service.user;

import com.finalproject.cafegaming.config.GoogleDriveConfig;
import com.finalproject.cafegaming.dao.UserRepository;
import com.finalproject.cafegaming.exception.ResourceException;
import com.finalproject.cafegaming.model.User;
import com.finalproject.cafegaming.payload.RequestLogin;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


import java.io.IOException;
import java.util.Collections;
import java.util.List;
/**
 * @author AuPhan
 */

@Service
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;
    final GoogleDriveConfig googleDriveConfig;
    final PasswordEncoder passwordEncoder;
    public UserServiceImp(UserRepository userRepository, GoogleDriveConfig googleDriveConfig, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.googleDriveConfig = googleDriveConfig;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public List<User> findAllUser(Pageable pageable) {
        return userRepository.findAll(pageable).getContent();
    }

    @Override
    public List<User> findAllUserByStatus(String s, Pageable pageable) {
        return userRepository.findAllByStatus(s,pageable).toList();
    }

    @Override
    public List<User> findAllUserByActive(boolean b, Pageable pageable) {
        return userRepository.findAllByIsActive(b,pageable).toList();
    }

    @Override
    public User findUserById(String id) {
        return userRepository.findById(id).orElseThrow(ResourceException::new);
    }

    @Override
    public Boolean insertUser(User user) {
        assert user.getRoles() != null;
        user.getRoles().forEach(s -> {
            if (!s.startsWith("ROLE_")){
                user.setRoles(Collections.singletonList(("ROLE_"+s).toUpperCase()));
//                List<String> chars= Arrays.asList(s.split("_"));
//                user.setRoles(Collections.singletonList("ROLE_" + chars.get(1)));
            }
        });
        System.out.println(user.getPassword());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user) instanceof User;
    }

    @Override
    public Boolean updateUser(User user) throws IOException {
        User user1 = findUserById(user.getId());
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setBirthday(user.getBirthday());
        user1.setEmail(user.getEmail());
        googleDriveConfig.uploadImage(user1.getImage().getValue());
        user1.setImage(user.getImage());
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
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Boolean checkLogin(@Validated RequestLogin user) {
        User user1 = findByUsername(user.getUsername());
        if(user1 != null){
            if (passwordEncoder.matches(user.getPassword(),user1.getPassword())){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<User> findAllByRole(Pageable pageable,String role) {
        StringBuilder roleQuery = new StringBuilder();
        switch (role){
            case "admin":
                roleQuery.append("ROLE_ADMIN");
                break;
            case "partner":
                roleQuery.append("ROLE_PARTNER");
                break;
            default:
                roleQuery.append("ROLE_MEMBER");
                break;
        }
        return userRepository.findAllByRolesContaining(pageable,roleQuery.toString()).getContent();
    }

    @Override
    public Boolean updateProfile(User user) {
        User user1 = findUserById(user.getUsername());
        if(passwordEncoder.matches(user.getPassword(),user1.getPassword())){
            user1.setFirstName(user.getFirstName());
            user1.setLastName(user.getLastName());
            user1.setAddress(user.getAddress());
            user1.setEmail(user.getEmail());
            user1.setBirthday(user.getBirthday());
            user1.setPhone(user.getPhone());
            user1.setImage(user.getImage());
            userRepository.save(user1);
            return true;
        }
        else{
            return false;
        }
    }


}
