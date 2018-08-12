package com.piotrslowinski.sales.domain.repositories;

import java.util.Optional;

import com.piotrslowinski.sales.domain.users.User;

public interface UserRepository extends Repository<User> {

    Optional<User> findByLogin(String login);
    boolean userExist(String email);

}
