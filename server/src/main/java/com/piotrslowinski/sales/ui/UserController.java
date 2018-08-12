package com.piotrslowinski.sales.ui;

import com.piotrslowinski.sales.application.CommandGateway;
import com.piotrslowinski.sales.application.UserFinder;
import com.piotrslowinski.sales.domain.commands.ChangeUserPasswordCommand;
import com.piotrslowinski.sales.domain.commands.ChangeUserProfileCommand;
import com.piotrslowinski.sales.domain.commands.RegisterAdminCommand;
import com.piotrslowinski.sales.domain.commands.RegisterUserCommand;
import com.piotrslowinski.sales.domain.repositories.UserRepository;
import com.piotrslowinski.sales.domain.users.UserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;
    private CommandGateway gateway;
    private UserFinder userFinder;

    @Autowired
    public UserController(UserRepository userRepository, CommandGateway gateway, UserFinder userFinder) {
        this.userRepository = userRepository;
        this.gateway = gateway;
        this.userFinder = userFinder;
    }


    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable Long userId) {
        return this.userFinder.getUserDetails(userId);
    }

    @PostMapping
    public void registerStandardUser(@RequestBody RegisterUserCommand cmd) {
        this.gateway.execute(cmd);
    }

    @PutMapping("/{userId}")
    public void changeUserPassword(@PathVariable Long userId, @RequestBody ChangeUserPasswordCommand cmd) {
        cmd.setUserId(userId);
        this.gateway.execute(cmd);
    }

    @PostMapping("/admin")
    public void registerNewAdmin(@RequestBody RegisterAdminCommand cmd) {
        this.gateway.execute(cmd);
    }

    @PutMapping("/edit/{userId}")
    public UserDto changeUserProfile(@PathVariable Long userId, @RequestBody ChangeUserProfileCommand cmd) {
        cmd.setUserId(userId);
        this.gateway.execute(cmd);
        return this.userFinder.getUserDetails(userId);
    }

}
