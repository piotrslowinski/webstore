package com.piotrslowinski.sales.ui;

import com.piotrslowinski.sales.application.CommandGateway;
import com.piotrslowinski.sales.domain.commands.ChangeUserPasswordCommand;
import com.piotrslowinski.sales.domain.commands.RegisterUserCommand;
import com.piotrslowinski.sales.domain.repositories.UserRepository;
import com.piotrslowinski.sales.domain.users.UserDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;
    private CommandGateway gateway;

    public UserController(UserRepository userRepository, CommandGateway gateway) {
        this.userRepository = userRepository;
        this.gateway = gateway;
    }

//    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secured/{userId}")
    public UserDto getUserById(@PathVariable Long userId) {
        return new UserDto(userRepository.get(userId).get());
    }

    @PostMapping
    public void registerStandardUser(@RequestBody RegisterUserCommand cmd) {
        gateway.execute(cmd);
    }

    @PutMapping("/{userId}")
    public void changeUserPassword(@PathVariable Long userId, @RequestBody ChangeUserPasswordCommand cmd) {
        cmd.setUserId(userId);
        gateway.execute(cmd);
    }

}
