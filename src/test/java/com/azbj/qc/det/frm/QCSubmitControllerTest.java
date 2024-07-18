package com.azbj.qc.det.frm;

import com.azbj.qc.det.frm.controller.QCSubmitController;
import com.azbj.qc.det.frm.service.QCService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class QCSubmitControllerTest {

    @InjectMocks
    private QCSubmitController qcSubmitController;

    @Mock
    private QCService qcService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testHandleSubmit_Success() {
        // Arrange
        String policyRef = "POL123456";
        when(qcService.handleSubmit(anyString())).thenReturn(ResponseEntity.ok("QC Submission Successful"));

        // Act
        ResponseEntity<String> response = qcSubmitController.handleSubmit(policyRef);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("QC Submission Successful", response.getBody());
    }

    @Test
    public void testHandleSubmit_Error() {
        // Arrange
        String policyRef = "POL123456";
        when(qcService.handleSubmit(anyString())).thenReturn(ResponseEntity.status(400).body("Error in QC Submission"));

        // Act
        ResponseEntity<String> response = qcSubmitController.handleSubmit(policyRef);

        // Assert
        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Error in QC Submission", response.getBody());
    }

    @Test
    public void testHandleSubmit_NoPolicyRef() {
        // Arrange
        String policyRef = "";
        when(qcService.handleSubmit(anyString())).thenReturn(ResponseEntity.status(400).body("Policy reference number is required"));

        // Act
        ResponseEntity<String> response = qcSubmitController.handleSubmit(policyRef);

        // Assert
        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Policy reference number is required", response.getBody());
    }

    @Test
    public void testHandleSubmit_BotUser() {
        // Arrange
        String policyRef = "POL123456";
        when(qcService.handleSubmit(anyString())).thenReturn(ResponseEntity.status(403).body("Bot users are not allowed"));

        // Act
        ResponseEntity<String> response = qcSubmitController.handleSubmit(policyRef);

        // Assert
        assertEquals(403, response.getStatusCodeValue());
        assertEquals("Bot users are not allowed", response.getBody());
    }
}
