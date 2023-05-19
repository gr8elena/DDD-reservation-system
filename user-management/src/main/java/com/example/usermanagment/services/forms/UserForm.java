package com.example.usermanagment.services.forms;

import com.example.sharedkernel.domain.address.Address;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class UserForm {

    @NotNull
    public String full_name;
    @NotNull
    public String email;
    @NotNull
    public String password;
    @NotNull
    public String username;
    @NotNull
    public Address address;
    @NotNull
    public String phoneNumber;
}
