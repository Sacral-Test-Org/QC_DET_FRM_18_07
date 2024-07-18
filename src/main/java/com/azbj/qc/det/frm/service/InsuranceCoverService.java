package com.azbj.qc.det.frm.service;

import com.azbj.qc.det.frm.repository.InsuranceCoverRepository;
import com.azbj.qc.det.frm.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceCoverService {

    @Autowired
    private InsuranceCoverRepository insuranceCoverRepository;

    @Autowired
    private AuthenticationRepository authenticationRepository;

    // Method to fetch insurance cover details
    public List<InsuranceCover> getCoverDetails(String contractId) {
        return insuranceCoverRepository.findByContractId(contractId);
    }

    // Method to save new cover details
    public InsuranceCover saveCoverDetails(InsuranceCover coverDetails) {
        return insuranceCoverRepository.save(coverDetails);
    }

    // Method to update existing cover details
    public InsuranceCover updateCoverDetails(InsuranceCover coverDetails) {
        return insuranceCoverRepository.save(coverDetails);
    }

    // Method to delete cover details
    public void deleteCoverDetails(String contractId) {
        insuranceCoverRepository.deleteByContractId(contractId);
    }

    // Method to get social status
    public String getSocialStatus(String contractId) {
        return insuranceCoverRepository.findSocialStatus(contractId);
    }

    // Method to fetch rider details
    public List<RiderDetails> getRiderDetails(String contractId) {
        return insuranceCoverRepository.findRiderDetailsByContractId(contractId);
    }

    // Method to save rider details
    public RiderDetails saveRiderDetails(RiderDetails riderDetails) {
        return insuranceCoverRepository.save(riderDetails);
    }

    // Method to cancel an operation
    public void cancelOperation(String operationId) {
        // Implement cancel operation logic
    }

    // Method to search records
    public List<InsuranceCover> searchRecords(String searchCriteria) {
        return insuranceCoverRepository.searchByCriteria(searchCriteria);
    }

    // Method to reset form fields
    public void resetForm() {
        // Implement form reset logic
    }

    // Method to submit form data
    public void submitForm(FormData formData) {
        // Implement form submission logic
    }

    // Method to update nominee information
    public void updateNominee(Nominee nominee) {
        insuranceCoverRepository.updateNominee(nominee);
    }

    // Method to view images
    public void viewImages(String policyRef) {
        // Implement view images logic
    }

    // Method to enrich data
    public void enrichData(String proposalNumber) {
        // Implement data enrichment logic
    }

    // Method to handle checkboxes
    public void handleCheckboxes(String checkboxId, boolean isChecked) {
        // Implement checkbox handling logic
    }

    // Method to display items
    public void displayItems(String itemId) {
        // Implement item display logic
    }

    // Method to skip an operation
    public void skipOperation(String reason, String comments) {
        // Implement skip operation logic
    }

    // Method to manage comments
    public void manageComments(String policyNumber, String comments) {
        // Implement comment management logic
    }

    // Method to update policy status
    public void updatePolicyStatus(String policyRef, String status, String subStatus) {
        insuranceCoverRepository.updatePolicyStatus(policyRef, status, subStatus);
    }

    // Method to track QC process
    public void trackQCProcess(String policyRef) {
        // Implement QC process tracking logic
    }

    // Method to commit changes
    public void commitChanges() {
        // Implement commit changes logic
    }

    // Method to save reason of skip
    public void saveReasonOfSkip(String reason, String contractId, String versionNumber, Object otherDetails) {
        insuranceCoverRepository.saveReasonOfSkip(reason, contractId, versionNumber, otherDetails);
    }

    // Method to get reasons of skip
    public List<String> getReasonsOfSkip() {
        return insuranceCoverRepository.findAllReasonsOfSkip();
    }

    // Method to update QC records
    public void updateQCRecords() {
        insuranceCoverRepository.updateQCRecords();
    }

    // Method to reset QC status
    public boolean resetQCStatus(String policyRef) {
        return insuranceCoverRepository.updateQCStatus(policyRef);
    }

    // Method to authenticate user
    public boolean authenticate(String supervisorId, String password) {
        return authenticationRepository.findBySupervisorIdAndPassword(supervisorId, password) != null;
    }

    // Method to add nominee
    public void addNominee(Nominee nominee) {
        insuranceCoverRepository.save(nominee);
    }

    // Method to get nominee information
    public Nominee getNomineeInformation(String contractId) {
        return insuranceCoverRepository.findNomineeByContractId(contractId);
    }

    // Method to update nominee information
    public void updateNomineeInformation(Nominee nominee) {
        insuranceCoverRepository.updateNominee(nominee);
    }

    // Method to update policy reference status
    public boolean updatePolicyReferenceStatus(String policyRef) {
        return insuranceCoverRepository.updatePolicyReferenceStatus(policyRef);
    }

    // Method to update nominee name
    public boolean updateNomineeName(String contractId, String oldNomineeName, String newNomineeName) {
        return insuranceCoverRepository.updateNomineeName(contractId, oldNomineeName, newNomineeName);
    }

    // Method to get fund details
    public List<FundDetails> getFundDetails() {
        return insuranceCoverRepository.findFundDetails();
    }

    // Method to process underwriting comments
    public List<UnderwritingComment> processUnderwritingComments(String policyNumber, String userProfile) {
        return insuranceCoverRepository.findUnderwritingComments(policyNumber, userProfile);
    }

    // Method to save dispatch details
    public void saveDispatchDetails(DispatchDetails dispatchDetails) {
        insuranceCoverRepository.save(dispatchDetails);
    }

    // Method to get dispatch details
    public DispatchDetails getDispatchDetails(String shipmentNumber) {
        return insuranceCoverRepository.findByShipmentNumber(shipmentNumber);
    }

    // Method to fetch vendor details
    public List<Vendor> fetchVendorDetails(String user) {
        return insuranceCoverRepository.findVendors(user);
    }

    // Method to update physical copy status
    public boolean updatePhysicalCopyStatus(String physicalCopyStatus, String policyNumber) {
        return insuranceCoverRepository.updatePhysicalCopyStatus(physicalCopyStatus, policyNumber);
    }

    // Method to validate and process policy reference
    public PolicyData validateAndProcessPolicyReference(String policyRef) {
        return insuranceCoverRepository.validateAndProcessPolicyReference(policyRef);
    }

    // Method to enrich policy data
    public EnrichmentData enrichPolicyData(String proposalNumber) {
        return insuranceCoverRepository.enrichPolicyData(proposalNumber);
    }

    // Method to handle submit action
    public void handleSubmit(String policyRef, UserDetails userDetails) {
        insuranceCoverRepository.handleSubmit(policyRef, userDetails);
    }

    // Method to handle skip reason
    public void handleSkipReason(String reason, String comments) {
        insuranceCoverRepository.handleSkipReason(reason, comments);
    }

    // Method to fetch underwriting comments
    public List<UnderwritingComment> fetchUnderwritingComments(String policyNumber) {
        return insuranceCoverRepository.findUnderwritingComments(policyNumber);
    }

    // Method to manage underwriting comments
    public void manageUnderwritingComments(UnderwritingComment commentsData) {
        insuranceCoverRepository.updateUnderwritingComments(commentsData);
    }
}
