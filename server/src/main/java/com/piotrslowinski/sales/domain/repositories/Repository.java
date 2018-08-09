package com.piotrslowinski.sales.domain.repositories;

import java.util.Optional;

public interface Repository<T> {

    void save(T t);

    Optional<T> get(Long id);
}
