package com.interview.repository;

import com.interview.model.TQuestionId;
import com.interview.model.entity.TemplateQuestion;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateQuestionRepository extends AbstractRepository<TemplateQuestion, TQuestionId> {}
