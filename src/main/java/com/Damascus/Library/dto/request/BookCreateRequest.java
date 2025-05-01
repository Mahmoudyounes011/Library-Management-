package com.Damascus.Library.dto.request;

import jakarta.validation.constraints.*;
import java.time.Year;

public record BookCreateRequest(
        @NotBlank(message = "Title is required")
        @Size(max = 100, message = "Title cannot exceed 100 characters")
        String title,

        @NotBlank(message = "Author is required")
        @Size(max = 50, message = "Author name cannot exceed 50 characters")
        String author,

        @Min(value = 1000, message = "Year must be at least 1000")
        @Max(value = 2100, message = "Year must be reasonable")
        Integer publicationYear,

        @Pattern(regexp = "^(97(8|9))?\\d{9}(\\d|X)$",
                message = "Invalid ISBN format")
        String isbn
) {}