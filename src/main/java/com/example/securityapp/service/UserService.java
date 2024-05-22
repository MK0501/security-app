package com.example.securityapp.service;

import com.example.securityapp.model.User;

public interface UserService {
    void getUserById();
    void getAllUsers();
    String addUser(User user);
}
