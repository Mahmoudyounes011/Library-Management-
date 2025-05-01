package com.Damascus.Library.dto.request;

import jakarta.validation.constraints.*;

public record PatronCreateRequest(
        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
        String name,

        @NotBlank(message = "Email is required")
        @Email(message = "Email should be valid")
        String email,

        @NotBlank(message = "Phone number is required")
        @Pattern(regexp = "^(\\+963|0)?9\\d{8}$",
                message = "Invalid phone number format")
        String phoneNumber
) {}