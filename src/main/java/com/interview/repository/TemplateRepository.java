package com.interview.repository;

import com.interview.model.entity.Template;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateRepository extends AbstractRepository<Template, String> {}
