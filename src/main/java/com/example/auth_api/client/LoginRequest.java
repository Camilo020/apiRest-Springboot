package com.example.auth_api.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LoginRequest(
    @JsonProperty("username") String username,
    @JsonProperty("password") String password
) {}
