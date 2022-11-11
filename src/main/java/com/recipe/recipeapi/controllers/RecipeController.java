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
    ResponseEntity<Recipe> createRecipe(@RequestBody CreateRecipeDto request){
        return ResponseEntity.ok(recipeService.createRecipe(request));
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
        @RequestParam(name = "recipeType", defaultValue = "VEGETARIAN", required = true) RecipeType recipeType,
        @RequestParam(name="african", required = false, defaultValue = "true") Boolean africanOrigin,
        @RequestParam(name="asian", required = false, defaultValue = "true") Boolean asianOrigin,
        @RequestParam(name="european", required = false, defaultValue = "true") Boolean europeanOrigin,
        @RequestParam(name="northAmerican", required = false, defaultValue = "true") Boolean northAmericanOrigin,
        @RequestParam(name="southAmerican", required = false, defaultValue = "true") Boolean sourthAmericanOrigin,
        @RequestParam(name="australian", required = false, defaultValue = "true") Boolean australianOrigin,
        @RequestParam(name="antartica", required = false, defaultValue = "true") Boolean antarticaOrigin
    ){
        return ResponseEntity.ok(recipeService.getAllRecipe(
                recipeType,
                africanOrigin,
                asianOrigin,
                europeanOrigin,
                northAmericanOrigin,
                sourthAmericanOrigin,
                australianOrigin,
                antarticaOrigin
        ));
    }

    @GetMapping("/getRecipe/{recipeId}")
    ResponseEntity<Recipe> getRecipeById (@PathVariable("recipeId") Long recipeId){
        return ResponseEntity.ok(recipeService.getRecipeById(recipeId));
    }


}
