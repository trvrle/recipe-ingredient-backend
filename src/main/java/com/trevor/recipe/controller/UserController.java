package com.trevor.recipe.controller;

import com.trevor.recipe.model.user.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
public class UserController {
    
    @GetMapping
    public User getUser() {
        User user = new User(1, "Trevor", "Le", "trevor.le", "password");

        return user;
    }
}
