package com.piotrslowinski.sales.infrastructure;

import java.util.Optional;

import javax.persistence.NoResultException;

import com.piotrslowinski.sales.domain.repositories.GenericJpaRepository;
import com.piotrslowinski.sales.domain.repositories.UserRepository;
import com.piotrslowinski.sales.domain.users.User;

import org.springframework.stereotype.Repository;

@Repository
public class JpaUserRepository extends GenericJpaRepository<User> implements UserRepository {


    public Optional<User> findByLogin(String login) {
        try {
            User user = (User) entityManager.createQuery("FROM User u WHERE u.email = :email").
                    setParameter("email", login).getSingleResult();
            return Optional.of(user);
        }
        catch (NoResultException ex) {
            return Optional.empty();
        }
    }

    @Override
    public boolean userExist(String email) {
        return findByLogin(email).isPresent();
    }


}
