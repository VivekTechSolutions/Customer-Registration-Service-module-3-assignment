package com.customer_management_module_3.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error", ex.getBindingResult()
            .getFieldError().getDefaultMessage());
        return errors;
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public Map<String, String> handleNotFound(CustomerNotFoundException ex) {
        return Map.of("error", ex.getMessage());
    }
}
