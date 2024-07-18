package com.azbj.qc.det.frm;

import com.azbj.qc.det.frm.controller.InsuranceCoverController;
import com.azbj.qc.det.frm.service.InsuranceCoverService;
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

public class InsuranceCoverControllerTest {

    @Mock
    private InsuranceCoverService insuranceCoverService;

    @InjectMocks
    private InsuranceCoverController insuranceCoverController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCoverDetails() {
        // Mock the service call
        when(insuranceCoverService.getCoverDetails(any(String.class))).thenReturn(new ResponseEntity<>("Cover Details", HttpStatus.OK));

        // Call the controller method
        ResponseEntity<String> response = insuranceCoverController.getCoverDetails("123");

        // Assert the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Cover Details", response.getBody());
    }

    @Test
    public void testSaveCoverDetails() {
        // Mock the service call
        when(insuranceCoverService.saveCoverDetails(any())).thenReturn(new ResponseEntity<>("Cover Saved", HttpStatus.CREATED));

        // Call the controller method
        ResponseEntity<String> response = insuranceCoverController.saveCoverDetails(new Object());

        // Assert the response
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Cover Saved", response.getBody());
    }

    @Test
    public void testUpdateCoverDetails() {
        // Mock the service call
        when(insuranceCoverService.updateCoverDetails(any())).thenReturn(new ResponseEntity<>("Cover Updated", HttpStatus.OK));

        // Call the controller method
        ResponseEntity<String> response = insuranceCoverController.updateCoverDetails(new Object());

        // Assert the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Cover Updated", response.getBody());
    }

    @Test
    public void testDeleteCoverDetails() {
        // Mock the service call
        when(insuranceCoverService.deleteCoverDetails(any(String.class))).thenReturn(new ResponseEntity<>("Cover Deleted", HttpStatus.OK));

        // Call the controller method
        ResponseEntity<String> response = insuranceCoverController.deleteCoverDetails("123");

        // Assert the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Cover Deleted", response.getBody());
    }

    @Test
    public void testResetQCStatus() {
        // Mock the service call
        when(insuranceCoverService.resetQCStatus(any(String.class))).thenReturn(new ResponseEntity<>("QC Status Reset", HttpStatus.OK));

        // Call the controller method
        ResponseEntity<String> response = insuranceCoverController.resetQCStatus("123");

        // Assert the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("QC Status Reset", response.getBody());
    }

    @Test
    public void testUpdateQcStatusAndResetForm() {
        // Mock the service call
        when(insuranceCoverService.updateQcStatusAndResetForm(any(String.class))).thenReturn(new ResponseEntity<>("QC Status Updated and Form Reset", HttpStatus.OK));

        // Call the controller method
        ResponseEntity<String> response = insuranceCoverController.updateQcStatusAndResetForm("123");

        // Assert the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("QC Status Updated and Form Reset", response.getBody());
    }

    @Test
    public void testAddNominee() {
        // Mock the service call
        when(insuranceCoverService.addNominee(any())).thenReturn(new ResponseEntity<>("Nominee Added", HttpStatus.CREATED));

        // Call the controller method
        ResponseEntity<String> response = insuranceCoverController.addNominee(new Object());

        // Assert the response
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Nominee Added", response.getBody());
    }

    @Test
    public void testUpdateNominee() {
        // Mock the service call
        when(insuranceCoverService.updateNominee(any())).thenReturn(new ResponseEntity<>("Nominee Updated", HttpStatus.OK));

        // Call the controller method
        ResponseEntity<String> response = insuranceCoverController.updateNominee(new Object());

        // Assert the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Nominee Updated", response.getBody());
    }

    @Test
    public void testGetNominee() {
        // Mock the service call
        when(insuranceCoverService.getNominee(any(String.class))).thenReturn(new ResponseEntity<>("Nominee Details", HttpStatus.OK));

        // Call the controller method
        ResponseEntity<String> response = insuranceCoverController.getNominee("123");

        // Assert the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Nominee Details", response.getBody());
    }

    @Test
    public void testGetNomineeInformation() {
        // Mock the service call
        when(insuranceCoverService.getNomineeInformation(any(String.class))).thenReturn(new ResponseEntity<>("Nominee Information", HttpStatus.OK));

        // Call the controller method
        ResponseEntity<String> response = insuranceCoverController.getNomineeInformation("123");

        // Assert the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Nominee Information", response.getBody());
    }

    @Test
    public void testUpdateNomineeInformation() {
        // Mock the service call
        when(insuranceCoverService.updateNomineeInformation(any())).thenReturn(new ResponseEntity<>("Nominee Information Updated", HttpStatus.OK));

        // Call the controller method
        ResponseEntity<String> response = insuranceCoverController.updateNomineeInformation(new Object());

        // Assert the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Nominee Information Updated", response.getBody());
    }

    @Test
    public void testExitForm() {
        // Mock the service call
        when(insuranceCoverService.exitForm(any(String.class))).thenReturn(new ResponseEntity<>("Form Exited", HttpStatus.OK));

        // Call the controller method
        ResponseEntity<String> response = insuranceCoverController.exitForm("123");

        // Assert the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Form Exited", response.getBody());
    }

    @Test
    public void testUpdateNomineeName() {
        // Mock the service call
        when(insuranceCoverService.updateNomineeName(any(String.class), any(String.class), any(String.class))).thenReturn(new ResponseEntity<>("Nominee Name Updated", HttpStatus.OK));

        // Call the controller method
        ResponseEntity<String> response = insuranceCoverController.updateNomineeName("123", "Old Name", "New Name");

        // Assert the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Nominee Name Updated", response.getBody());
    }

    @Test
    public void testViewDocumentImages() {
        // Mock the service call
        when(insuranceCoverService.viewDocumentImages(any(String.class))).thenReturn(new ResponseEntity<>("Document Images", HttpStatus.OK));

        // Call the controller method
        ResponseEntity<String> response = insuranceCoverController.viewDocumentImages("123");

        // Assert the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Document Images", response.getBody());
    }

    @Test
    public void testGetUnderwritingComments() {
        // Mock the service call
        when(insuranceCoverService.getUnderwritingComments(any(String.class))).thenReturn(new ResponseEntity<>("Underwriting Comments", HttpStatus.OK));

        // Call the controller method
        ResponseEntity<String> response = insuranceCoverController.getUnderwritingComments("123");

        // Assert the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Underwriting Comments", response.getBody());
    }

    @Test
    public void testUpdateUnderwritingComments() {
        // Mock the service call
        when(insuranceCoverService.updateUnderwritingComments(any())).thenReturn(new ResponseEntity<>("Underwriting Comments Updated", HttpStatus.OK));

        // Call the controller method
        ResponseEntity<String> response = insuranceCoverController.updateUnderwritingComments(new Object());

        // Assert the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Underwriting Comments Updated", response.getBody());
    }

    @Test
    public void testGetVendorDetails() {
        // Mock the service call
        when(insuranceCoverService.getVendorDetails(any(String.class))).thenReturn(new ResponseEntity<>("Vendor Details", HttpStatus.OK));

        // Call the controller method
        ResponseEntity<String> response = insuranceCoverController.getVendorDetails("123");

        // Assert the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Vendor Details", response.getBody());
    }

    @Test
    public void testHandleDispatchDetails() {
        // Mock the service call
        when(insuranceCoverService.handleDispatchDetails(any())).thenReturn(new ResponseEntity<>("Dispatch Details Handled", HttpStatus.OK));

        // Call the controller method
        ResponseEntity<String> response = insuranceCoverController.handleDispatchDetails(new Object());

        // Assert the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Dispatch Details Handled", response.getBody());
    }

    @Test
    public void testAddFundDetails() {
        // Mock the service call
        when(insuranceCoverService.addFundDetails(any())).thenReturn(new ResponseEntity<>("Fund Details Added", HttpStatus.CREATED));

        // Call the controller method
        ResponseEntity<String> response = insuranceCoverController.addFundDetails(new Object());

        // Assert the response
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Fund Details Added", response.getBody());
    }

    @Test
    public void testUpdateFundDetails() {
        // Mock the service call
        when(insuranceCoverService.updateFundDetails(any())).thenReturn(new ResponseEntity<>("Fund Details Updated", HttpStatus.OK));

        // Call the controller method
        ResponseEntity<String> response = insuranceCoverController.updateFundDetails(new Object());

        // Assert the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Fund Details Updated", response.getBody());
    }

    @Test
    public void testGetFundDetails() {
        // Mock the service call
        when(insuranceCoverService.getFundDetails(any(String.class))).thenReturn(new ResponseEntity<>("Fund Details", HttpStatus.OK));

        // Call the controller method
        ResponseEntity<String> response = insuranceCoverController.getFundDetails("123");

        // Assert the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Fund Details", response.getBody());
    }

    @Test
    public void testUpdatePhysicalCopyStatus() {
        // Mock the service call
        when(insuranceCoverService.updatePhysicalCopyStatus(any(String.class), any(String.class))).thenReturn(new ResponseEntity<>("Physical Copy Status Updated", HttpStatus.OK));

        // Call the controller method
        ResponseEntity<String> response = insuranceCoverController.updatePhysicalCopyStatus("Y", "123");

        // Assert the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Physical Copy Status Updated", response.getBody());
    }

    @Test
    public void testValidateAndProcessPolicyReference() {
        // Mock the service call
        when(insuranceCoverService.validateAndProcessPolicyReference(any(String.class))).thenReturn(new ResponseEntity<>("Policy Reference Processed", HttpStatus.OK));

        // Call the controller method
        ResponseEntity<String> response = insuranceCoverController.validateAndProcessPolicyReference("123");

        // Assert the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Policy Reference Processed", response.getBody());
    }

    @Test
    public void testHandleSubmit() {
        // Mock the service call
        when(insuranceCoverService.handleSubmit(any(String.class), any(String.class))).thenReturn(new ResponseEntity<>("Submit Handled", HttpStatus.OK));

        // Call the controller method
        ResponseEntity<String> response = insuranceCoverController.handleSubmit("123", "user");

        // Assert the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Submit Handled", response.getBody());
    }

    @Test
    public void testHandleSkipReason() {
        // Mock the service call
        when(insuranceCoverService.handleSkipReason(any(String.class), any(String.class))).thenReturn(new ResponseEntity<>("Skip Reason Handled", HttpStatus.OK));

        // Call the controller method
        ResponseEntity<String> response = insuranceCoverController.handleSkipReason("Reason", "Comments");

        // Assert the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Skip Reason Handled", response.getBody());
    }
}
