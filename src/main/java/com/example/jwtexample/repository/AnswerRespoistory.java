package com.example.jwtexample.repository;

import com.example.jwtexample.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerRespoistory extends JpaRepository<Answer,Integer> {
    @Query("SELECT answer FROM Answer  answer where  answer.questionId = ?1")
    List<Answer> findAnswerByQuestionId(Integer questionId);
}
