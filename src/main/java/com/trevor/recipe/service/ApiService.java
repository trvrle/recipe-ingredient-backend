package com.trevor.recipe.service;

import com.trevor.recipe.model.constants.ApiConstants;
import com.trevor.recipe.model.ingredient.Ingredient;
import com.trevor.recipe.model.recipe.Recipe;
import com.trevor.recipe.model.response.RecipeResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class ApiService {

    public List<Recipe> getRandomRecipes() {
        String uri = UriComponentsBuilder
                .fromHttpUrl(ApiConstants.BASE_URL)
                .path("/recipes/random")
                .queryParam("apiKey", ApiConstants.API_KEY)
                .queryParam("number", 10)
                .toUriString();
        RestTemplate restTemplate = new RestTemplate();
        RecipeResponse result = restTemplate.getForObject(uri, RecipeResponse.class);
        if (result == null)
            return List.of();
        return result.getRecipes();
    }

    public List<Recipe> getRecipesByIngredients(String ingredients) {
        String uri = UriComponentsBuilder
                .fromHttpUrl(ApiConstants.BASE_URL)
                .path("/recipes/findByIngredients")
                .queryParam("apiKey", ApiConstants.API_KEY)
                .queryParam("ingredients", ingredients)
                .toUriString();
        RestTemplate restTemplate = new RestTemplate();
        Recipe[] result = restTemplate.getForObject(uri, Recipe[].class);

        if (result == null)
            return List.of();
        return List.of(result);
    }

    public List<Ingredient> getAutocompleteIngredients(String query) {
        String uri = UriComponentsBuilder
                .fromHttpUrl(ApiConstants.BASE_URL)
                .path("/food/ingredients/autocomplete")
                .queryParam("apiKey", ApiConstants.API_KEY)
                .queryParam("query", query)
                .queryParam("number", 5)
                .toUriString();
        RestTemplate restTemplate = new RestTemplate();
        Ingredient[] result = restTemplate.getForObject(uri, Ingredient[].class);

        if (result == null)
            return List.of();
        
        List<Ingredient> ingredients = List.of(result);
        ingredients.forEach(i -> {
            String name = i.getName();
            i.setName(name.substring(0, 1).toUpperCase() + name.substring(1));
            i.setImage("https://spoonacular.com/cdn/ingredients_100x100/" + i.getImage());
        });

        return List.of(result);
    }
}
