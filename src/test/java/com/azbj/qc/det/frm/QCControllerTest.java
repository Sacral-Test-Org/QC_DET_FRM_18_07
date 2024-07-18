package com.azbj.qc.det.frm;

import com.azbj.qc.det.frm.controller.InsuranceCoverController;
import com.azbj.qc.det.frm.model.QCBlock;
import com.azbj.qc.det.frm.service.QCService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class QCControllerTest {

    @InjectMocks
    private InsuranceCoverController insuranceCoverController;

    @Mock
    private QCService qcService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(insuranceCoverController).build();
    }

    @Test
    public void testGetSocialStatus() throws Exception {
        String expectedStatus = "R";
        when(qcService.getSocialStatus(any())).thenReturn(expectedStatus);

        ResponseEntity<String> response = insuranceCoverController.getSocialStatus("someContractId");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedStatus, response.getBody());
    }

    @Test
    public void testUpdateQCBlockRecords() throws Exception {
        QCBlock mockQCBlock = new QCBlock();
        when(qcService.updateQCBlockRecords(any())).thenReturn(mockQCBlock);

        mockMvc.perform(put("/api/qc/update")
                .contentType("application/json")
                .content("{\"ci\":\"Y\",\"flg\":10}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateQCBlock() throws Exception {
        QCBlock mockQCBlock = new QCBlock();
        when(qcService.updateQCBlock(any())).thenReturn(mockQCBlock);

        mockMvc.perform(put("/api/qc/updateBlock")
                .contentType("application/json")
                .content("{\"ci\":\"Y\",\"flg\":10}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateQCRecords() throws Exception {
        QCBlock mockQCBlock = new QCBlock();
        when(qcService.updateQCRecords(any())).thenReturn(mockQCBlock);

        mockMvc.perform(put("/api/qc/updateRecords")
                .contentType("application/json")
                .content("{\"ci\":\"Y\",\"flg\":10}"))
                .andExpect(status().isOk());
    }
}
