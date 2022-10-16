package com.recipe.recipeapi.exceptions;

import com.recipe.recipeapi.exceptions.errors.NoSuchResourceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchResourceException.class)
    public ResponseEntity<?> noSuchMethodExceptionHandler(NoSuchResourceException ex){
        log.error(String.format("Exception occurred: [ %s ] resulted in: [ %s ]", ex.getLocalizedMessage(), ex.getClass().getName()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(
                    ErrorMessage.builder()
                        .message(ex.getLocalizedMessage())
                        .statusCode(HttpStatus.NOT_FOUND.value())
                        .build()
        );
    }
}
