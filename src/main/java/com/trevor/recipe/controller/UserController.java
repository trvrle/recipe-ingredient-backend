package com.trevor.recipe.controller;

import com.trevor.recipe.model.request.LoginCredentials;
import com.trevor.recipe.model.user.User;
import com.trevor.recipe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping(path = "login")
    public User login(@RequestBody LoginCredentials loginCredentials) {
        // TODO: Implement JWT authentication
        return userService.login(loginCredentials.getUsername(), loginCredentials.getPassword());
    }
}
