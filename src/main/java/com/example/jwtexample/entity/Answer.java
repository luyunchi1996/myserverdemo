package com.example.jwtexample.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "t_answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    Integer id;
    @Column(name = "question_id")
    Integer questionId;
    String content;
    @Column(name = "create_user")
    Integer createUser;
    @Column(name = "create_time")
    Timestamp createTime;
}
