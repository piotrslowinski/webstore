package com.piotrslowinski.sales.domain.repositories;

import java.lang.reflect.ParameterizedType;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericJpaRepository<T> implements Repository<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    private Class<T> clazz;

    protected GenericJpaRepository() {
        this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void save(T t) {
        this.entityManager.persist(t);
    }

    public Optional<T> get(Long id) {
        T t = this.entityManager.find(this.clazz, id);
        if (t == null) {
            throw new NoSuchElementException();
        }
        return Optional.of(t);
    }
}
