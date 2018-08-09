package com.piotrslowinski.sales.ui;

import java.util.List;

import com.piotrslowinski.sales.application.ClientFinder;
import com.piotrslowinski.sales.application.CommandGateway;
import com.piotrslowinski.sales.application.dtos.ClientDto;
import com.piotrslowinski.sales.domain.commands.RegisterClientCommand;
import com.piotrslowinski.sales.domain.repositories.ClientRepository;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/client")
public class ClientController {

    private CommandGateway gateway;
    private ClientRepository clientRepository;
    private ClientFinder clientFinder;

    public ClientController(CommandGateway gateway, ClientRepository clientRepository, ClientFinder clientFinder) {
        this.gateway = gateway;
        this.clientRepository = clientRepository;
        this.clientFinder = clientFinder;
    }

    @PostMapping
    public void registerNewClient(@RequestBody RegisterClientCommand cmd) {
        this.gateway.execute(cmd);
    }

    @GetMapping
    public List<ClientDto> getAllClients() {
        return this.clientFinder.getAll();
    }

}
