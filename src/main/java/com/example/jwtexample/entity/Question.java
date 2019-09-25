package com.example.jwtexample.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "t_question")
public class Question {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    Integer id;
    String status;
    String content;
    @Column(name = "create_time")
    Timestamp createTime;
    @Column(name = "answer_number")
    Integer answerNumber;
    @Column(name = "create_user")
    Integer createUser;
    String category;
    @Column(name = "parent_id")
    Integer parentId=0;
    @Column(name ="sub_question_number")
    Integer subQuestionNumber=0;
}
