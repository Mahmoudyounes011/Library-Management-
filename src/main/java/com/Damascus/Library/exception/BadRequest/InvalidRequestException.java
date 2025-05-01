package com.Damascus.Library.exception.BadRequest;


public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException(String message) {
        super(message);
    }
}