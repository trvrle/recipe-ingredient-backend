package com.trevor.recipe.model.user;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserKey implements Serializable {

    private Integer id;

    private String username;

}
