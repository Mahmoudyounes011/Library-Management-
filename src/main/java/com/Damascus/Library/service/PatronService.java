package com.Damascus.Library.service;

import com.Damascus.Library.dto.request.BookCreateRequest;
import com.Damascus.Library.dto.request.BookUpdateRequest;
import com.Damascus.Library.dto.request.PatronCreateRequest;
import com.Damascus.Library.dto.request.PatronUpdateRequest;
import com.Damascus.Library.dto.response.BookResponse;
import com.Damascus.Library.dto.response.PatronResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PatronService {

    Page<PatronResponse> findAllPatrons(Pageable pageable);
    Optional<PatronResponse> findPatronById(Long id);
    PatronResponse createPatron(PatronCreateRequest request);
    PatronResponse updatePatron(Long id, PatronUpdateRequest request);
    void deletePatron(Long id);
}
