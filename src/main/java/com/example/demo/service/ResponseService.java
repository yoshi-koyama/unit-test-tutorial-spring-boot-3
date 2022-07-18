package com.example.demo.service;

import com.example.demo.service.response.MessageOnlyResponce;
import com.example.demo.service.response.ValidationErrorResponce;
import com.example.demo.service.response.ValidationErrors;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResponseService {


    private boolean aBoolean;

    public MessageOnlyResponce postSuccess() {
        MessageOnlyResponce postSuccessResponce = new MessageOnlyResponce("anime successfully created");
        return postSuccessResponce;
    }

    public MessageOnlyResponce updateSuccess() {
        MessageOnlyResponce updateSuccessResponce = new MessageOnlyResponce("anime successfully updated");
        return updateSuccessResponce;
    }

    public MessageOnlyResponce deleteSuccess() {
        MessageOnlyResponce deleteSuccessResponce = new MessageOnlyResponce("anime successfully deleted");
        return deleteSuccessResponce;
    }

    public MessageOnlyResponce userNotFound() {
        MessageOnlyResponce userNotFoundResponse = new MessageOnlyResponce("anime not found");
        return userNotFoundResponse;
    }

    public MessageOnlyResponce resourceNotFound() {
        MessageOnlyResponce responceNotFoundResponse = new MessageOnlyResponce("resource not found");
        return responceNotFoundResponse;
    }

    public ValidationErrorResponce validationError(BindingResult bindingResult) {
        List<ValidationErrors> validationErrorList = new ArrayList<>();
        String[] validations = {"name", "genre"};
        for (String str : validations) {
            try {
                if (bindingResult.getFieldError(str).getField().equals(str)) {
                    validationErrorList.add(new ValidationErrors(bindingResult.getFieldError(str).getField(), bindingResult.getFieldError(str).getDefaultMessage()));
                }
            } catch (NullPointerException e) {
            }
        }
        ValidationErrorResponce validationErrorResponce = new ValidationErrorResponce("validation error", validationErrorList);
        return validationErrorResponce;
    }
}
