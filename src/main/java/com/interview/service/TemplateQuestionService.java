package com.interview.service;

import com.interview.model.TQuestionId;
import com.interview.model.entity.TemplateQuestion;
import com.interview.repository.AbstractRepository;
import com.interview.repository.TemplateQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemplateQuestionService extends AbstractService<TemplateQuestion, TQuestionId> {

    private final TemplateQuestionRepository templateQuestionRepository;

    @Autowired
    public TemplateQuestionService(MessageService messageService,
                                   TemplateQuestionRepository templateQuestionRepository) {
        super(messageService);
        this.templateQuestionRepository = templateQuestionRepository;
    }

    @Override
    protected AbstractRepository<TemplateQuestion, TQuestionId> getRepository() {
        return templateQuestionRepository;
    }
}
