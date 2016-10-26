package com.interview.service;

import com.interview.model.entity.Question;
import com.interview.repository.AbstractRepository;
import com.interview.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService extends AbstractService<Question, String> {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    protected AbstractRepository<Question, String> getRepository() {
        return questionRepository;
    }
}
