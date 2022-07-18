package com.example.demo.service.response;

public class MessageOnlyResponce extends Responce {

    private String message;

    public MessageOnlyResponce(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
