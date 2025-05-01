package com.Damascus.Library.exception.Conflict;

public class BookNotAvailableException extends RuntimeException {
    public BookNotAvailableException(Long bookId) {
        super("Book with id " + bookId + " is currently not available");
    }
}