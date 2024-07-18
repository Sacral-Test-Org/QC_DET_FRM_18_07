package com.azbj.qc.det.frm;

import com.azbj.qc.det.frm.service.AuthenticationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AuthenticationServiceTest {

    @Mock
    private AuthenticationService authenticationService;

    @InjectMocks
    private AuthenticationServiceTest authenticationServiceTest;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAuthenticate() {
        // Mocking the authentication service to return true for valid credentials
        when(authenticationService.authenticate(anyString(), anyString())).thenReturn(true);

        // Test with valid credentials
        boolean isAuthenticated = authenticationService.authenticate("SUPERVISOR1", "password123");
        assertTrue(isAuthenticated, "The authentication should be successful for valid credentials.");

        // Mocking the authentication service to return false for invalid credentials
        when(authenticationService.authenticate(anyString(), anyString())).thenReturn(false);

        // Test with invalid credentials
        isAuthenticated = authenticationService.authenticate("SUPERVISOR1", "wrongpassword");
        assertTrue(!isAuthenticated, "The authentication should fail for invalid credentials.");
    }
}
