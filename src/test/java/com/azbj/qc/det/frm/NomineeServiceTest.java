package com.azbj.qc.det.frm;

import com.azbj.qc.det.frm.service.InsuranceCoverService;
import com.azbj.qc.det.frm.model.Nominee;
import com.azbj.qc.det.frm.service.NomineeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class NomineeServiceTest {

    @Mock
    private InsuranceCoverService insuranceCoverService;

    @InjectMocks
    private NomineeService nomineeService;

    private Nominee mockNominee;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockNominee = new Nominee();
        mockNominee.setContractId(1);
        mockNominee.setVersionNo(1);
        mockNominee.setObjectId(1);
        mockNominee.setActionCode("A");
        mockNominee.setTopIndicator('Y');
        mockNominee.setPartitionNo(1);
        mockNominee.setCoverCode("COV123");
        mockNominee.setCoverNo(1);
        mockNominee.setPreviousVersion(0);
        mockNominee.setReversingVersion(0);
        mockNominee.setSumInsuredWholeCover(100000.0);
        mockNominee.setSumInsuredCompanyShare(50000.0);
        mockNominee.setFtpremiumOrWholeCover(1000.0);
        mockNominee.setFtpremiumSysCompanyShare(500.0);
        mockNominee.setAgentCommissionWholeCover(100.0);
        mockNominee.setAgentCommissionCompanyShare(50.0);
        mockNominee.setSharePortion(50.0);
        mockNominee.setCvcCode("CVC123");
        mockNominee.setSurchargeDiscount(10.0);
        mockNominee.setReinsurableRiskAmount(50000.0);
        mockNominee.setPcovContractId(1);
        mockNominee.setPcovPartitionNo(1);
        mockNominee.setPcovCoverCode("PCOV123");
        mockNominee.setPcovCoverNo(1);
    }

    @Test
    public void testAddNominee() {
        when(insuranceCoverService.addNominee(any(Nominee.class))).thenReturn(mockNominee);

        Nominee addedNominee = nomineeService.addNominee(mockNominee);

        assertNotNull(addedNominee);
        assertEquals(mockNominee.getContractId(), addedNominee.getContractId());
        verify(insuranceCoverService, times(1)).addNominee(any(Nominee.class));
    }

    @Test
    public void testUpdateNominee() {
        when(insuranceCoverService.updateNominee(any(Nominee.class))).thenReturn(mockNominee);

        Nominee updatedNominee = nomineeService.updateNominee(mockNominee);

        assertNotNull(updatedNominee);
        assertEquals(mockNominee.getContractId(), updatedNominee.getContractId());
        verify(insuranceCoverService, times(1)).updateNominee(any(Nominee.class));
    }

    @Test
    public void testGetNominee() {
        when(insuranceCoverService.getNominee(anyInt(), anyInt())).thenReturn(mockNominee);

        Nominee retrievedNominee = nomineeService.getNominee(mockNominee.getContractId(), mockNominee.getVersionNo());

        assertNotNull(retrievedNominee);
        assertEquals(mockNominee.getContractId(), retrievedNominee.getContractId());
        verify(insuranceCoverService, times(1)).getNominee(anyInt(), anyInt());
    }

    @Test
    public void testGetNomineeInformation() {
        when(insuranceCoverService.getNomineeInformation(anyInt(), anyInt())).thenReturn(mockNominee);

        Nominee nomineeInfo = nomineeService.getNomineeInformation(mockNominee.getContractId(), mockNominee.getVersionNo());

        assertNotNull(nomineeInfo);
        assertEquals(mockNominee.getContractId(), nomineeInfo.getContractId());
        verify(insuranceCoverService, times(1)).getNomineeInformation(anyInt(), anyInt());
    }

    @Test
    public void testUpdateNomineeInformation() {
        when(insuranceCoverService.updateNomineeInformation(any(Nominee.class))).thenReturn(mockNominee);

        Nominee updatedInfo = nomineeService.updateNomineeInformation(mockNominee);

        assertNotNull(updatedInfo);
        assertEquals(mockNominee.getContractId(), updatedInfo.getContractId());
        verify(insuranceCoverService, times(1)).updateNomineeInformation(any(Nominee.class));
    }
}
