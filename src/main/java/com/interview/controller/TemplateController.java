package com.interview.controller;

import com.interview.model.entity.Template;
import com.interview.model.projection.TemplateLine;
import com.interview.service.MessageService;
import com.interview.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping("/templates")
public class TemplateController extends AbstractController {

    private TemplateService templateService;

    @Autowired
    protected TemplateController(TemplateService templateService, MessageService messageService) {
        super(messageService);
        this.templateService = templateService;
    }

    @RequestMapping(value = "/user", produces = APPLICATION_JSON_VALUE)
    public List<TemplateLine> getAllUserTemplates() {

        return templateService.getUserTemplates(getCurrentUser())
                .stream()
                .map(template -> TemplateLine.builder()
                        .id(template.getId())
                        .name(template.getName())
                        .direction(template.getDirection().getName())
                        .favourite(template.isFavourite())
                        .build())
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Template getTemplateById(@PathVariable("id") String id) {

        return templateService.getNotNull(id, "template.label");
    }
}
