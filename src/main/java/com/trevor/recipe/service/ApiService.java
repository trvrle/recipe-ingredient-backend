package com.trevor.recipe.service;

import com.trevor.recipe.model.recipe.Recipe;
import com.trevor.recipe.model.response.RecipeResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiService {

    public List<Recipe> getRandomRecipes() {
        String uri = "https://api.spoonacular.com/recipes/random?apiKey=e08d347420b548169eb033e623bdfb88&number=10";
        RestTemplate restTemplate = new RestTemplate();
        RecipeResponse result = restTemplate.getForObject(uri, RecipeResponse.class);
        if (result == null)
            return List.of();
        return result.getRecipes();
    }
}
