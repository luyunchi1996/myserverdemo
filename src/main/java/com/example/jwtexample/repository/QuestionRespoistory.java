package com.example.jwtexample.repository;

import com.example.jwtexample.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRespoistory extends JpaRepository<Question,Integer> {

    @Query("SELECT question FROM  Question  question where question.parentId= ?1 order by question.createTime desc ")
    List<Question> findQuestionByParentId(Integer parentId);

}
