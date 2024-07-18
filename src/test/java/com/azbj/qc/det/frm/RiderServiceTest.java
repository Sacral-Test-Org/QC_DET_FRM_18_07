package com.azbj.qc.det.frm;

import com.azbj.qc.det.frm.service.InsuranceCoverService;
import com.azbj.qc.det.frm.model.RiderDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class RiderServiceTest {

    @Mock
    private InsuranceCoverService insuranceCoverService;

    @InjectMocks
    private RiderService riderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetRiderDetails() {
        String contractId = "12345";
        RiderDetails expectedRiderDetails = new RiderDetails();
        expectedRiderDetails.setCoverCode("COV123");
        expectedRiderDetails.setSumInsuredWholeCover(100000);
        expectedRiderDetails.setBenefitTerm(10);
        expectedRiderDetails.setPremiumTerm(5);

        when(insuranceCoverService.getRiderDetails(contractId)).thenReturn(expectedRiderDetails);

        RiderDetails actualRiderDetails = riderService.getRiderDetails(contractId);

        assertEquals(expectedRiderDetails, actualRiderDetails);
        verify(insuranceCoverService, times(1)).getRiderDetails(contractId);
    }

    @Test
    public void testSaveRiderDetails() {
        RiderDetails riderDetails = new RiderDetails();
        riderDetails.setCoverCode("COV123");
        riderDetails.setSumInsuredWholeCover(100000);
        riderDetails.setBenefitTerm(10);
        riderDetails.setPremiumTerm(5);

        doNothing().when(insuranceCoverService).saveRiderDetails(any(RiderDetails.class));

        riderService.saveRiderDetails(riderDetails);

        verify(insuranceCoverService, times(1)).saveRiderDetails(riderDetails);
    }
}
