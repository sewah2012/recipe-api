package com.recipe.recipeapi.controllers;

import com.recipe.recipeapi.dto.CreateRecipeDto;
import com.recipe.recipeapi.entities.Recipe;
import com.recipe.recipeapi.services.RecipeService.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    @PostMapping("/create")
    ResponseEntity<String> createRecipe(@RequestBody CreateRecipeDto request){
        return ResponseEntity.ok(recipeService.createRecipe(request));
    }

    @PutMapping("/update")
    ResponseEntity<String> updateRecipe(@RequestBody Recipe updatedRecipe){
        return ResponseEntity.ok(recipeService.updateRecipe(updatedRecipe));
    }

    @DeleteMapping("/delete/{recipeId}")
    ResponseEntity<String> deleteRecipe(@PathVariable("recipeId") Long recipeId){
        return ResponseEntity.ok(recipeService.deleteRecipe(recipeId));
    }

    @GetMapping("/getAll")
    ResponseEntity<List<Recipe>> getAllRecipe(){
        return ResponseEntity.ok(recipeService.getAllRecipe());
    }

    @GetMapping("/getRecipe/{recipeId}")
    ResponseEntity<Recipe> getRecipeById (@PathVariable("recipeId") Long recipeId){
        return ResponseEntity.ok(recipeService.getRecipeById(recipeId));
    }


}