package com.example.securityapp.impl;

import com.example.securityapp.model.Role;
import com.example.securityapp.model.User;
import com.example.securityapp.repo.UserRepo;
import com.example.securityapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUserName(username);
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
        List<Role> roleList = new ArrayList<>();
        Role role = new Role();
        role.setRoleId(2L);
        role.setRoleName("user");
        roleList.add(role);
        user1.setRoleList(roleList);
        userRepo.save(user1);
        return "user registered succesfully!";
    }
}
