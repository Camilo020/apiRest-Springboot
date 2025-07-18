package com.example.auth_api.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LoginResponse(
    @JsonProperty("token") String token,
    @JsonProperty("refreshToken") String refreshToken
) {}
