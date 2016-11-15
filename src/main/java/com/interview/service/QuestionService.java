package com.interview.service;

import com.interview.model.entity.Question;
import com.interview.repository.AbstractRepository;
import com.interview.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService extends AbstractService<Question, String> {

    private QuestionRepository questionRepository;

    @Autowired
    public QuestionService(MessageService messageService, QuestionRepository questionRepository) {
        super(messageService);
        this.questionRepository = questionRepository;
    }

    @Override
    protected AbstractRepository<Question, String> getRepository() {
        return questionRepository;
    }
}
