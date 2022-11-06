package com.recipe.recipeapi.repositories;

import com.recipe.recipeapi.entities.Recipe;
import com.recipe.recipeapi.entities.RecipeOrigin;
import com.recipe.recipeapi.entities.RecipeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
//    @Query("SELECT r FROM Recipe r where r.recipeType =:recipeType AND r.recipeOrigin IN :recipeOriginList")
//    List<Recipe> getRecipe(@Param("recipeType") RecipeType recipeType, @Param("recipeOriginList") List<RecipeOrigin> recipeOriginList);
//}
    @Query("SELECT r FROM Recipe r where r.recipeType =:recipeType")
    List<Recipe> getRecipe(@Param("recipeType") RecipeType recipeType);

}
