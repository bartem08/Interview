package com.interview.repository;

import com.interview.model.AbstractModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractRepository<E extends AbstractModel> extends JpaRepository<E, String> {}
