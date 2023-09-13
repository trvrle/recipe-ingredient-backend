package com.trevor.recipe.controller;

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

    @PostMapping
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping(path = "{userId}")
    public User getUser(@PathVariable Integer userId) {
        return userService.getUser(userId);
    }
}
