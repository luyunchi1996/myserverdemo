package com.example.jwtexample.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_user")
public class User  {
   @Id
   @GeneratedValue()
   Integer id;
   String name;
   @Column(name = "nick_name")
   String nickName;
   @Column(name = "pass_word")
   String passWord;
}
