package com.Damascus.Library.dto.request;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for authentication request containing user credentials
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Authentication request payload")
public class AuthRequest {

    @NotBlank(message = "Username cannot be blank")
    @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
    @Schema(description = "Unique username", example = "john_doe", requiredMode = Schema.RequiredMode.REQUIRED)
    private String username;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, max = 30, message = "Password must be between 8 and 30 characters")
    @Schema(description = "User password", example = "SecureP@ss123", requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;
}