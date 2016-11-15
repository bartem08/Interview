package com.interview.repository;

import com.interview.model.IModel;
import lombok.NoArgsConstructor;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.*;

import static lombok.AccessLevel.PROTECTED;

@NoArgsConstructor(access = PROTECTED)
public abstract class CriteriaBase<E extends IModel> {

    protected Root<E> eRoot;

    protected CriteriaQuery<E> query;

    protected CriteriaBuilder criteriaBuilder;
    
    protected EntityManagerFactory entityManagerFactory;

    protected CriteriaBase(EntityManagerFactory entityManagerFactory, Class<E> clazz) {
        this.entityManagerFactory = entityManagerFactory;
        criteriaBuilder = entityManagerFactory.getCriteriaBuilder();
        query = criteriaBuilder.createQuery(clazz);
        eRoot = query.from(clazz);
    }
}
