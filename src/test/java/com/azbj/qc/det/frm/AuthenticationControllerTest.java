package com.azbj.qc.det.frm;

import com.azbj.qc.det.frm.controller.AuthenticationController;
import com.azbj.qc.det.frm.service.AuthenticationService;
import com.azbj.qc.det.frm.model.AuthenticationRequest;
import com.azbj.qc.det.frm.model.AuthenticationResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class AuthenticationControllerTest {

    @InjectMocks
    private AuthenticationController authenticationController;

    @Mock
    private AuthenticationService authenticationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAuthenticateUser() {
        // Arrange
        AuthenticationRequest request = new AuthenticationRequest();
        request.setSupervisorId("SUP123");
        request.setPassword("password");

        AuthenticationResponse response = new AuthenticationResponse();
        response.setAuthenticated(true);
        response.setMessage("Authentication successful");

        when(authenticationService.authenticateUser(any(AuthenticationRequest.class))).thenReturn(response);

        // Act
        ResponseEntity<AuthenticationResponse> result = authenticationController.authenticateUser(request);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("Authentication successful", result.getBody().getMessage());
        assertEquals(true, result.getBody().isAuthenticated());
    }

    @Test
    public void testAuthenticateSupervisor() {
        // Arrange
        AuthenticationRequest request = new AuthenticationRequest();
        request.setSupervisorId("SUP456");
        request.setPassword("password123");

        AuthenticationResponse response = new AuthenticationResponse();
        response.setAuthenticated(true);
        response.setMessage("Supervisor authentication successful");

        when(authenticationService.authenticateSupervisor(any(AuthenticationRequest.class))).thenReturn(response);

        // Act
        ResponseEntity<AuthenticationResponse> result = authenticationController.authenticateSupervisor(request);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("Supervisor authentication successful", result.getBody().getMessage());
        assertEquals(true, result.getBody().isAuthenticated());
    }
}
