package com.Damascus.Library.dto.request;

import jakarta.validation.constraints.*;


public record PatronUpdateRequest(
        @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
        String name,

        @Email(message = "Email should be valid")
        String email,

        @Pattern(regexp = "^(\\+963|0)?9\\d{8}$",
                message = "Invalid phone number format")
        String phoneNumber,

        Boolean active
) {}