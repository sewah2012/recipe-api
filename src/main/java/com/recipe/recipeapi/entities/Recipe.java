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
public class Recipe {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Builder.Default
    @JoinColumn(name = "ingredient_id", referencedColumnName = "id")
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<Ingredient> ingredients = new ArrayList<>();
    private String imageUrl;
    private String description;
}
