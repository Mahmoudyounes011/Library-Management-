package com.Damascus.Library.exception.NotFound;


public class PatronNotFoundException extends RuntimeException {
    public PatronNotFoundException(Long id) {
        super("Patron not found with id: " + id);
    }
}