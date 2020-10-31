package com.finalproject.cafegaming.controller;


import com.finalproject.cafegaming.model.User;
import com.finalproject.cafegaming.service.user.UserServiceIpm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserServiceIpm userServiceIpm;
    public UserController(UserServiceIpm userServiceIpm) {
        this.userServiceIpm = userServiceIpm;
    }

    @GetMapping(value = "/users", produces = "application/json")
    public ResponseEntity<?> findAllUser(){
        List<User> users =  userServiceIpm.findAllUser();
        return  users != null ? new ResponseEntity<>(users, HttpStatus.OK):
                new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/user")
    public ResponseEntity<?> insertUser(@RequestBody @Validated User user){
        if(userServiceIpm.exitUserByUsername(user.getUsername())){
            return new ResponseEntity<>("Username is already",HttpStatus.BAD_REQUEST);
        }
        if(userServiceIpm.exitUserByEmail(user.getEmail())){
            return new ResponseEntity<>("Email is adlready",HttpStatus.BAD_REQUEST);
        }
        return  userServiceIpm.insertUser(user) ? new ResponseEntity<>(true, HttpStatus.OK) :
                new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);

    }


}
