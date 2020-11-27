package com.finalproject.cafegaming.controller;

import com.finalproject.cafegaming.model.User;
import com.finalproject.cafegaming.payload.RequestLogin;
import com.finalproject.cafegaming.payload.ResponseLogin;
import com.finalproject.cafegaming.service.JwtService.JwtService;
import com.finalproject.cafegaming.service.user.UserServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class UserController {

    private final UserServiceImp userServiceImp;
    private final JwtService jwtService;
    public UserController(UserServiceImp userServiceImp, JwtService jwtService) {
        this.userServiceImp = userServiceImp;
        this.jwtService = jwtService;
    }

    @GetMapping(value = "/users", produces = "application/json")
    public ResponseEntity<?> findAllUser(){
        List<User> users =  userServiceImp.findAllUser();
        return  users != null ? new ResponseEntity<>(users, HttpStatus.OK):
                new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/user")
    public ResponseEntity<?> insertUser(@RequestBody @Validated User user){
        if(userServiceImp.exitUserByUsername(user.getUsername())){
            return new ResponseEntity<>("Username is already",HttpStatus.BAD_REQUEST);
        }
        if(userServiceImp.exitUserByEmail(user.getEmail())){
            return new ResponseEntity<>("Email is adlready",HttpStatus.BAD_REQUEST);
        }
        return  userServiceImp.insertUser(user) ? new ResponseEntity<>(true, HttpStatus.OK) :
                new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);

    }
    /*
   Method login
   @param User user truyền từ client vào
   return Response
   * */
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<ResponseLogin> login(@RequestBody RequestLogin user) {

        ResponseLogin result = new ResponseLogin();
        HttpStatus httpStatus = null;
        try {
            if (userServiceImp.checkLogin(user)) {
                result.setToken(jwtService.generateTokenLogin(user.getUsername()));
                List<String> roles = userServiceImp.loadUserByUsername(user.getUsername()).getRoles();
                result.setRoles(roles);
                httpStatus = HttpStatus.OK;
            } else {
                result.setToken("Wrong userId and password");
                httpStatus = HttpStatus.BAD_REQUEST;
            }
        } catch (Exception ex) {
            result.setToken("Server Error");
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<ResponseLogin>(result, httpStatus);
    }


}
