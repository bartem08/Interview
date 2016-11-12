package com.interview.service;

import com.interview.exception.NotFoundException;
import com.interview.model.IModel;
import com.interview.repository.AbstractRepository;

import static java.util.Optional.*;

import java.io.Serializable;
import java.util.Optional;

public abstract class AbstractService<E extends IModel, I extends Serializable> {

    protected MessageService messageService;

    public AbstractService(MessageService messageService) {
        this.messageService = messageService;
    }

    protected abstract AbstractRepository<E, I> getRepository();

    public Optional<E> get(I id) {

        E entity = getRepository().findOne(id);
        return ofNullable(entity);
    }

    public E getNotNull(I id, String label) {

        return get(id).orElseThrow(() ->
                new NotFoundException(messageService.getMessage("not.found", label, id)));
    }

    public Optional<E> create(E entity) {
        if (entity.getId() != null) {
            return empty();
        }
        return save(entity);
    }

    public Optional<E> update(E entity) {
        if (entity.getId() == null) {
            return empty();
        }
        return save(entity);
    }

    public boolean deleteById(I id) {
        if (!getRepository().exists(id)) {
            return false;
        }

        getRepository().delete(id);
        return true;
    }

    private Optional<E> save(E entity) {

        E saved = getRepository().save(entity);
        return ofNullable(saved);
    }
}
