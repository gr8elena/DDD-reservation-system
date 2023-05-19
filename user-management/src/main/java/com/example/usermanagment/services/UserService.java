package com.example.usermanagment.services;

import com.example.usermanagment.domain.models.UserId;
import com.example.usermanagment.domain.models.UserTable;
import com.example.usermanagment.services.forms.UserForm;

import java.util.List;

public interface UserService {
    UserId save(UserForm user);

    UserTable findById(UserId userId);

    UserTable updateUser(UserId userId, UserForm userForm);

    void deleteUser(UserId userId);

    List<UserTable> listAll();
}
