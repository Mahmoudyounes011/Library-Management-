package com.Damascus.Library.dto.response;

import com.Damascus.Library.model.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {
    private Long id;
    private String title;
    private String author;
    private Integer publicationYear;
    private String isbn;
    private boolean available;
    private LocalDateTime createdAt;

    public static BookResponse fromEntity(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .publicationYear(book.getPublicationYear())
                .isbn(book.getIsbn())
                .available(book.getAvailable()) // Changed from isAvailable() to getAvailable()
                .createdAt(book.getCreatedAt())
                .build();
    }
}