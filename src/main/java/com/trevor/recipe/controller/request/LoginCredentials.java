package com.trevor.recipe.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginCredentials {
    private String username;
    private String password;
}
