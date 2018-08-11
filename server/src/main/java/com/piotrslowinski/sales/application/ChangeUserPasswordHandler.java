package com.piotrslowinski.sales.application;

import com.piotrslowinski.sales.domain.commands.ChangeUserPasswordCommand;
import com.piotrslowinski.sales.domain.commands.Command;
import com.piotrslowinski.sales.domain.repositories.UserRepository;
import com.piotrslowinski.sales.domain.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChangeUserPasswordHandler implements Handler<ChangeUserPasswordCommand> {

    private UserRepository userRepository;

    @Autowired
    public ChangeUserPasswordHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void handle(ChangeUserPasswordCommand cmd) {
        Optional<User> userOptional = userRepository.get(cmd.getUserId());
        User user = userOptional.get();
        user.setPassword(cmd.getRepeatedPassword());
        userRepository.save(user);
    }

    @Override
    public Class<? extends Command> getSupportedCommandClass() {
        return null;
    }
}
