package com.piotrslowinski.sales.application;

import com.piotrslowinski.sales.application.dtos.ClientDto;

import java.util.List;

public interface ClientFinder {

    List<ClientDto> getAll();
}
