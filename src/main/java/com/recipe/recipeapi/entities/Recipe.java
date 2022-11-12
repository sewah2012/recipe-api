package com.recipe.recipeapi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recipe", schema = "public")
public class Recipe {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition="TEXT")
    private String description;
    @Builder.Default
    @JoinColumn(name = "ingredient_id", referencedColumnName = "id")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ingredient> ingredients = new ArrayList<>();
    private String imageUrl;
    @Column(columnDefinition="TEXT")
    private String instruction;
    private RecipeOrigin recipeOrigin;
    private RecipeType recipeType;
}
