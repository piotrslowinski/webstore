package com.piotrslowinski.sales.application;

import java.util.List;

import com.piotrslowinski.sales.application.dtos.ClientDto;

public interface ClientFinder {

    List<ClientDto> getAll();
}
