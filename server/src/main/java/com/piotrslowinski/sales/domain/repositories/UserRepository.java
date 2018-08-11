package com.piotrslowinski.sales.domain.repositories;

import com.piotrslowinski.sales.domain.users.User;

import java.util.Optional;

public interface UserRepository extends Repository<User> {

    Optional<User> findByLogin(String login);

}
