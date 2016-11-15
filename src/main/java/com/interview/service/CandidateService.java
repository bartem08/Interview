package com.interview.service;

import com.interview.model.entity.Candidate;
import com.interview.model.entity.Direction;
import com.interview.repository.AbstractRepository;
import com.interview.repository.CandidateRepository;
import com.interview.repository.CandidateSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CandidateService extends AbstractService<Candidate, String> {

    private CandidateRepository candidateRepository;

    private CandidateSearchRepository candidateSearchRepository;

    @Autowired
    public CandidateService(MessageService messageService, CandidateRepository candidateRepository,
                            CandidateSearchRepository candidateSearchRepository) {
        super(messageService);
        this.candidateRepository = candidateRepository;
        this.candidateSearchRepository = candidateSearchRepository;
    }

    @Override
    protected AbstractRepository<Candidate, String> getRepository() {
        return candidateRepository;
    }

    public List<Candidate> findCandidatesByNameOrPhoneNumber(String searchWord, Integer offset) {

        if (searchWord == null || searchWord.isEmpty() || offset < 0) {
            return Collections.emptyList();
        }
        return candidateSearchRepository.findCandidatesBySearchWord(searchWord, offset);
    }
}
