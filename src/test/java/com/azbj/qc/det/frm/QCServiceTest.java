package com.azbj.qc.det.frm;

import com.azbj.qc.det.frm.service.InsuranceCoverService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class QCServiceTest {

    @Mock
    private InsuranceCoverService insuranceCoverService;

    @InjectMocks
    private QCService qcService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetSocialStatus() {
        String expectedStatus = "R";
        when(insuranceCoverService.getSocialStatus(anyString(), anyString())).thenReturn(expectedStatus);

        String actualStatus = qcService.getSocialStatus("contractId", "Y");
        assertEquals(expectedStatus, actualStatus);
    }

    @Test
    public void testUpdateQCBlockRecords() {
        // Mock data for QC block records
        QCBlockRecord record1 = new QCBlockRecord("Y", 10);
        QCBlockRecord record2 = new QCBlockRecord("Y", 11);
        QCBlockRecord record3 = new QCBlockRecord("N", 3);

        // Mock the service call
        when(insuranceCoverService.updateQCBlockRecords(record1)).thenReturn(true);
        when(insuranceCoverService.updateQCBlockRecords(record2)).thenReturn(true);
        when(insuranceCoverService.updateQCBlockRecords(record3)).thenReturn(true);

        // Call the method to test
        boolean result1 = qcService.updateQCBlockRecords(record1);
        boolean result2 = qcService.updateQCBlockRecords(record2);
        boolean result3 = qcService.updateQCBlockRecords(record3);

        // Verify the results
        assertEquals(true, result1);
        assertEquals(true, result2);
        assertEquals(true, result3);
    }

    @Test
    public void testHandleCIRadioButtonChange() {
        // Mock data for QC block records
        QCBlockRecord record1 = new QCBlockRecord("N", 10);
        QCBlockRecord record2 = new QCBlockRecord("N", 3);
        QCBlockRecord record3 = new QCBlockRecord("N", 11);
        QCBlockRecord record4 = new QCBlockRecord("Y", 10);
        QCBlockRecord record5 = new QCBlockRecord("Y", 11);

        // Mock the service call for SOCIAL_STATUS retrieval
        when(insuranceCoverService.getSocialStatus(anyString(), anyString())).thenReturn("R");

        // Call the method to test
        qcService.handleCIRadioButtonChange(record1);
        qcService.handleCIRadioButtonChange(record2);
        qcService.handleCIRadioButtonChange(record3);
        qcService.handleCIRadioButtonChange(record4);
        qcService.handleCIRadioButtonChange(record5);

        // Verify the results
        assertEquals("Y", record1.getControlBlock().getCH1());
        assertEquals("Y", record3.getControlBlock().getCH6());
        assertEquals("N", record4.getControlBlock().getCH1());
        assertEquals("N", record4.getControlBlock().getCH2());
        assertEquals("N", record4.getControlBlock().getCH3());
        assertEquals("N", record4.getControlBlock().getCH4());
        assertEquals("N", record4.getControlBlock().getCH5());
        assertEquals("N", record4.getControlBlock().getCH27());
        assertEquals("N", record5.getControlBlock().getCH6());
        assertEquals("N", record5.getControlBlock().getCH7());
        assertEquals("N", record5.getControlBlock().getCH8());
        assertEquals("N", record5.getControlBlock().getCH9());
        assertEquals("N", record5.getControlBlock().getCH10());
        assertEquals("N", record5.getControlBlock().getCH28());
    }
}
