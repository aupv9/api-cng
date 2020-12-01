package com.finalproject.cafegaming.service.user;

import com.finalproject.cafegaming.dao.UserRepository;
import com.finalproject.cafegaming.enums.Role;
import com.finalproject.cafegaming.exception.ResourceException;
import com.finalproject.cafegaming.model.User;
import com.finalproject.cafegaming.payload.RequestLogin;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionUsageException;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;
    final PasswordEncoder passwordEncoder;
    public UserServiceImp(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public List<User> findAllUser() {
        System.out.println("note" + userRepository);
        return userRepository.findAll();
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
    public Boolean updateUser(User user) {
        User user1 =findUserById(user.getId());
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setPassword(passwordEncoder.encode(user.getPassword()));
        user1.setAddress(user.getAddress());
        user1.setBirthday(user.getBirthday());
        user1.setEmail(user.getEmail());
        user1.setProfile(user.getProfile());
        user1.setRoles(user.getRoles());
        user1.setUpdateAt(LocalDateTime.now());
        return userRepository.save(user1) instanceof User;
    }

    @Override
    public Boolean delUser(String id) {
        User user1 =findUserById(id);
        user1.setIsActive(false);
        user1.setUpdateAt(LocalDateTime.now());
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


}
