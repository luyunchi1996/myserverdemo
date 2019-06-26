package com.example.jwtexample.repository;

import com.example.jwtexample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,String> {
     @Query(value = "SELECT user from User  user where  name = ?1")
     public User getUserByName(String name);


}
