package com.recipe.recipeapi.services.RecipeService;

import com.recipe.recipeapi.dto.CreateRecipeDto;
import com.recipe.recipeapi.entities.Recipe;

import java.util.List;

public interface RecipeService {
    public String createRecipe(CreateRecipeDto recipe);
    public String updateRecipe(Recipe updatedRecipe);
    public String deleteRecipe(Long recipeId);
    public Recipe getRecipeById(Long recipeId);
    public List<Recipe> getAllRecipe();
}
