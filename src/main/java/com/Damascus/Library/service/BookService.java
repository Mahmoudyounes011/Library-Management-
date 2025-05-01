package com.Damascus.Library.service;

import com.Damascus.Library.dto.request.BookCreateRequest;
import com.Damascus.Library.dto.request.BookUpdateRequest;
import com.Damascus.Library.dto.response.BookResponse;
import com.Damascus.Library.dto.response.BookResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BookService {
    Page<BookResponse> findAllBooks(Pageable pageable);
    Optional<BookResponse> findBookById(Long id);
    BookResponse createBook(BookCreateRequest request);
    BookResponse updateBook(Long id,BookUpdateRequest request);
     void deleteBook(Long id);


}