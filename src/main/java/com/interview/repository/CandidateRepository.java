package com.interview.repository;

import com.interview.model.entity.Candidate;
import com.interview.model.entity.Direction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CandidateRepository extends AbstractRepository<Candidate, String> {

    Page<Candidate> findAllByDirectionsIn(Collection<Direction> directions, Pageable pageable);
}
