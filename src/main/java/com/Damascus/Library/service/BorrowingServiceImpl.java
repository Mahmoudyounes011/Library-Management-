package com.Damascus.Library.service;

import com.Damascus.Library.dto.response.BorrowingResponse;
import com.Damascus.Library.exception.Conflict.BookNotAvailableException;
import com.Damascus.Library.exception.NotFound.BookNotFoundException;
import com.Damascus.Library.exception.NotFound.PatronNotFoundException;
import com.Damascus.Library.model.entity.*;
import com.Damascus.Library.repository.*;
import com.Damascus.Library.service.BorrowingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class BorrowingServiceImpl implements BorrowingService {

    private final BorrowingRecordRepository borrowingRecordRepository;
    private final BookRepository bookRepository;
    private final PatronRepository patronRepository;

    @Override
    @Transactional
    public BorrowingResponse borrowBook(Long bookId, Long patronId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));

        Patron patron = patronRepository.findById(patronId)
                .orElseThrow(() -> new PatronNotFoundException(patronId));

        if (!book.getAvailable()) {
            throw new BookNotAvailableException(bookId);
        }

        BorrowingRecord record = BorrowingRecord.builder()
                .book(book)
                .patron(patron)
                .borrowDate(LocalDate.now())
                .dueDate(LocalDate.now().plusDays(14))
                .returned(false)
                .build();

        book.setAvailable(false);
        bookRepository.save(book);

        BorrowingRecord savedRecord = borrowingRecordRepository.save(record);

        return BorrowingResponse.fromEntity(savedRecord);
    }

}