package com.recipe.recipeapi.controllers;

import com.recipe.recipeapi.dto.CreateRecipeDto;
import com.recipe.recipeapi.dto.FilterObj;
import com.recipe.recipeapi.entities.Recipe;
import com.recipe.recipeapi.entities.RecipeOrigin;
import com.recipe.recipeapi.entities.RecipeType;
import com.recipe.recipeapi.services.RecipeService.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recipe")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RecipeController {
    private final RecipeService recipeService;

    @PostMapping("/create")
    Recipe createRecipe(@RequestBody CreateRecipeDto request){
       Recipe createdRecipe =  recipeService.createRecipe(request);
       return createdRecipe;
    }

    @PutMapping("/update")
    ResponseEntity<Recipe> updateRecipe(@RequestBody Recipe updatedRecipe){
        return ResponseEntity.ok(recipeService.updateRecipe(updatedRecipe));
    }

    @DeleteMapping("/delete/{recipeId}")
    ResponseEntity<String> deleteRecipe(@PathVariable("recipeId") Long recipeId){
        return ResponseEntity.ok(recipeService.deleteRecipe(recipeId));
    }

    @GetMapping("/getAll")
    ResponseEntity<List<Recipe>> getAllRecipe(
        @RequestParam(name = "recipeType", defaultValue = "VEGETARIAN") RecipeType recipeType
    ){
        return ResponseEntity.ok(recipeService.getAllRecipe(recipeType));
    }

    @GetMapping("/getRecipe/{recipeId}")
    ResponseEntity<Recipe> getRecipeById (@PathVariable("recipeId") Long recipeId){
        return ResponseEntity.ok(recipeService.getRecipeById(recipeId));
    }


}
