package com.piotrslowinski.sales.application.dtos;

import com.piotrslowinski.sales.domain.Address;
import com.piotrslowinski.sales.domain.Client;
import com.piotrslowinski.sales.domain.ClientStatus;

public class ClientDto {

    private Long id;

    private String email;

    private String firstName;

    private String lastName;

    private Address address;

    private ClientStatus clientStatus;

    public ClientDto(Client client) {
        this.id = client.getId();
        this.email = client.getEmail();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.address = client.getAddress();
        this.clientStatus = client.getClientStatus();
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

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ClientStatus getClientStatus() {
        return this.clientStatus;
    }

    public void setClientStatus(ClientStatus clientStatus) {
        this.clientStatus = clientStatus;
    }
}
