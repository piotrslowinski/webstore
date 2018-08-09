package com.piotrslowinski.sales.infrastructure;

import com.piotrslowinski.sales.application.dtos.ClientDto;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class JPAClientFinder {

    private EntityManager entityManager;

    public JPAClientFinder(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<ClientDto> getAll() {
        List<ClientDto> results = entityManager.createQuery("SELECT NEW " +
        "com.piotrslowinski.sales.application.dtos.ClientDto(c.id, c.email, c.firstName, c.lastName," +
                " c.address, c.clientStatus)").getResultList();
        return results;
    }
}
