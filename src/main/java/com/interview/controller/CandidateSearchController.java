package com.interview.controller;

import com.interview.model.projection.Title;
import com.interview.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/search/candidate")
public class CandidateSearchController extends AbstractController {

    private CandidateService candidateService;

    @Autowired
    public CandidateSearchController(MessageService messageService, CandidateService candidateService) {
        super(messageService);
        this.candidateService = candidateService;
    }

    @RequestMapping(produces = APPLICATION_JSON_VALUE)
    public List<Title> findByNameOrPhoneNumber(String term, Integer offset) {

        return candidateService.findCandidatesByNameOrPhoneNumber(term, offset)
                .stream()
                .map(this::buildTitle)
                .collect(Collectors.toList());
    }
}
