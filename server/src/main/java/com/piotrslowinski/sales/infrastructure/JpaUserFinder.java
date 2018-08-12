package com.piotrslowinski.sales.infrastructure;

import java.util.NoSuchElementException;

import javax.persistence.EntityManager;

import com.piotrslowinski.sales.application.UserFinder;
import com.piotrslowinski.sales.domain.users.User;
import com.piotrslowinski.sales.domain.users.UserDto;

import org.springframework.beans.factory.annotation.Autowired;

public class JpaUserFinder implements UserFinder {

    private EntityManager entityManager;

    @Autowired
    public JpaUserFinder(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public UserDto getUserDetails(Long userId) {
        User user = this.entityManager.find(User.class, userId);
        if (user == null) {
            throw new NoSuchElementException("No such user in repo");
        }
        return new UserDto(user);
    }
}
