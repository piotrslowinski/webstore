package com.piotrslowinski.sales.domain.repositories;

import com.piotrslowinski.sales.domain.Client;

import java.util.Optional;

public interface ClientRepository {

    Client get(Long id);

    void save(Client client);

    Optional<Client> getByLogin(String login);

}
