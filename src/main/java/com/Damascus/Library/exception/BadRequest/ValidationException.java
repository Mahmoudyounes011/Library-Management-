package com.Damascus.Library.exception.BadRequest;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}