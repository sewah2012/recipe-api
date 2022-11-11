package com.recipe.recipeapi.services.RecipeService;

import com.recipe.recipeapi.dto.CreateRecipeDto;
import com.recipe.recipeapi.dto.FilterObj;
import com.recipe.recipeapi.entities.Recipe;
import com.recipe.recipeapi.entities.RecipeOrigin;
import com.recipe.recipeapi.entities.RecipeType;

import java.util.List;

public interface RecipeService {
    public Recipe createRecipe(CreateRecipeDto recipe);
    public Recipe updateRecipe(Recipe updatedRecipe);
    public String deleteRecipe(Long recipeId);
    public Recipe getRecipeById(Long recipeId);

    List<Recipe> getAllRecipe(RecipeType recipeType,
                              Boolean africanOrigin,
                              Boolean asianOrigin,
                              Boolean europeanOrigin,
                              Boolean northAmericanOrigin,
                              Boolean sourthAmericanOrigin,
                              Boolean australianOrigin,
                              Boolean antarticaOrigin);
}
