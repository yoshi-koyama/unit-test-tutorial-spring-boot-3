package com.example.demo.service.response;

public class ValidationErrors {

    private String field;
    private String messages;

    public ValidationErrors(String field, String messages) {
        this.field = field;
        this.messages = messages;
    }

    public ValidationErrors() {
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }
}
