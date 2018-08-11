package com.piotrslowinski.sales.infrastructure;

import com.piotrslowinski.sales.domain.repositories.GenericJpaRepository;
import com.piotrslowinski.sales.domain.repositories.UserRepository;
import com.piotrslowinski.sales.domain.users.User;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.Optional;

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


}
