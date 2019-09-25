package com.example.jwtexample.controller;

import com.example.jwtexample.entity.Question;
import com.example.jwtexample.repository.QuestionRespoistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/question")
public class questionController {
    @Autowired
    private QuestionRespoistory questionRespoistory;

    @GetMapping("/list")
    public @ResponseBody List<Question> getQuestionList(Integer parentId){
        return questionRespoistory.findQuestionByParentId(parentId);
    }

    @GetMapping("/detail")
    public @ResponseBody List<Question> getQuestionDetail(Integer parentId){
        return questionRespoistory.findQuestionByParentId(parentId);
    }
    @PostMapping("/add")
    public @ResponseBody Question createQuestionDetail(@RequestBody Question question){
         return questionRespoistory.save(question);
    }

}
