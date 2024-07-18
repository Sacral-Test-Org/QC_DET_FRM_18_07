package com.azbj.qc.det.frm;

import com.azbj.qc.det.frm.repository.InsuranceCoverRepository;
import com.azbj.qc.det.frm.service.InsuranceCoverService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class InsuranceCoverServiceTest {

    @Mock
    private InsuranceCoverRepository insuranceCoverRepository;

    @InjectMocks
    private InsuranceCoverService insuranceCoverService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCoverDetails() {
        // Mock input
        String contractId = "12345";
        // Mock output
        InsuranceCover cover = new InsuranceCover();
        cover.setContractId(contractId);

        when(insuranceCoverRepository.findByContractId(contractId)).thenReturn(cover);

        // Call the method
        InsuranceCover result = insuranceCoverService.getCoverDetails(contractId);

        // Verify the result
        assertNotNull(result);
        assertEquals(contractId, result.getContractId());
    }

    @Test
    public void testSaveCoverDetails() {
        // Mock input
        InsuranceCover cover = new InsuranceCover();
        cover.setContractId("12345");

        when(insuranceCoverRepository.save(cover)).thenReturn(cover);

        // Call the method
        InsuranceCover result = insuranceCoverService.saveCoverDetails(cover);

        // Verify the result
        assertNotNull(result);
        assertEquals("12345", result.getContractId());
    }

    @Test
    public void testUpdateCoverDetails() {
        // Mock input
        InsuranceCover cover = new InsuranceCover();
        cover.setContractId("12345");

        when(insuranceCoverRepository.save(cover)).thenReturn(cover);

        // Call the method
        InsuranceCover result = insuranceCoverService.updateCoverDetails(cover);

        // Verify the result
        assertNotNull(result);
        assertEquals("12345", result.getContractId());
    }

    @Test
    public void testDeleteCoverDetails() {
        // Mock input
        String contractId = "12345";

        doNothing().when(insuranceCoverRepository).deleteByContractId(contractId);

        // Call the method
        insuranceCoverService.deleteCoverDetails(contractId);

        // Verify the result
        verify(insuranceCoverRepository, times(1)).deleteByContractId(contractId);
    }

    @Test
    public void testResetQCStatus() {
        // Mock input
        String policyRef = "POL12345";

        doNothing().when(insuranceCoverRepository).resetQCStatus(policyRef);

        // Call the method
        insuranceCoverService.resetQCStatus(policyRef);

        // Verify the result
        verify(insuranceCoverRepository, times(1)).resetQCStatus(policyRef);
    }

    @Test
    public void testUpdateQcStatus() {
        // Mock input
        String policyRef = "POL12345";

        doNothing().when(insuranceCoverRepository).updateQcStatus(policyRef);

        // Call the method
        insuranceCoverService.updateQcStatus(policyRef);

        // Verify the result
        verify(insuranceCoverRepository, times(1)).updateQcStatus(policyRef);
    }

    @Test
    public void testResetForm() {
        // Call the method
        insuranceCoverService.resetForm();

        // Verify the result
        // Assuming resetForm method clears some fields, we can verify the state of those fields
        // Here we assume resetForm method sets some internal state to null or default values
        // Add appropriate assertions based on the actual implementation of resetForm
    }

    @Test
    public void testAddNominee() {
        // Mock input
        Nominee nominee = new Nominee();
        nominee.setContractId("12345");

        when(insuranceCoverRepository.saveNominee(nominee)).thenReturn(nominee);

        // Call the method
        Nominee result = insuranceCoverService.addNominee(nominee);

        // Verify the result
        assertNotNull(result);
        assertEquals("12345", result.getContractId());
    }

    @Test
    public void testUpdateNominee() {
        // Mock input
        Nominee nominee = new Nominee();
        nominee.setContractId("12345");

        when(insuranceCoverRepository.saveNominee(nominee)).thenReturn(nominee);

        // Call the method
        Nominee result = insuranceCoverService.updateNominee(nominee);

        // Verify the result
        assertNotNull(result);
        assertEquals("12345", result.getContractId());
    }

    @Test
    public void testGetNominee() {
        // Mock input
        String contractId = "12345";
        // Mock output
        Nominee nominee = new Nominee();
        nominee.setContractId(contractId);

        when(insuranceCoverRepository.findNomineeByContractId(contractId)).thenReturn(nominee);

        // Call the method
        Nominee result = insuranceCoverService.getNominee(contractId);

        // Verify the result
        assertNotNull(result);
        assertEquals(contractId, result.getContractId());
    }

    @Test
    public void testGetNomineeInformation() {
        // Mock input
        String contractId = "12345";
        // Mock output
        NomineeInformation nomineeInfo = new NomineeInformation();
        nomineeInfo.setContractId(contractId);

        when(insuranceCoverRepository.findNomineeInformationByContractId(contractId)).thenReturn(nomineeInfo);

        // Call the method
        NomineeInformation result = insuranceCoverService.getNomineeInformation(contractId);

        // Verify the result
        assertNotNull(result);
        assertEquals(contractId, result.getContractId());
    }

    @Test
    public void testUpdateNomineeInformation() {
        // Mock input
        NomineeInformation nomineeInfo = new NomineeInformation();
        nomineeInfo.setContractId("12345");

        when(insuranceCoverRepository.saveNomineeInformation(nomineeInfo)).thenReturn(nomineeInfo);

        // Call the method
        NomineeInformation result = insuranceCoverService.updateNomineeInformation(nomineeInfo);

        // Verify the result
        assertNotNull(result);
        assertEquals("12345", result.getContractId());
    }

    @Test
    public void testUpdatePolicyReferenceStatus() {
        // Mock input
        String policyRef = "POL12345";

        doNothing().when(insuranceCoverRepository).updatePolicyReferenceStatus(policyRef);

        // Call the method
        insuranceCoverService.updatePolicyReferenceStatus(policyRef);

        // Verify the result
        verify(insuranceCoverRepository, times(1)).updatePolicyReferenceStatus(policyRef);
    }

    @Test
    public void testUpdateNomineeName() {
        // Mock input
        String contractId = "12345";
        String oldNomineeName = "Old Name";
        String newNomineeName = "New Name";

        doNothing().when(insuranceCoverRepository).updateNomineeName(contractId, oldNomineeName, newNomineeName);

        // Call the method
        insuranceCoverService.updateNomineeName(contractId, oldNomineeName, newNomineeName);

        // Verify the result
        verify(insuranceCoverRepository, times(1)).updateNomineeName(contractId, oldNomineeName, newNomineeName);
    }

    @Test
    public void testGetSolutionId() {
        // Mock input
        String applicationNo = "APP12345";
        // Mock output
        String solutionId = "SOL12345";

        when(insuranceCoverRepository.findSolutionIdByApplicationNo(applicationNo)).thenReturn(solutionId);

        // Call the method
        String result = insuranceCoverService.getSolutionId(applicationNo);

        // Verify the result
        assertNotNull(result);
        assertEquals(solutionId, result);
    }

    @Test
    public void testGetContractId() {
        // Mock input
        String policyRef = "POL12345";
        // Mock output
        String contractId = "CON12345";

        when(insuranceCoverRepository.findContractIdByPolicyRef(policyRef)).thenReturn(contractId);

        // Call the method
        String result = insuranceCoverService.getContractId(policyRef);

        // Verify the result
        assertNotNull(result);
        assertEquals(contractId, result);
    }

    @Test
    public void testGetPolicyNumber() {
        // Mock input
        String contractId = "CON12345";
        // Mock output
        String policyNumber = "POL12345";

        when(insuranceCoverRepository.findPolicyNumberByContractId(contractId)).thenReturn(policyNumber);

        // Call the method
        String result = insuranceCoverService.getPolicyNumber(contractId);

        // Verify the result
        assertNotNull(result);
        assertEquals(policyNumber, result);
    }

    @Test
    public void testGenerateUrl() {
        // Mock input
        String policyNumber = "POL12345";
        // Mock output
        String url = "http://example.com/document/POL12345";

        when(insuranceCoverRepository.generateUrl(policyNumber)).thenReturn(url);

        // Call the method
        String result = insuranceCoverService.generateUrl(policyNumber);

        // Verify the result
        assertNotNull(result);
        assertEquals(url, result);
    }

    @Test
    public void testProcessUnderwritingComments() {
        // Mock input
        String policyNumber = "POL12345";
        // Mock output
        UnderwritingComments comments = new UnderwritingComments();
        comments.setPolicyNumber(policyNumber);

        when(insuranceCoverRepository.findUnderwritingCommentsByPolicyNumber(policyNumber)).thenReturn(comments);

        // Call the method
        UnderwritingComments result = insuranceCoverService.processUnderwritingComments(policyNumber);

        // Verify the result
        assertNotNull(result);
        assertEquals(policyNumber, result.getPolicyNumber());
    }

    @Test
    public void testFetchVendorDetails() {
        // Mock input
        String branchCode = "BR123";
        // Mock output
        List<Vendor> vendors = new ArrayList<>();
        Vendor vendor = new Vendor();
        vendor.setVendorCode("V123");
        vendor.setVendorName("Vendor Name");
        vendors.add(vendor);

        when(insuranceCoverRepository.findVendorsByBranchCode(branchCode)).thenReturn(vendors);

        // Call the method
        List<Vendor> result = insuranceCoverService.fetchVendorDetails(branchCode);

        // Verify the result
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("V123", result.get(0).getVendorCode());
    }

    @Test
    public void testManageDispatchDetails() {
        // Mock input
        DispatchDetails dispatchDetails = new DispatchDetails();
        dispatchDetails.setPolicyRef("POL12345");

        when(insuranceCoverRepository.saveDispatchDetails(dispatchDetails)).thenReturn(dispatchDetails);

        // Call the method
        DispatchDetails result = insuranceCoverService.manageDispatchDetails(dispatchDetails);

        // Verify the result
        assertNotNull(result);
        assertEquals("POL12345", result.getPolicyRef());
    }

    @Test
    public void testAddFundDetails() {
        // Mock input
        FundDetails fundDetails = new FundDetails();
        fundDetails.setContractId("12345");

        when(insuranceCoverRepository.saveFundDetails(fundDetails)).thenReturn(fundDetails);

        // Call the method
        FundDetails result = insuranceCoverService.addFundDetails(fundDetails);

        // Verify the result
        assertNotNull(result);
        assertEquals("12345", result.getContractId());
    }

    @Test
    public void testUpdateFundDetails() {
        // Mock input
        FundDetails fundDetails = new FundDetails();
        fundDetails.setContractId("12345");

        when(insuranceCoverRepository.saveFundDetails(fundDetails)).thenReturn(fundDetails);

        // Call the method
        FundDetails result = insuranceCoverService.updateFundDetails(fundDetails);

        // Verify the result
        assertNotNull(result);
        assertEquals("12345", result.getContractId());
    }

    @Test
    public void testGetFundDetails() {
        // Mock input
        String contractId = "12345";
        // Mock output
        FundDetails fundDetails = new FundDetails();
        fundDetails.setContractId(contractId);

        when(insuranceCoverRepository.findFundDetailsByContractId(contractId)).thenReturn(fundDetails);

        // Call the method
        FundDetails result = insuranceCoverService.getFundDetails(contractId);

        // Verify the result
        assertNotNull(result);
        assertEquals(contractId, result.getContractId());
    }

    @Test
    public void testUpdatePhysicalCopyStatus() {
        // Mock input
        String policyNumber = "POL12345";
        String physicalCopyStatus = "Y";

        doNothing().when(insuranceCoverRepository).updatePhysicalCopyStatus(policyNumber, physicalCopyStatus);

        // Call the method
        insuranceCoverService.updatePhysicalCopyStatus(policyNumber, physicalCopyStatus);

        // Verify the result
        verify(insuranceCoverRepository, times(1)).updatePhysicalCopyStatus(policyNumber, physicalCopyStatus);
    }

    @Test
    public void testValidateAndProcessPolicyReference() {
        // Mock input
        String policyRef = "POL12345";

        doNothing().when(insuranceCoverRepository).validateAndProcessPolicyReference(policyRef);

        // Call the method
        insuranceCoverService.validateAndProcessPolicyReference(policyRef);

        // Verify the result
        verify(insuranceCoverRepository, times(1)).validateAndProcessPolicyReference(policyRef);
    }

    @Test
    public void testHandleSubmit() {
        // Mock input
        String policyRef = "POL12345";
        String user = "user123";

        doNothing().when(insuranceCoverRepository).handleSubmit(policyRef, user);

        // Call the method
        insuranceCoverService.handleSubmit(policyRef, user);

        // Verify the result
        verify(insuranceCoverRepository, times(1)).handleSubmit(policyRef, user);
    }

    @Test
    public void testHandleSkipReason() {
        // Mock input
        String reason = "OTHERS";
        String comments = "Some comments";

        doNothing().when(insuranceCoverRepository).handleSkipReason(reason, comments);

        // Call the method
        insuranceCoverService.handleSkipReason(reason, comments);

        // Verify the result
        verify(insuranceCoverRepository, times(1)).handleSkipReason(reason, comments);
    }

    @Test
    public void testFetchUnderwritingComments() {
        // Mock input
        String policyNumber = "POL12345";
        // Mock output
        UnderwritingComments comments = new UnderwritingComments();
        comments.setPolicyNumber(policyNumber);

        when(insuranceCoverRepository.findUnderwritingCommentsByPolicyNumber(policyNumber)).thenReturn(comments);

        // Call the method
        UnderwritingComments result = insuranceCoverService.fetchUnderwritingComments(policyNumber);

        // Verify the result
        assertNotNull(result);
        assertEquals(policyNumber, result.getPolicyNumber());
    }

    @Test
    public void testManageUnderwritingComments() {
        // Mock input
        UnderwritingComments comments = new UnderwritingComments();
        comments.setPolicyNumber("POL12345");

        when(insuranceCoverRepository.saveUnderwritingComments(comments)).thenReturn(comments);

        // Call the method
        UnderwritingComments result = insuranceCoverService.manageUnderwritingComments(comments);

        // Verify the result
        assertNotNull(result);
        assertEquals("POL12345", result.getPolicyNumber());
    }
}
