package com.interview.service;

import com.interview.model.entity.QuestionTag;
import com.interview.repository.AbstractRepository;
import com.interview.repository.QuestionTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionTagService extends AbstractService<QuestionTag, String> {

    private final QuestionTagRepository questionTagRepository;

    @Autowired
    public QuestionTagService(MessageService messageService, QuestionTagRepository questionTagRepository) {
        super(messageService);
        this.questionTagRepository = questionTagRepository;
    }

    @Override
    protected AbstractRepository<QuestionTag, String> getRepository() {
        return questionTagRepository;
    }
}
