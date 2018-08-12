package com.piotrslowinski.sales.application.handlers;

import com.piotrslowinski.sales.domain.commands.ChangeUserProfileCommand;
import com.piotrslowinski.sales.domain.commands.Command;
import com.piotrslowinski.sales.domain.repositories.UserRepository;
import com.piotrslowinski.sales.domain.users.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChangeUserProfileHandler implements Handler<ChangeUserProfileCommand> {

    private UserRepository userRepository;

    @Autowired
    public ChangeUserProfileHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public void handle(ChangeUserProfileCommand cmd) {
        User user = this.userRepository.get(cmd.getUserId()).get();
        user.setActive(cmd.isActive());
        user.setRoles(cmd.getRoles());
    }

    @Override
    public Class<? extends Command> getSupportedCommandClass() {
        return ChangeUserProfileCommand.class;
    }
}
