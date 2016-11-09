package com.interview.service;

import com.interview.model.entity.Template;
import com.interview.repository.AbstractRepository;
import com.interview.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemplateService extends AbstractService<Template, String> {

    private TemplateRepository templateRepository;

    @Autowired
    public TemplateService(TemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    @Override
    protected AbstractRepository<Template, String> getRepository() {
        return templateRepository;
    }
}
