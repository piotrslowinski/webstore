package com.piotrslowinski.sales.application.handlers;

import java.util.Optional;

import com.piotrslowinski.sales.domain.commands.ChangeUserPasswordCommand;
import com.piotrslowinski.sales.domain.commands.Command;
import com.piotrslowinski.sales.domain.repositories.UserRepository;
import com.piotrslowinski.sales.domain.users.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChangeUserPasswordHandler implements Handler<ChangeUserPasswordCommand> {

    private UserRepository userRepository;

    @Autowired
    public ChangeUserPasswordHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public void handle(ChangeUserPasswordCommand cmd) {
        Optional<User> userOptional = this.userRepository.get(cmd.getUserId());
        User user = userOptional.get();
        user.setPassword(cmd.getRepeatedPassword());
        this.userRepository.save(user);
    }

    @Override
    public Class<? extends Command> getSupportedCommandClass() {
        return ChangeUserPasswordCommand.class;
    }
}
