package com.interview.service;

import com.interview.model.entity.Candidate;
import com.interview.model.entity.Direction;
import com.interview.repository.AbstractRepository;
import com.interview.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CandidateService extends AbstractService<Candidate, String> {

    private CandidateRepository candidateRepository;

    @Autowired
    public CandidateService(MessageService messageService, CandidateRepository candidateRepository) {
        super(messageService);
        this.candidateRepository = candidateRepository;
    }

    @Override
    protected AbstractRepository<Candidate, String> getRepository() {
        return candidateRepository;
    }

    public Page<Candidate> findByDirections(Pageable pageable, Direction ... directions) {

        List<Direction> directionList = Arrays.asList(directions);
        return candidateRepository.findAllByDirectionsIn(directionList, pageable);
    }
}
