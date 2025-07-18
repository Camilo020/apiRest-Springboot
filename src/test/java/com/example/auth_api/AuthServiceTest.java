package com.example.auth_api;

import com.example.auth_api.client.DummyJsonClient;
import com.example.auth_api.client.LoginRequest;
import com.example.auth_api.client.LoginResponse;
import com.example.auth_api.repository.LoginLogRepository;
import com.example.auth_api.service.AuthService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {
    @Mock
    private DummyJsonClient dummyJsonClient;

    @Mock
    private LoginLogRepository loginLogRepository;

    @InjectMocks
    private AuthService authService;

    @Test
    void testLoginAndLog_Success() {

        String username = "emilys";
        String password = "emilyspass";
        LoginRequest request = new LoginRequest(username, password);
        LoginResponse fakeResponse = new LoginResponse("fake-token-123", "fake-refresh-token-456");



        when(dummyJsonClient.login(any(LoginRequest.class))).thenReturn(fakeResponse);



        LoginResponse actualResponse = authService.loginAndLog(username, password);



        assertNotNull(actualResponse);
        assertEquals("fake-token-123", actualResponse.token());



        verify(loginLogRepository, times(1)).save(any());
    }
}
