package com.glzd.expenseTrackerApp.business.services;

import com.glzd.expenseTrackerApp.business.model.User;
import com.glzd.expenseTrackerApp.data.UserRepository;
import com.glzd.expenseTrackerApp.Security.JwtService;
import com.glzd.expenseTrackerApp.web.dto.AuthResponse;
import com.glzd.expenseTrackerApp.web.dto.LoginRequest;
import com.glzd.expenseTrackerApp.web.dto.RegisterRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String register(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());

        user.setPassword(
                passwordEncoder.encode(
                        request.getPassword()
                )
        );

        user.setRole("USER");

        userRepository.save(user);

        return "User Registered Successfully";
    }

    public AuthResponse login(LoginRequest request) {

        User user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("Invalid Email"));

        boolean isPasswordValid =
                passwordEncoder.matches(
                        request.getPassword(),
                        user.getPassword()
                );

        if (!isPasswordValid) {
            throw new RuntimeException("Invalid Password");
        }

        String token =
                jwtService.generateToken(
                        user.getEmail()
                );

        return new AuthResponse(token);
    }
}