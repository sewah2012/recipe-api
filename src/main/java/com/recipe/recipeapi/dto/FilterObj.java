package com.recipe.recipeapi.dto;

import com.recipe.recipeapi.entities.RecipeOrigin;

import java.util.List;

public record FilterObj(
        List<RecipeOrigin> recipeOrigins
) {
}
