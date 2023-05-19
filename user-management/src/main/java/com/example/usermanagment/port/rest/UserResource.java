package com.example.usermanagment.port.rest;

import com.example.usermanagment.domain.models.UserId;
import com.example.usermanagment.domain.models.UserTable;
import com.example.usermanagment.services.UserService;
import com.example.usermanagment.services.forms.UserForm;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserResource {

    private final UserService userService;

    @GetMapping
    public List<UserTable> listAll() {
        return userService.listAll();
    }

    @GetMapping("/{id}")
    public UserTable findById(@PathVariable("id") UserId id) {
        return userService.findById(id);
    }

    @PostMapping("/create")
    public void createUser(@RequestBody UserForm user, HttpServletResponse response) throws IOException, IOException {
        userService.save(user);
        response.sendRedirect("/api/users");
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") UserId userId, @RequestBody UserForm user, HttpServletResponse response) throws IOException {
        userService.updateUser(userId, user);
        response.sendRedirect("/api/users");
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable("id") UserId userId, HttpServletResponse response) throws IOException {
        userService.deleteUser(userId);
        response.sendRedirect("/api/users");
    }
}
