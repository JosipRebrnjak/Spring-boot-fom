package com.spring.rest.fom.exception;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import com.spring.rest.fom.dto.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleNotFound(ResourceNotFoundException ex) {
    ApiResponse<Object> response = new ApiResponse<>(
        false,
        ex.getMessage(),
        null
    );
    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Object>> handleValidationErrors(MethodArgumentNotValidException ex) {
    String message = ex.getBindingResult()
        .getFieldErrors()
        .stream()
        .map(e -> e.getField() + ": " + e.getDefaultMessage())
        .collect(Collectors.joining("; "));

    ApiResponse<Object> response = new ApiResponse<>(
        false,
        message,
        null
    );

    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}