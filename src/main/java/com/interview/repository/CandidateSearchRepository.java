package com.interview.repository;

import com.interview.model.entity.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@Repository
public class CandidateSearchRepository {

    public static final int MAX_RESULTS = 5;

    private EntityManagerFactory entityManagerFactory;

    private CriteriaBuilder criteriaBuilder;

    private CriteriaQuery<Candidate> query;

    private Root<Candidate> candidate;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    public CandidateSearchRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
        criteriaBuilder = entityManagerFactory.getCriteriaBuilder();
        query = criteriaBuilder.createQuery(Candidate.class);
        candidate = query.from(Candidate.class);
    }

    public List<Candidate> findCandidates(String searchWord, Integer offset) {

        if (offset < 0 || searchWord.isEmpty()) {
            return Collections.emptyList();
        }

        return entityManagerFactory.createEntityManager()
                .createQuery(createCriteriaQuery(searchWord.split(" ")))
                .setFirstResult(offset)
                .setMaxResults(MAX_RESULTS)
                .getResultList();
    }

    CriteriaQuery<Candidate> createCriteriaQuery(String ... searchWords) {

        Predicate[] nameLikeSearchWords = Arrays.stream(searchWords)
                .map(this::nameStartsWith)
                .toArray(Predicate[]::new);

        Predicate searchQuery = criteriaBuilder.and(nameLikeSearchWords);

        return query.where(searchQuery);
    }

    private Predicate nameStartsWith(String searchWord) {

        Predicate[] nameLikeSearchWord = Stream.of("firstName", "lastName")
                .map(property -> criteriaBuilder.like(candidate.get(property), searchWord + "%"))
                .toArray(Predicate[]::new);

        return criteriaBuilder.or(nameLikeSearchWord);
    }
}
