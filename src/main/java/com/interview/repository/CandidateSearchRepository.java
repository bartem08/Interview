package com.interview.repository;

import com.interview.model.entity.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.*;
import java.util.stream.Stream;

@Repository
public class CandidateSearchRepository extends CriteriaBase<Candidate> {

    private static final int MAX_RESULTS = 5;

    private static final String PHONE_NUMBER = "^[0][1-9][0-9]";

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    public CandidateSearchRepository(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory, Candidate.class);
    }

    public List<Candidate> findCandidatesBySearchWord(String searchWord, Integer offset) {

        if (searchWord == null || searchWord.isEmpty() || offset < 0) {
            return Collections.emptyList();
        }

        return entityManagerFactory.createEntityManager()
                .createQuery(byPhoneCriteriaQuery(searchWord))
                .setFirstResult(offset)
                .setMaxResults(MAX_RESULTS)
                .getResultList();
    }

    private CriteriaQuery<Candidate> byPhoneCriteriaQuery(String searchWord) {

        if (!searchWord.matches(PHONE_NUMBER)) {
            return byNameCriteriaQuery(searchWord.split(" "));
        }

        Predicate phoneNumberLikeSearchWord =
                criteriaBuilder.like(eRoot.get("phone"), searchWord + "%");

        return query.where(phoneNumberLikeSearchWord);
    }

    private CriteriaQuery<Candidate> byNameCriteriaQuery(String ... searchWords) {

        Predicate[] nameLikeSearchWords = Arrays.stream(searchWords)
                .map(this::nameStartsWith)
                .toArray(Predicate[]::new);

        Predicate searchQuery = criteriaBuilder.and(nameLikeSearchWords);

        return query.where(searchQuery);
    }

    private Predicate nameStartsWith(String searchWord) {

        Predicate[] nameLikeSearchWord = Stream.of("firstName", "lastName")
                .map(property -> criteriaBuilder.like(eRoot.get(property), searchWord + "%"))
                .toArray(Predicate[]::new);

        return criteriaBuilder.or(nameLikeSearchWord);
    }
}
