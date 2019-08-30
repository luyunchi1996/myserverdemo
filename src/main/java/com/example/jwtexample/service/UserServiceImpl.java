package com.example.jwtexample.service;

import com.example.jwtexample.entity.User;
import com.example.jwtexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    public User findByUsername(User user){
        user = userRepository.getUserByName(user.getName());
        return user;
    }
    public User findUserById(String id) {
        Optional<User> userOptional = userRepository.findById( new Integer(id));
        return userOptional.get();
    }

    @Override
    public User SaveUser(User user) {
        return userRepository.save(user);
    }
}
