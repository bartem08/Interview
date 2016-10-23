package com.interview.service;

import com.interview.model.AbstractModel;
import com.interview.repository.AbstractRepository;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Optional.*;

import java.util.Optional;

public abstract class AbstractService<E extends AbstractModel> {

    protected abstract AbstractRepository<E> getRepository();

    @Transactional(readOnly = true)
    public Optional<E> get(String id) {

        E entity = getRepository().findOne(id);
        return ofNullable(entity);
    }

    @Transactional
    public Optional<E> create(E entity) {
        if (entity.getId() != null) {
            return empty();
        }

        E saved = getRepository().save(entity);
        return ofNullable(saved);
    }
}
