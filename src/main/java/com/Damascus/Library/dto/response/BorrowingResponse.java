package com.Damascus.Library.dto.response;

import com.Damascus.Library.model.entity.BorrowingRecord;
import com.Damascus.Library.model.entity.Book;
import com.Damascus.Library.model.entity.Patron;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BorrowingResponse {
    private Long id;
    private Long bookId;
    private String bookTitle;
    private Long patronId;
    private String patronName;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private boolean returned;

    public static BorrowingResponse fromEntity(BorrowingRecord record) {
        Book book = record.getBook();
        Patron patron = record.getPatron();

        return BorrowingResponse.builder()
                .id(record.getId())
                .bookId(book != null ? book.getId() : null)
                .bookTitle(book != null ? book.getTitle() : null)
                .patronId(patron != null ? patron.getId() : null)
                .patronName(patron != null ? patron.getName() : null)
                .borrowDate(record.getBorrowDate())
                .dueDate(record.getDueDate())
                .returnDate(record.getReturnDate())
                .returned(record.getReturned())
                .build();
    }
}