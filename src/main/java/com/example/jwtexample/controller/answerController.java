package com.example.jwtexample.controller;

import com.example.jwtexample.entity.Answer;
import com.example.jwtexample.entity.Question;
import com.example.jwtexample.repository.AnswerRespoistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/answer")
public class answerController {
    @Autowired
    private AnswerRespoistory answerRespoistory;

    @GetMapping("/list")
    public @ResponseBody
    List<Answer> getQuestionList(Integer questionId){
        return answerRespoistory.findAnswerByQuestionId(questionId);
    }

    @PostMapping("/add")
    public @ResponseBody Answer createAnswerDetail(@RequestBody Answer answer){
        return answerRespoistory.save(answer);
    }
}
