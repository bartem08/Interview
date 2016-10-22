package com.interview.service;

import com.interview.model.entity.Candidate;
import com.interview.repository.AbstractRepository;
import com.interview.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService extends AbstractService<Candidate> {

    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    protected AbstractRepository<Candidate> getRepository() {
        return candidateRepository;
    }
}
