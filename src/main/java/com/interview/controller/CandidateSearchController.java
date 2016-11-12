package com.interview.controller;

import com.interview.model.entity.Direction;
import com.interview.model.projection.Title;
import com.interview.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/search/candidate")
public class CandidateSearchController extends AbstractController {

    private CandidateService candidateService;

    private DirectionService directionService;

    @Autowired
    public CandidateSearchController(MessageService messageService, CandidateService candidateService,
                                     DirectionService directionService) {
        super(messageService);
        this.candidateService = candidateService;
        this.directionService = directionService;
    }

    @RequestMapping(produces = APPLICATION_JSON_VALUE)
    public Page<Title> findByDirections(@RequestParam("direction") String directionID, Pageable pageable) {

        Direction direction = directionService.getNotNull(directionID, "direction.label");

        return candidateService.findByDirections(pageable, direction)
                .map(this::buildTitle);
    }
}
