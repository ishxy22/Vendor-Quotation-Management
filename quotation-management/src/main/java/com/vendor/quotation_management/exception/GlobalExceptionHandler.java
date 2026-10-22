package com.vendor.quotation_management.exception;

import com.vendor.quotation_management.response.ResponseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseBean<Object>> handleResourceNotFound(ResourceNotFoundException ex) {
        logger.error("ResourceNotFoundException: {}", ex.getMessage());

        ResponseBean<Object> response = new ResponseBean<>("ERROR", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseBean<Object>> handleBadRequest(IllegalArgumentException ex) {
        logger.warn("Bad Request / IllegalArgumentException: {}", ex.getMessage());

        ResponseBean<Object> response = new ResponseBean<>("FAILURE", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseBean<Object>> handleGlobalException(Exception ex) {
        logger.error("Unhandled Exception occurred: {}", ex.getMessage(), ex);

        ResponseBean<Object> response = new ResponseBean<>(
                "ERROR",
                "An unexpected error occurred: " + ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}