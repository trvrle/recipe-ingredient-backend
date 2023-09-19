package com.trevor.recipe.controller;

import com.trevor.recipe.model.ingredient.Ingredient;
import com.trevor.recipe.model.recipe.Recipe;
import com.trevor.recipe.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/recipe")
public class RecipeController {

    private final ApiService apiService;

    @Autowired
    public RecipeController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping(path = "random")
    public List<Recipe> getRandomRecipes() {
        return apiService.getRandomRecipes();
    }

    @GetMapping
    public List<Recipe> getRecipesByIngredients(@RequestParam String ingredients) {
        return apiService.getRecipesByIngredients(ingredients);
    }

    @GetMapping(path = "ingredient")
    public List<Ingredient> getAutocompleteIngredients(@RequestParam String query) {
        return apiService.getAutocompleteIngredients(query);
    }
}
