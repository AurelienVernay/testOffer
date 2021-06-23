package com.aureltest.testOffer.web.errors;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Handle Person
 */
@RestControllerAdvice
public class PersonErrorHandler {

    @ExceptionHandler(PersonLogicException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleCustomException(PersonLogicException ce) {
        // of course we can include more data
        return Map.of("message", ce.getMessage());
    }

}
