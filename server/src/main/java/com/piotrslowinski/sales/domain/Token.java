package com.piotrslowinski.sales.domain;

import com.piotrslowinski.sales.domain.users.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String value;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    private Boolean active;

    @ManyToOne
    private User user;

    public Token() {
    }

    public Token(User user) {
        this.value = UUID.randomUUID().toString();
        this.expiryDate = LocalDate.now().plusDays(30);
        this.active = true;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
