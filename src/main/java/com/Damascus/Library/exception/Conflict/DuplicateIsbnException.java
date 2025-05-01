package com.Damascus.Library.exception.Conflict;

public class DuplicateIsbnException extends RuntimeException {
    public DuplicateIsbnException(String isbn) {
        super("ISBN already exists: " + isbn);
    }
}
