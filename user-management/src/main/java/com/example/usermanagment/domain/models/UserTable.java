package com.example.usermanagment.domain.models;

import com.example.sharedkernel.domain.address.Address;
import com.example.sharedkernel.domain.base.AbstractEntity;
import com.example.sharedkernel.domain.base.DomainObjectId;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
public class UserTable extends AbstractEntity<UserId> {

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Address address;

    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<LogIn> logins;

    public UserTable(String fullName, String email, String username, String password, Address address, String phoneNumber) {
        super(DomainObjectId.randomId(UserId.class));
        this.fullName = fullName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.logins = new HashSet<>();
    }

    public UserTable() {
        super(DomainObjectId.randomId(UserId.class));
    }

    public void addLogIn(LogIn logIn) {
        this.logins.add(logIn);
    }

    public void removeLogIn(LogIn logIn) {
        this.logins.remove(logIn);
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public void updateUser(String fullName, String email, String username, String password, Address address, String phoneNumber) {
        this.fullName = fullName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserTable userTable = (UserTable) o;
        return Objects.equals(fullName, userTable.fullName) && Objects.equals(address, userTable.address) && Objects.equals(email, userTable.email) && Objects.equals(phoneNumber, userTable.phoneNumber) && Objects.equals(username, userTable.username) && Objects.equals(password, userTable.password) && Objects.equals(logins, userTable.logins) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fullName, address, email, phoneNumber, username, password, logins);
    }

}
