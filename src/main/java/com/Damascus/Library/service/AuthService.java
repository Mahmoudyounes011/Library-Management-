package com.Damascus.Library.service;


import com.Damascus.Library.dto.request.AuthRequest;
import com.Damascus.Library.dto.request.RegisterRequest;
import com.Damascus.Library.dto.response.AuthResponse;
import com.Damascus.Library.exception.Duplicate.DuplicateEmailException;
import com.Damascus.Library.exception.Duplicate.DuplicateUsernameException;
import com.Damascus.Library.model.enums.Role;
import com.Damascus.Library.model.entity.User;
import com.Damascus.Library.repository.UserRepository;
import com.Damascus.Library.security.LibraryUserDetails;
import com.Damascus.Library.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Transactional
    public AuthResponse register(RegisterRequest request, Role role) {
        // Check for duplicate username
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new DuplicateUsernameException(request.getUsername());
        }

        // Check for duplicate email
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new DuplicateEmailException(request.getUsername());
        }

        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(role)
                .active(true)
                .build();

        userRepository.save(user);

        String token = jwtService.generateToken(new LibraryUserDetails(user));
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    @Transactional(readOnly = true)
    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow();

        String token = jwtService.generateToken(new LibraryUserDetails(user));
        return AuthResponse.builder()
                .token(token)
                .build();
    }
}