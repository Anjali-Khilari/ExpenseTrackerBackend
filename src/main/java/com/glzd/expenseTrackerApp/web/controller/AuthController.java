package com.glzd.expenseTrackerApp.web.controller;

import com.glzd.expenseTrackerApp.business.services.AuthService;
import com.glzd.expenseTrackerApp.web.dto.AuthResponse;
import com.glzd.expenseTrackerApp.web.dto.LoginRequest;
import com.glzd.expenseTrackerApp.web.dto.RegisterRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @Valid @RequestBody RegisterRequest request) {

        return ResponseEntity.ok(
                authService.register(request)
        );
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @Valid @RequestBody LoginRequest request) {

        return ResponseEntity.ok(
                authService.login(request)
        );
    }
}