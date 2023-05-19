package com.example.reservationsmanagment.domain.valueobjects;

import com.example.sharedkernel.domain.address.Address;
import com.example.sharedkernel.domain.base.ValueObject;

public class UserTable implements ValueObject {

    private final UserId userId;

    private final String fullName;

    private final String email;

    private final String username;

    private final String password;

    private final Address address;

    private final String phoneNumber;

    public UserTable(UserId userId, String fullName, String email, String username, String password, Address address, String phoneNumber) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
