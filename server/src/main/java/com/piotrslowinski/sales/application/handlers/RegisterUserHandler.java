package com.piotrslowinski.sales.application.handlers;

import com.piotrslowinski.sales.domain.commands.Command;
import com.piotrslowinski.sales.domain.commands.RegisterUserCommand;
import com.piotrslowinski.sales.domain.repositories.UserRepository;
import com.piotrslowinski.sales.domain.users.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterUserHandler implements Handler<RegisterUserCommand> {

    private UserRepository userRepository;

    @Autowired
    public RegisterUserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void handle(RegisterUserCommand cmd) {
        User user = new User(cmd.getEmail(), cmd.getRepeatedPassword());
        this.userRepository.save(user);
    }

    @Override
    public Class<? extends Command> getSupportedCommandClass() {
        return RegisterUserCommand.class;
    }
}
