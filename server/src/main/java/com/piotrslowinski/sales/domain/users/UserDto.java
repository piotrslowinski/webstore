package com.piotrslowinski.sales.domain.users;

import java.util.Set;

public class UserDto {

    private Long id;

    private String email;

    private Set<Role> roles;

    public UserDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.roles = user.getRoles();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
