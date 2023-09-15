package com.trevor.recipe.service;

import com.trevor.recipe.model.constants.ApiConstants;
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
}
