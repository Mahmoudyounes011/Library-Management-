package com.Damascus.Library.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for authentication response containing JWT token
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Authentication response payload")
public class AuthResponse {

    @Schema(description = "JWT access token",
            example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String token;

    @Schema(description = "Token type",
            example = "Bearer",
            defaultValue = "Bearer")
    @Builder.Default
    private String tokenType = "Bearer";


}