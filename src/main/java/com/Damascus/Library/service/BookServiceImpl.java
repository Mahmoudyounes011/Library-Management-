package com.Damascus.Library.service;
import com.Damascus.Library.dto.request.BookCreateRequest;
import com.Damascus.Library.dto.request.BookUpdateRequest;
import com.Damascus.Library.dto.response.BookResponse;
import com.Damascus.Library.dto.response.BookResponse;
import com.Damascus.Library.exception.BookNotFoundException;
import com.Damascus.Library.exception.DuplicateIsbnException;
import com.Damascus.Library.model.entity.Book;
import com.Damascus.Library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
    public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<BookResponse> findAllBooks(Pageable pageable) {
        return bookRepository.findAll(pageable)
                .map(BookResponse::fromEntity);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<BookResponse> findBookById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid book ID");
        }
        return Optional.ofNullable(bookRepository.findById(id)
                .map(BookResponse::fromEntity)
                .orElseThrow(() -> new BookNotFoundException(id)));
    }

    @Override
    @Transactional
    public BookResponse createBook(BookCreateRequest request) {
        if (bookRepository.existsByIsbn(request.isbn())) {
            throw new DuplicateIsbnException(request.isbn());
        }

        Book book = Book.builder()
                .title(request.title())
                .author(request.author())
                .publicationYear(request.publicationYear())
                .isbn(request.isbn())
                .available(true)
                .build();

        Book savedBook = bookRepository.save(book);
        return BookResponse.fromEntity(savedBook);
    }


    @Override
    @Transactional
    public BookResponse updateBook(Long id, BookUpdateRequest request) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        // Check if ISBN is being changed and if new ISBN already exists
        if (!existingBook.getIsbn().equals(request.isbn())){
            if (bookRepository.existsByIsbn(request.isbn())) {
                throw new DuplicateIsbnException(request.isbn());
            }
            existingBook.setIsbn(request.isbn());
        }

        existingBook.setTitle(request.title());
        existingBook.setAuthor(request.author());
        existingBook.setPublicationYear(request.publicationYear());

        Book updatedBook = bookRepository.save(existingBook);
        return BookResponse.fromEntity(updatedBook);
    }

    @Override
    @Transactional
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException(id);
        }
        bookRepository.deleteById(id);
    }

}