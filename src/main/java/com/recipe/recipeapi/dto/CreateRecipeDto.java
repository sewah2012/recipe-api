package com.recipe.recipeapi.dto;

import com.recipe.recipeapi.entities.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateRecipeDto {
    private String name;
    @Builder.Default
    private List<Ingredient> ingredients = new ArrayList<>();
    private String imageUrl;
    private String description;
}
