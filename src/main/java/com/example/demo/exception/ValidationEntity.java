package com.example.demo.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
import java.util.List;

public class ValidationEntity {

    private ZonedDateTime timestamp;
    private HttpStatus status;
    private String error;

    private List<ValidationErrorDetail> errors;

    private String path;

    public ValidationEntity(ZonedDateTime timestamp, HttpStatus status, String error, List<ValidationErrorDetail> errors, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.errors = errors;
        this.path = path;
    }

    public static class ValidationErrorDetail {

        private String field;
        private String message;

        public ValidationErrorDetail(String field, String message) {
            this.field = field;
            this.message = message;
        }
    }
}
