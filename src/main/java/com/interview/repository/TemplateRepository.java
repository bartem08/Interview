package com.interview.repository;

import com.interview.model.entity.Template;
import com.interview.model.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemplateRepository extends AbstractRepository<Template, String> {

    List<Template> findByUser(User user);
}
