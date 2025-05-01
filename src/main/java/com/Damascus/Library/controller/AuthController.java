package com.Damascus.Library.controller;


import com.Damascus.Library.dto.request.AuthRequest;
import com.Damascus.Library.dto.request.RegisterRequest;
import com.Damascus.Library.dto.response.AuthResponse;
import com.Damascus.Library.model.enums.Role;
import com.Damascus.Library.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;  
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register/admin")
    @Operation(summary = "Register new admin", description = "Create a new admin account")
    public ResponseEntity<AuthResponse> registerAdmin(
            @Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request, Role.ROLE_ADMIN));
    }

    @PostMapping("/register/patron")
    @Operation(summary = "Register new patron", description = "Create a new patron account")
    public ResponseEntity<AuthResponse> registerPatron(
            @Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request, Role.ROLE_PATRON));
    }

    @PostMapping("/login")
    @Operation(summary = "User login", description = "Authenticate user and return JWT token")
    public ResponseEntity<AuthResponse> login(
            @Valid @RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}