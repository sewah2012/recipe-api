package com.recipe.recipeapi.services.RecipeService;

import com.recipe.recipeapi.dto.CreateRecipeDto;
import com.recipe.recipeapi.entities.Recipe;
import com.recipe.recipeapi.exceptions.errors.NoSuchResourceException;
import com.recipe.recipeapi.repositories.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeServiceImp implements RecipeService {
    private final RecipeRepository recipeRepository;


    @Override
    public String createRecipe(CreateRecipeDto recipeRequest) {
        recipeRepository.save(Recipe.builder()
                        .name(recipeRequest.getName())
                        .description(recipeRequest.getDescription())
                        .imageUrl(recipeRequest.getImageUrl())
                        .ingredients(recipeRequest.getIngredients())
                .build());
        return "Recipe successfully created!";
    }

    @Override
    public String updateRecipe(Recipe updatedRecipe) {
        var recipe = recipeRepository.findById(updatedRecipe.getId()).orElseThrow(()->new NoSuchResourceException("This recipe does not exist!"));
        recipe.setName(updatedRecipe.getName());
        recipe.getIngredients().addAll(updatedRecipe.getIngredients());
        recipe.setDescription(updatedRecipe.getDescription());
        recipe.setImageUrl(updatedRecipe.getImageUrl());

        recipeRepository.save(recipe);
        return "recipe successfully updated";

    }

    @Override
    public String deleteRecipe(Long recipeId) {
       var recipe = recipeRepository.findById(recipeId).orElseThrow(()->new NoSuchResourceException("This recipe does not exist!"));
       recipeRepository.deleteById(recipe.getId());
       return "recipe successfully deleted";
    }

    @Override
    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id).orElseThrow(()->new NoSuchResourceException("This recipe"));
    }

    @Override
    public List<Recipe> getAllRecipe() {
        return recipeRepository.findAll();
    }
}
