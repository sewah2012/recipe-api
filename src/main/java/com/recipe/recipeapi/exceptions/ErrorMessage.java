package com.recipe.recipeapi.exceptions;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    private String message;
    private int statusCode;
}
