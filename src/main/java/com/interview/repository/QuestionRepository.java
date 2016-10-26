package com.interview.repository;

import com.interview.model.entity.Question;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends AbstractRepository<Question, String> {}
