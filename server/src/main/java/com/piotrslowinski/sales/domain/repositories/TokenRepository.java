package com.piotrslowinski.sales.domain.repositories;

import com.piotrslowinski.sales.domain.Token;

import java.util.Optional;

public interface TokenRepository extends Repository<Token> {

    Optional<Token> findByValue(String tokenValue);
}
