package com.example.auth_api.client;

public record AuthenticatedUser(long id, String username, String email, String firstName, String lastName) {}
