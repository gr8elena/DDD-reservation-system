package com.example.usermanagment.services.impl;

import com.example.usermanagment.domain.models.UserId;
import com.example.usermanagment.domain.models.UserTable;
import com.example.usermanagment.domain.repository.UserRepository;
import com.example.usermanagment.services.UserService;
import com.example.usermanagment.services.forms.UserForm;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.Validator;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Validator validator;

    @Override
    public UserTable findById(UserId userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }
    @Override
    public UserId save(@NonNull UserForm user) {
        var violations = validator.validate(user);
        if (!violations.isEmpty()) {
            throw new IllegalArgumentException("Invalid user data");
        }

        var userTable = new UserTable(user.full_name, user.email, user.username, user.password,  user.address, user.phoneNumber);

        return userRepository.saveAndFlush(userTable).getId();
    }

    @Override
    public UserTable updateUser(@NonNull UserId userId,@NonNull UserForm userForm) {
        var user = findById(userId);

        user.updateUser(user.getFullName(), user.getEmail(), user.getUsername(), user.getPassword(), user.getAddress(), user.getPhoneNumber());

        return  userRepository.saveAndFlush(user);
    }

    @Override
    public void deleteUser(UserId userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<UserTable> listAll() {
       return userRepository.findAll();
    }
}
