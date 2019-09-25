package com.example.jwtexample.repository;

import com.example.jwtexample.entity.Question;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionRespoistoryTest {
    @Autowired
    QuestionRespoistory questionRespoistory;


    @Test
    public void findQuestionByParentId() {
       List<Question> questionList = questionRespoistory.findQuestionByParentId(1);
       assertNotNull(questionList);
    }
}