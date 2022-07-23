package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {

    private MethodArgumentNotValidException e;
    private HttpServletRequest request;

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoResourceFound(ResourceNotFoundException e, HttpServletRequest request) {
        Map<String, String> body = Map.of(
                "timestamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
                "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
                "message", e.getMessage(),
                "path", request.getRequestURI());
        return new ResponseEntity(body, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ValidationEntity handleValidationExceptions(MethodArgumentNotValidException ex, HttpServletRequest request) {
        List<ValidationEntity.ValidationErrorDetail> errors = new ArrayList<>();
        String[] validations = {"name", "genre"};
        for (String str : validations) {
            try {
                if (ex.getBindingResult().getFieldError(str).getField().equals(str)) {
                    errors.add(new ValidationEntity.ValidationErrorDetail(ex.getBindingResult().getFieldError(str).getField(), ex.getBindingResult().getFieldError(str).getDefaultMessage()));
                }
            } catch (NullPointerException e) {
            }
        }
        ValidationEntity validationEntity = new ValidationEntity(ZonedDateTime.now(), HttpStatus.BAD_REQUEST,
                HttpStatus.FOUND.getReasonPhrase(), errors, request.getRequestURI());
        return validationEntity;
    }
}

