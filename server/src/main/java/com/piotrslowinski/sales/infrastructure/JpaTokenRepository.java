package com.piotrslowinski.sales.infrastructure;

import java.util.Optional;

import javax.persistence.NoResultException;

import com.piotrslowinski.sales.domain.Token;
import com.piotrslowinski.sales.domain.repositories.GenericJpaRepository;
import com.piotrslowinski.sales.domain.repositories.TokenRepository;

import org.springframework.stereotype.Repository;

@Repository
public class JpaTokenRepository extends GenericJpaRepository<Token> implements TokenRepository {

    @Override
    public Optional<Token> findByValue(String tokenValue) {
        try {
            Token token = (Token) entityManager.createQuery("FROM Token t WHERE t.value = :value").
                    setParameter("value", tokenValue).getSingleResult();
            return Optional.of(token);
        }
        catch (NoResultException ex) {
            return Optional.empty();
        }
    }
}
