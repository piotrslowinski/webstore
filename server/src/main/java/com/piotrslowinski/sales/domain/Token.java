package com.piotrslowinski.sales.domain;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.*;

import com.piotrslowinski.sales.domain.users.User;

public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String value;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    private boolean active;

    @ManyToOne
    private User user;

    public Token() {
    }

    public Token(User user) {
        this.value = UUID.randomUUID().toString();
        this.expiryDate = LocalDate.now().plusDays(1);
        this.active = true;
        this.user = user;
    }

    public boolean isValid() {
        return this.active && !isExpired();
    }

    public boolean isExpired() {
        return this.expiryDate.isBefore(LocalDate.now());
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LocalDate getExpiryDate() {
        return this.expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
