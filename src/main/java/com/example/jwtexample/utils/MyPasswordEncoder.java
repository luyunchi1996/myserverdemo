package com.example.jwtexample.utils;


import com.example.jwtexample.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;


public class MyPasswordEncoder implements PasswordEncoder {

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.equals(MD5Util.encode((String)rawPassword));
    }

    @Override
    public String encode(CharSequence rawPassword) {
        return MD5Util.encode((String)rawPassword);
    }
}