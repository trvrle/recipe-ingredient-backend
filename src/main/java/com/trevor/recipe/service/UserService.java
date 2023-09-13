package com.trevor.recipe.service;

import com.trevor.recipe.model.user.User;
import com.trevor.recipe.model.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.get();
    }

}
