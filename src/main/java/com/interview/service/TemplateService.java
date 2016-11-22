package com.interview.service;

import com.interview.model.entity.Template;
import com.interview.model.entity.User;
import com.interview.repository.AbstractRepository;
import com.interview.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TemplateService extends AbstractService<Template, String> {

    private TemplateRepository templateRepository;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    public TemplateService(MessageService messageService, TemplateRepository templateRepository) {
        super(messageService);
        this.templateRepository = templateRepository;
    }

    @Override
    protected AbstractRepository<Template, String> getRepository() {
        return templateRepository;
    }

    public List<Template> getUserTemplates(User user) {
        if (user == null) {
            return Collections.emptyList();
        }
        return templateRepository.findByUser(user);
    }
}
