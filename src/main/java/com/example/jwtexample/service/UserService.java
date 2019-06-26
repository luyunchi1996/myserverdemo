package com.example.jwtexample.service;

import com.example.jwtexample.entity.User;


public interface UserService {
    public User findByUsername(User user);
    public User findUserById(String id);
    public User SaveUser(User user);
}
