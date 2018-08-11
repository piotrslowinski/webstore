package com.piotrslowinski.sales.infrastructure;

import java.util.List;

import javax.persistence.EntityManager;

import com.piotrslowinski.sales.application.ClientFinder;
import com.piotrslowinski.sales.application.dtos.ClientDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JPAClientFinder implements ClientFinder {

    private EntityManager entityManager;

    @Autowired
    public JPAClientFinder(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<ClientDto> getAll() {
        List<ClientDto> results = this.entityManager.createQuery("SELECT NEW " +
        "com.piotrslowinski.sales.application.dtos.ClientDto(c.id, c.email, c.firstName, c.lastName," +
                " c.address, c.clientStatus)").getResultList();
        return results;
    }
}
