package com.azbj.qc.det.frm;

import com.azbj.qc.det.frm.controller.InsuranceCoverController;
import com.azbj.qc.det.frm.model.RiderDetails;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RiderControllerTest {

    private MockMvc mockMvc;

    @Mock
    private InsuranceCoverController insuranceCoverController;

    @InjectMocks
    private RiderController riderController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(riderController).build();
    }

    @Test
    public void testGetRiderDetails() throws Exception {
        String contractId = "12345";
        RiderDetails riderDetails = new RiderDetails();
        riderDetails.setCoverCode("COV123");
        riderDetails.setSumInsuredWholeCover(100000);
        riderDetails.setBenefitTerm(10);
        riderDetails.setPremiumTerm(5);

        when(insuranceCoverController.getRiderDetails(contractId)).thenReturn(new ResponseEntity<>(riderDetails, HttpStatus.OK));

        mockMvc.perform(get("/rider/details/{contractId}", contractId))
                .andExpect(status().isOk());

        ResponseEntity<RiderDetails> response = insuranceCoverController.getRiderDetails(contractId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(riderDetails, response.getBody());
    }

    @Test
    public void testSaveRiderDetails() throws Exception {
        RiderDetails riderDetails = new RiderDetails();
        riderDetails.setCoverCode("COV123");
        riderDetails.setSumInsuredWholeCover(100000);
        riderDetails.setBenefitTerm(10);
        riderDetails.setPremiumTerm(5);

        when(insuranceCoverController.saveRiderDetails(any(RiderDetails.class))).thenReturn(new ResponseEntity<>(HttpStatus.CREATED));

        mockMvc.perform(post("/rider/save")
                .contentType("application/json")
                .content("{\"coverCode\":\"COV123\",\"sumInsuredWholeCover\":100000,\"benefitTerm\":10,\"premiumTerm\":5}"))
                .andExpect(status().isCreated());

        ResponseEntity<Void> response = insuranceCoverController.saveRiderDetails(riderDetails);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
}
