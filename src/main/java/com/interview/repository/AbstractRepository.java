package com.interview.repository;

import com.interview.model.IModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface AbstractRepository<E extends IModel, I extends Serializable> extends JpaRepository<E, I> {}
