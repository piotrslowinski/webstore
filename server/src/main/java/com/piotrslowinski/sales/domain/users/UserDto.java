package com.piotrslowinski.sales.domain.users;

import java.util.Set;

public class UserDto {

    private Long id;

    private String email;

    private Set<Role> roles;

    private boolean active;

    public UserDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.roles = user.getRoles();
        this.active = user.isActive();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
