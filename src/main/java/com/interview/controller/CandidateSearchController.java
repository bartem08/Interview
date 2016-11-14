package com.interview.controller;

import com.interview.model.entity.Direction;
import com.interview.model.projection.Title;
import com.interview.repository.CandidateSearchRepository;
import com.interview.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/search/candidate")
public class CandidateSearchController extends AbstractController {

    private CandidateService candidateService;

    private DirectionService directionService;

    private CandidateSearchRepository candidateSearchRepository;

    @Autowired
    public CandidateSearchController(MessageService messageService, CandidateService candidateService,
                                     CandidateSearchRepository candidateSearchRepository,
                                     DirectionService directionService) {
        super(messageService);
        this.candidateSearchRepository = candidateSearchRepository;
        this.candidateService = candidateService;
        this.directionService = directionService;
    }

    @RequestMapping(value = "/direction", produces = APPLICATION_JSON_VALUE)
    public Page<Title> findByDirections(@RequestParam("id") String directionID, Pageable pageable) {

        Direction direction = directionService.getNotNull(directionID, "direction.label");

        return candidateService.findByDirections(pageable, direction)
                .map(this::buildTitle);
    }

    @RequestMapping(value = "/name", produces = APPLICATION_JSON_VALUE)
    public List<Title> findByName(String term, Integer offset) {

        return candidateSearchRepository.findCandidates(term, offset)
                .stream()
                .map(this::buildTitle)
                .collect(Collectors.toList());
    }
}
