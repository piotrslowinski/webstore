package com.piotrslowinski.sales.domain.repositories;

import java.util.Optional;

import com.piotrslowinski.sales.domain.Token;

public interface TokenRepository extends Repository<Token> {

    Optional<Token> findByValue(String tokenValue);
}
