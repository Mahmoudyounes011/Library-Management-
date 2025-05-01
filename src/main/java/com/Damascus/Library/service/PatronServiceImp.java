package com.Damascus.Library.service;

import com.Damascus.Library.dto.request.BookCreateRequest;
import com.Damascus.Library.dto.request.BookUpdateRequest;
import com.Damascus.Library.dto.request.PatronCreateRequest;
import com.Damascus.Library.dto.request.PatronUpdateRequest;
import com.Damascus.Library.dto.response.BookResponse;
import com.Damascus.Library.dto.response.BookResponse;
import com.Damascus.Library.dto.response.PatronResponse;
import com.Damascus.Library.exception.BookNotFoundException;
import com.Damascus.Library.exception.DuplicateIsbnException;
import com.Damascus.Library.model.entity.Book;
import com.Damascus.Library.model.entity.Patron;
import com.Damascus.Library.repository.PatronRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatronServiceImp implements  PatronService{

    private final PatronRepository patronRepository;


    @Override
    public Page<PatronResponse> findAllPatrons(Pageable pageable) {
        return patronRepository.findAll(pageable)
                .map(PatronResponse::fromEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PatronResponse> findPatronById(Long id) {
        if(id == null || id <= 0)
        {
            throw new IllegalArgumentException("Invalid book ID");
        }
        return Optional.ofNullable(patronRepository.findById(id)
                .map(PatronResponse::fromEntity)
                .orElseThrow(() -> new BookNotFoundException(id)));
    }

    @Override
    @Transactional
    public PatronResponse createPatron(PatronCreateRequest request) {
        if (patronRepository.existsByEmail(request.email())) {
            throw new DuplicateIsbnException(request.email());
        }
        Patron patron = Patron.builder()
                .name(request.name())
                .email(request.email())
                .phoneNumber(request.phoneNumber())
                .active(true)
                .build();
        Patron savedPatron = patronRepository.save(patron);
        return  PatronResponse.fromEntity(savedPatron);

    }

    @Override
    @Transactional
    public PatronResponse updatePatron(Long id, PatronUpdateRequest request) {
        Patron existingPatron = patronRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        if (!existingPatron.getEmail().equals(request.email())){
            if (patronRepository.existsByEmail(request.email())) {
                throw new DuplicateIsbnException(request.email());
            }
            existingPatron.setEmail(request.email());
        }

        existingPatron.setName(request.name());
        existingPatron.setPhoneNumber(request.phoneNumber());

       Patron updatePatron = patronRepository.save( existingPatron);
       return PatronResponse.fromEntity(updatePatron);
    }

    @Override
    @Transactional
    public void deletePatron(Long id) {
        if (!patronRepository.existsById(id)) {
            throw new BookNotFoundException(id);
        }
        patronRepository.deleteById(id);
    }


}



