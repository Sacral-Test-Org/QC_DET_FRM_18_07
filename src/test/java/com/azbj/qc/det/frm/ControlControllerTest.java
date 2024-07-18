package com.azbj.qc.det.frm;

import com.azbj.qc.det.frm.controller.ControlController;
import com.azbj.qc.det.frm.service.ControlService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ControlControllerTest {

    @InjectMocks
    private ControlController controlController;

    @Mock
    private ControlService controlService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCancelOperation() {
        when(controlService.cancelOperation(any())).thenReturn("Operation cancelled");
        ResponseEntity<String> response = controlController.cancelOperation("123");
        assertEquals("Operation cancelled", response.getBody());
    }

    @Test
    public void testSearchRecords() {
        when(controlService.searchRecords(any())).thenReturn("Search results");
        ResponseEntity<String> response = controlController.searchRecords("criteria");
        assertEquals("Search results", response.getBody());
    }

    @Test
    public void testResetForm() {
        when(controlService.resetForm(any())).thenReturn("Form reset");
        ResponseEntity<String> response = controlController.resetForm("formId");
        assertEquals("Form reset", response.getBody());
    }

    @Test
    public void testSubmitForm() {
        when(controlService.submitForm(any())).thenReturn("Form submitted");
        ResponseEntity<String> response = controlController.submitForm("formData");
        assertEquals("Form submitted", response.getBody());
    }

    @Test
    public void testUpdateNominee() {
        when(controlService.updateNominee(any())).thenReturn("Nominee updated");
        ResponseEntity<String> response = controlController.updateNominee("nomineeData");
        assertEquals("Nominee updated", response.getBody());
    }

    @Test
    public void testViewImages() {
        when(controlService.viewImages(any())).thenReturn("Image data");
        ResponseEntity<String> response = controlController.viewImages("policyId");
        assertEquals("Image data", response.getBody());
    }

    @Test
    public void testEnrichData() {
        when(controlService.enrichData(any())).thenReturn("Data enriched");
        ResponseEntity<String> response = controlController.enrichData("data");
        assertEquals("Data enriched", response.getBody());
    }

    @Test
    public void testHandleCheckboxes() {
        when(controlService.handleCheckboxes(any())).thenReturn("Checkboxes handled");
        ResponseEntity<String> response = controlController.handleCheckboxes("checkboxData");
        assertEquals("Checkboxes handled", response.getBody());
    }

    @Test
    public void testDisplayItems() {
        when(controlService.displayItems(any())).thenReturn("Display items");
        ResponseEntity<String> response = controlController.displayItems("displayData");
        assertEquals("Display items", response.getBody());
    }

    @Test
    public void testSkipOperation() {
        when(controlService.skipOperation(any())).thenReturn("Operation skipped");
        ResponseEntity<String> response = controlController.skipOperation("operationId");
        assertEquals("Operation skipped", response.getBody());
    }

    @Test
    public void testManageComments() {
        when(controlService.manageComments(any())).thenReturn("Comments managed");
        ResponseEntity<String> response = controlController.manageComments("commentsData");
        assertEquals("Comments managed", response.getBody());
    }

    @Test
    public void testUpdatePolicyStatus() {
        when(controlService.updatePolicyStatus(any())).thenReturn("Policy status updated");
        ResponseEntity<String> response = controlController.updatePolicyStatus("policyStatusData");
        assertEquals("Policy status updated", response.getBody());
    }

    @Test
    public void testTrackQCProcess() {
        when(controlService.trackQCProcess(any())).thenReturn("QC process tracked");
        ResponseEntity<String> response = controlController.trackQCProcess("qcProcessData");
        assertEquals("QC process tracked", response.getBody());
    }

    @Test
    public void testCommitChanges() {
        when(controlService.commitChanges()).thenReturn("Changes committed");
        ResponseEntity<String> response = controlController.commitChanges();
        assertEquals("Changes committed", response.getBody());
    }
}
