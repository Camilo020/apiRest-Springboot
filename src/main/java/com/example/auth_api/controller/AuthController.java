package com.example.auth_api.controller;

import com.example.auth_api.client.LoginResponse;
import com.example.auth_api.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequestPayload payload) {

        LoginResponse response = authService.loginAndLog(payload.username(), payload.password());

        return ResponseEntity.ok(response);
    }
}


record LoginRequestPayload(String username, String password) {}
