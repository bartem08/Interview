package com.interview.controller;

import com.interview.exception.NotFoundException;
import com.interview.model.entity.Candidate;
import com.interview.model.projection.CandidateInfo;
import com.interview.service.CandidateService;
import com.interview.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping("/candidates")
public class CandidateController extends AbstractController {

    private CandidateService candidateService;

    @Autowired
    public CandidateController(MessageService messageService, CandidateService candidateService) {
        super(messageService);
        this.candidateService = candidateService;
    }

    @RequestMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public CandidateInfo getCandidate(@PathVariable("id") String id) {

        Candidate candidate = candidateService.get(id)
                .orElseThrow(() -> new NotFoundException(
                        messageService.getMessage("not.found", "candidate.label", id)));

        return CandidateInfo.builder()
                .title(buildTitle(candidate))
                .dateOfBirth(candidate.getDateOfBirth().toString())
                .email(candidate.getEmail())
                .phone(candidate.getPhone())
                .build();
    }
}
