package com.Damascus.Library.controller;

import com.Damascus.Library.dto.response.BorrowingResponse;
import com.Damascus.Library.service.BorrowingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrow")
@RequiredArgsConstructor
@Tag(name = "Borrowing Book By Patron", description = "Endpoints for borrowing books")
public class BorrowingController {

    private final BorrowingService borrowingService;

    @PostMapping("/{bookId}/patron/{patronId}")
    @Operation(summary = "Borrow a book", description = "Process book borrowing for a patron")
    @ApiResponse(responseCode = "200", description = "Book borrowed successfully")
    public ResponseEntity<BorrowingResponse> borrowBook(
            @PathVariable Long bookId,
            @PathVariable Long patronId) {
        return ResponseEntity.ok(borrowingService.borrowBook(bookId, patronId));
    }
}