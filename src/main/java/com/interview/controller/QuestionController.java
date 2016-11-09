package com.interview.controller;

import com.interview.exception.NotFoundException;
import com.interview.model.entity.Question;
import com.interview.model.projection.QuestionInfo;
import com.interview.service.MessageService;
import com.interview.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questions")
public class QuestionController extends AbstractController {

    private QuestionService questionService;

    @Autowired
    protected QuestionController(MessageService messageService, QuestionService questionService) {
        super(messageService);
        this.questionService = questionService;
    }

    @RequestMapping("/{id}")
    public QuestionInfo getQuestion(@PathVariable("id") String id) {

        Question question = questionService.get(id)
                .orElseThrow(() ->
                        new NotFoundException(messageService.getMessage("not.found", "question.label", id)));

        return QuestionInfo.builder()
                .id(id)
                .question(question.getContent())
                .topic(question.getTopic().toString())
                .build();
    }
}
