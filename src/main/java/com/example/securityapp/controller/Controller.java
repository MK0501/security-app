package com.example.securityapp.controller;

import com.example.securityapp.model.User;
import com.example.securityapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/")
public class Controller {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String welcome(){
        return "Welcome!";
    }

    @GetMapping("/admin")
    public String print(){
        return "you are an admin, so you can view this page!";
    }

    @GetMapping("/user-login")
    public String printMsg(){
        return "common page for user and admin";
    }

    @PostMapping("/register")
    public ResponseEntity saveUser(@RequestBody User user){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Info", "Registering the user");
        return ResponseEntity
                .ok()
                .headers(httpHeaders)
                .body(userService.addUser(user)
                );
    }


}
