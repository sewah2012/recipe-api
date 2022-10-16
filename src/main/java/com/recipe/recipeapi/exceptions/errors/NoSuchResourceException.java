package com.recipe.recipeapi.exceptions.errors;


public class NoSuchResourceException extends RuntimeException {
    public NoSuchResourceException(String msg){
        super(msg);
    }

}
