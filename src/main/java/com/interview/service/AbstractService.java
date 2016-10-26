package com.interview.service;

import com.interview.model.IModel;
import com.interview.repository.AbstractRepository;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Optional.*;

import java.io.Serializable;
import java.util.Optional;

public abstract class AbstractService<E extends IModel, I extends Serializable> {

    protected abstract AbstractRepository<E, I> getRepository();

    @Transactional(readOnly = true)
    public Optional<E> get(I id) {

        E entity = getRepository().findOne(id);
        return ofNullable(entity);
    }

    public Optional<E> create(E entity) {
        if (entity.getId() != null) {
            return empty();
        }

        E saved = getRepository().save(entity);
        return ofNullable(saved);
    }
}
