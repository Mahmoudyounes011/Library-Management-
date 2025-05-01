package com.Damascus.Library.controller;

import com.Damascus.Library.dto.request.BookCreateRequest;
import com.Damascus.Library.dto.request.BookUpdateRequest;
import com.Damascus.Library.dto.request.PatronCreateRequest;
import com.Damascus.Library.dto.request.PatronUpdateRequest;
import com.Damascus.Library.dto.response.BookResponse;
import com.Damascus.Library.dto.response.BookResponse;
import com.Damascus.Library.dto.response.PatronResponse;
import com.Damascus.Library.service.PatronService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/api/patrons")
@RequiredArgsConstructor
@Tag(name = "Patron Management", description = "Endpoints for managing patrons")
public class PatronController {

    @Autowired
    private PatronService patronService;

    @GetMapping
    @Operation(summary = "get all patrons",description = "Retrieve list of all available books")
    public ResponseEntity<Page<PatronResponse>> getAllPatrons(
            @PageableDefault(size = 10, sort = "name") Pageable pageable) {
        return ResponseEntity.ok(patronService.findAllPatrons(pageable));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Patron by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Patron found"),
            @ApiResponse(responseCode = "404", description = "Patron not found")
    })
    public ResponseEntity<Optional<PatronResponse>> getPatronById(
            @Parameter(description = "ID of Patron to be searched")
            @PathVariable Long id) {
        return ResponseEntity.ok(patronService.findPatronById(id));
    }

    @PostMapping
    @Operation(summary = "Create a new patron")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "patron created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "email already exists")
    })
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PatronResponse> createPatron(@Valid @RequestBody PatronCreateRequest request) {
        PatronResponse response = patronService.createPatron(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a patron", description = "Update an existing patron's information")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "patron updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "patron not found"),
            @ApiResponse(responseCode = "409", description = "Email conflict with another book")
    })
    public ResponseEntity<PatronResponse> updatePatron(
            @Parameter(description = "ID of the patron to update") @PathVariable Long id,
            @Valid @RequestBody PatronUpdateRequest request) {
        PatronResponse response = patronService.updatePatron(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a patron", description = "Remove a patron from the library")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "patron deleted successfully"),
            @ApiResponse(responseCode = "404", description = "patron not found")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteBook(
            @Parameter(description = "ID of the patron to delete") @PathVariable Long id) {
        patronService.deletePatron(id);
        return ResponseEntity.noContent().build();
    }




}
