package com.ecs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CarExceptionHandler {
    @ExceptionHandler(value = ModelNotFoundException.class)
    public ResponseEntity handleModelNotFoundException(ModelNotFoundException modelNotFoundException) {
        return new ResponseEntity("model not found", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value =CarDetailNotFoundException.class)
    public ResponseEntity handleCarNotFoundException(CarDetailNotFoundException carDetailNotFoundException) {
        return new ResponseEntity("car is not found", HttpStatus.NOT_FOUND);
    }
}