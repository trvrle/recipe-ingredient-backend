package com.trevor.recipe.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.trevor.recipe.model.recipe.Recipe;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecipeResponse {
    private List<Recipe> recipes;
}
