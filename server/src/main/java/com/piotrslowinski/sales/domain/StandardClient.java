package com.piotrslowinski.sales.domain;

public class StandardClient extends Client {

    public StandardClient(String email, String firstName, String lastName,
                          Address address, ClientStatus clientStatus) {
        super(email, firstName, lastName, address, clientStatus);
    }
}
