package com.piotrslowinski.sales.domain.commands;

import java.util.Set;

import com.piotrslowinski.sales.domain.users.Role;

public class ChangeUserProfileCommand implements Command {

    private Long userId;

    private Set<Role> roles;

    private boolean active;

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Set<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
