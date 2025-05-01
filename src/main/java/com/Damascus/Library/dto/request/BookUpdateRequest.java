package com.Damascus.Library.dto.request;

import jakarta.validation.constraints.*;

public record BookUpdateRequest(
        @NotBlank String title,
        @NotBlank String author,
        @Min(1000) @Max(2100) Integer publicationYear,
        @Pattern(regexp = "^(97(8|9))?\\d{9}(\\d|X)$") String isbn
) {}
