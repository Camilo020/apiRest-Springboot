package com.example.auth_api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "dummyjson", url = "${dummyjson.api.url}")
public interface DummyJsonClient {


    @PostMapping("/auth/login")
    LoginResponse login(LoginRequest request);



    @GetMapping("/auth/me")
    AuthenticatedUser getAuthenticatedUser(@RequestHeader("Authorization") String token);
}
