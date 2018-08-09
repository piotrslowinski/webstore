package com.piotrslowinski.sales.domain.commands;

import com.piotrslowinski.sales.domain.Address;
import com.piotrslowinski.sales.domain.ClientStatus;

public class RegisterClientCommand implements Command {

    private String email;

    private String firstName;

    private String lastName;

    private Address address;

    private ClientStatus clientStatus;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ClientStatus getClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(ClientStatus clientStatus) {
        this.clientStatus = clientStatus;
    }
}
