package com.example.demo.service.response;

import java.util.List;

public class ValidationErrorResponce extends Responce {

    private String message;
    private List<ValidationErrors> ValidationErrors;

    public ValidationErrorResponce(String message, List<ValidationErrors> ValidationErrors) {
        this.message = message;
        this.ValidationErrors = ValidationErrors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ValidationErrors> getErrors() {
        return ValidationErrors;
    }

    public void setErrors(List<ValidationErrors> ValidationErrors) {
        this.ValidationErrors = ValidationErrors;
    }
}
