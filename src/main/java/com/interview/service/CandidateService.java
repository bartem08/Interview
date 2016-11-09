package com.interview.service;

import com.interview.model.entity.Candidate;
import com.interview.repository.AbstractRepository;
import com.interview.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService extends AbstractService<Candidate, String> {

    private CandidateRepository candidateRepository;

    @Autowired
    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    protected AbstractRepository<Candidate, String> getRepository() {
        return candidateRepository;
    }
}
