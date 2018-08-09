package com.piotrslowinski.sales.infrastructure;

import com.piotrslowinski.sales.domain.Client;
import com.piotrslowinski.sales.domain.repositories.ClientRepository;
import com.piotrslowinski.sales.domain.repositories.GenericJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class JPAClientRepository extends GenericJpaRepository<Client> implements ClientRepository {
}
