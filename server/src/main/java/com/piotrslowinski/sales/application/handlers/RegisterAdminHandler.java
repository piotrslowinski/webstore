package com.piotrslowinski.sales.application.handlers;

import com.piotrslowinski.sales.domain.commands.Command;
import com.piotrslowinski.sales.domain.commands.RegisterAdminCommand;
import com.piotrslowinski.sales.domain.repositories.UserRepository;
import com.piotrslowinski.sales.domain.users.Role;
import com.piotrslowinski.sales.domain.users.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterAdminHandler implements Handler<RegisterAdminCommand> {

    private UserRepository userRepository;

    @Autowired
    public RegisterAdminHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void handle(RegisterAdminCommand cmd) {
        User user = new User(cmd.getEmail(), cmd.getPassword(), Role.ADMIN);
        this.userRepository.save(user);
    }

    @Override
    public Class<? extends Command> getSupportedCommandClass() {
        return RegisterAdminCommand.class;
    }
}
