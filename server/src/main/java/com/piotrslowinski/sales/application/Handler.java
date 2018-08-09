package com.piotrslowinski.sales.application;

import com.piotrslowinski.sales.domain.commands.Command;

public interface Handler<C extends Command> {

    void handle(C command);

    Class<? extends Command> getSupportedCommandClass();

    default boolean canHandle(Command command) {
        return command.getClass().equals(getSupportedCommandClass());
    }
}
