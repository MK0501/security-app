package com.example.securityapp.impl;

import com.example.securityapp.exceptions.UserNotFoundException;
import com.example.securityapp.model.Role;
import com.example.securityapp.model.User;
import com.example.securityapp.repo.RoleRepo;
import com.example.securityapp.repo.UserRepo;
import com.example.securityapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo
                .findByUserName(username)
                .orElseThrow(() -> new UserNotFoundException("User not found with the name:"+username));
    }

    @Override
    public void getUserById() {

    }

    @Override
    public void getAllUsers() {

    }

    @Override
    public String addUser(User user) {
        User user1 = user;
        user1.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = roleRepo.findById(2L).orElseThrow(
                () -> new UserNotFoundException("role not found")
        );
        user1.setRole(role);
        userRepo.save(user1);
        return "user registered succesfully!";
    }
}
