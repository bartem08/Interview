package com.interview.controller;

import com.interview.model.Response;
import com.interview.model.entity.Candidate;
import com.interview.model.projection.CandidateInfo;
import com.interview.service.CandidateService;
import com.interview.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/candidates")
public class CandidateController extends AbstractController {

    private CandidateService candidateService;

    @Autowired
    protected CandidateController(MessageService messageService, CandidateService candidateService) {
        super(messageService);
        this.candidateService = candidateService;
    }

    @RequestMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public CandidateInfo getCandidate(@PathVariable("id") String id) {

        Candidate candidate = candidateService.getNotNull(id, "candidate.label");

        return CandidateInfo.builder()
                .title(buildTitle(candidate))
                .dateOfBirth(candidate.getDateOfBirth().toString())
                .email(candidate.getEmail())
                .phone(candidate.getPhone())
                .build();
    }

    @Secured("ROLE_HR")
    @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Response createCandidate(@RequestBody Candidate candidate) {

        if (!candidateService.create(candidate).isPresent()) {
            return buildResponse(CONFLICT, messageService.getMessage("not.create", "candidate.label"));
        }
        return buildResponse(CREATED, messageService.getMessage("success.create", "candidate.label"));
    }

    @Secured("ROLE_HR")
    @RequestMapping(method = PUT, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Response updateCandidate(@RequestBody Candidate candidate) {

        if (!candidateService.update(candidate).isPresent()) {
            return buildResponse(CONFLICT, messageService.getMessage("not.update", "candidate.label"));
        }
        return buildResponse(OK, messageService.getMessage("success.update", "candidate.label"));
    }

    @Secured("ROLE_HR")
    @RequestMapping(value = "/{id}", method = DELETE, produces = APPLICATION_JSON_VALUE)
    public Response deleteCandidate(@PathVariable("id") String id) {

        if (!candidateService.deleteById(id)) {
            return buildResponse(CONFLICT, messageService.getMessage("not.delete", "candidate.label"));
        }
        return buildResponse(OK, messageService.getMessage("success.delete", "candidate.label"));
    }
}
