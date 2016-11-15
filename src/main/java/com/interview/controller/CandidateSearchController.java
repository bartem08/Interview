package com.interview.controller;

import com.interview.model.projection.Title;
import com.interview.repository.CandidateSearchRepository;
import com.interview.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/search/candidate")
public class CandidateSearchController extends AbstractController {

    private CandidateSearchRepository candidateSearchRepository;

    @Autowired
    public CandidateSearchController(MessageService messageService,
                                     CandidateSearchRepository candidateSearchRepository) {
        super(messageService);
        this.candidateSearchRepository = candidateSearchRepository;
    }

    @RequestMapping(produces = APPLICATION_JSON_VALUE)
    public List<Title> findByNameOrPhoneNumber(String term, Integer offset) {

        return candidateSearchRepository.findCandidatesBySearchWord(term, offset)
                .stream()
                .map(this::buildTitle)
                .collect(Collectors.toList());
    }
}
