package com.example.auth_api.service;

import com.example.auth_api.client.DummyJsonClient;
import com.example.auth_api.client.LoginRequest;
import com.example.auth_api.client.LoginResponse;
import com.example.auth_api.model.LoginLog;
import com.example.auth_api.repository.LoginLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthService {

    private final DummyJsonClient dummyJsonClient;
    private final LoginLogRepository loginLogRepository;


    public AuthService(DummyJsonClient dummyJsonClient, LoginLogRepository loginLogRepository) {
        this.dummyJsonClient = dummyJsonClient;
        this.loginLogRepository = loginLogRepository;
    }


    public LoginResponse loginAndLog(String username, String password) {

        LoginRequest loginRequest = new LoginRequest(username, password);


        LoginResponse loginResponse = dummyJsonClient.login(loginRequest);


        if (loginResponse != null && loginResponse.token() != null) {

            LoginLog log = new LoginLog();
            log.setUsername(username);
            log.setLoginTime(LocalDateTime.now());
            log.setAccessToken(loginResponse.token());
            log.setRefreshToken(loginResponse.refreshToken());


            loginLogRepository.save(log);
        }


        return loginResponse;
    }
}