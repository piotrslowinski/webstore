package com.piotrslowinski.sales.infrastructure;

import com.piotrslowinski.sales.application.dtos.ClientDto;
import com.piotrslowinski.sales.domain.Client;
import com.piotrslowinski.sales.domain.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class JPAClientRepository implements ClientRepository {


    private EntityManager entityManager;

    @Autowired
    public JPAClientRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Client get(Long id) {
        return null;
    }

    @Override
    public void save(Client client) {

    }

    @Override
    public Optional<Client> getByLogin(String login) {
        return Optional.empty();
    }

}
