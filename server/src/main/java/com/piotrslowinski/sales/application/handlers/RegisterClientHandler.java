package com.piotrslowinski.sales.application.handlers;

import com.piotrslowinski.sales.domain.Client;
import com.piotrslowinski.sales.domain.StandardClient;
import com.piotrslowinski.sales.domain.commands.Command;
import com.piotrslowinski.sales.domain.commands.RegisterClientCommand;
import com.piotrslowinski.sales.domain.repositories.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterClientHandler implements Handler<RegisterClientCommand> {

    private ClientRepository clientRepository;

    @Autowired
    public RegisterClientHandler(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    @Override
    public void handle(RegisterClientCommand cmd) {
        Client client = new StandardClient(cmd.getEmail(),
                cmd.getFirstName(),
                cmd.getLastName(),
                cmd.getAddress(),
                cmd.getClientStatus()
        );
        this.clientRepository.save(client);
    }

    @Override
    public Class<? extends Command> getSupportedCommandClass() {
        return RegisterClientCommand.class;
    }
}
