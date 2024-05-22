package com.example.securityapp.exceptions;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserNotFound extends UsernameNotFoundException {

    public UserNotFound(String msg) {
        super(msg);
    }
}
