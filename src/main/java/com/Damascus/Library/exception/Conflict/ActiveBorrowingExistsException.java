package com.Damascus.Library.exception.Conflict;

public class ActiveBorrowingExistsException extends RuntimeException {
    public ActiveBorrowingExistsException(Long patronId) {
        super("Patron with id " + patronId + " has active borrowings");
    }
}