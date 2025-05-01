package com.Damascus.Library.service;

import com.Damascus.Library.dto.response.BorrowingResponse;

public interface BorrowingService {
    BorrowingResponse borrowBook(Long bookId, Long patronId);
}