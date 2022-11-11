package com.recipe.recipeapi.services.RecipeService;

import com.recipe.recipeapi.dto.CreateRecipeDto;
import com.recipe.recipeapi.entities.Recipe;
import com.recipe.recipeapi.entities.RecipeOrigin;
import com.recipe.recipeapi.entities.RecipeType;
import com.recipe.recipeapi.exceptions.errors.NoSuchResourceException;
import com.recipe.recipeapi.repositories.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeServiceImp implements RecipeService {
    private final RecipeRepository recipeRepository;
    private final JdbcTemplate jdbcTemplate;


    @Override
    public Recipe createRecipe(CreateRecipeDto recipeRequest) {
       return recipeRepository.save(Recipe.builder()
                        .name(recipeRequest.getName())
                        .description(recipeRequest.getDescription())
                        .imageUrl(recipeRequest.getImageUrl())
                        .ingredients(recipeRequest.getIngredients())
                        .instruction(recipeRequest.getInstruction())
                        .recipeType(recipeRequest.getRecipeType())
                        .recipeOrigin(recipeRequest.getRecipeOrigin())
                .build());
    }

    @Override
    public Recipe updateRecipe(Recipe updatedRecipe) {
        var recipe = recipeRepository.findById(updatedRecipe.getId()).orElseThrow(()->new NoSuchResourceException("This recipe does not exist!"));
        recipe.getIngredients().clear(); //emptys the ingredients list
        recipe.setName(updatedRecipe.getName());
        recipe.getIngredients().addAll(updatedRecipe.getIngredients());
        recipe.setDescription(updatedRecipe.getDescription());
        recipe.setImageUrl(updatedRecipe.getImageUrl());
        recipe.setRecipeOrigin(updatedRecipe.getRecipeOrigin());
        recipe.setRecipeType(updatedRecipe.getRecipeType());
        recipe.setInstruction(updatedRecipe.getInstruction());

       return  recipeRepository.save(recipe);

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
    public List<Recipe> getAllRecipe(RecipeType recipeType,
                                     Boolean africanOrigin,
                                     Boolean asianOrigin,
                                     Boolean europeanOrigin,
                                     Boolean northAmericanOrigin,
                                     Boolean sourthAmericanOrigin,
                                     Boolean australianOrigin,
                                     Boolean antarticaOrigin) {
        List<RecipeOrigin> filters = new ArrayList<>();

        if(africanOrigin) filters.add(RecipeOrigin.AFRICAN);
        if(asianOrigin) filters.add(RecipeOrigin.ASIAN);
        if(europeanOrigin) filters.add(RecipeOrigin.EUROPEAN);
        if(northAmericanOrigin) filters.add(RecipeOrigin.NORTH_AMERICAN);
        if(sourthAmericanOrigin) filters.add(RecipeOrigin.SOUTH_AMERICAN);
        if(australianOrigin) filters.add(RecipeOrigin.AUSTRALIAN);
        if(antarticaOrigin) filters.add(RecipeOrigin.ANTARTICA);



        return recipeRepository.getRecipe(recipeType, filters);
    }
}
