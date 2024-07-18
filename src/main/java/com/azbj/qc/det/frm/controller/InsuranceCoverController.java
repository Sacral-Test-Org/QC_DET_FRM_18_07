package com.azbj.qc.det.frm.controller;

import com.azbj.qc.det.frm.service.InsuranceCoverService;
import com.azbj.qc.det.frm.service.AuthenticationService;
import com.azbj.qc.det.frm.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/insurance-cover")
public class InsuranceCoverController {

    @Autowired
    private InsuranceCoverService insuranceCoverService;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/cover-details/{contractId}")
    public ResponseEntity<?> getCoverDetails(@PathVariable String contractId) {
        return ResponseEntity.ok(insuranceCoverService.getCoverDetails(contractId));
    }

    @PostMapping("/cover-details")
    public ResponseEntity<?> saveCoverDetails(@RequestBody CoverDetails coverDetails) {
        return ResponseEntity.ok(insuranceCoverService.saveCoverDetails(coverDetails));
    }

    @PutMapping("/cover-details")
    public ResponseEntity<?> updateCoverDetails(@RequestBody CoverDetails coverDetails) {
        return ResponseEntity.ok(insuranceCoverService.updateCoverDetails(coverDetails));
    }

    @DeleteMapping("/cover-details/{contractId}")
    public ResponseEntity<?> deleteCoverDetails(@PathVariable String contractId) {
        insuranceCoverService.deleteCoverDetails(contractId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/social-status/{contractId}")
    public ResponseEntity<?> getSocialStatus(@PathVariable String contractId) {
        return ResponseEntity.ok(insuranceCoverService.getSocialStatus(contractId));
    }

    @GetMapping("/rider-details/{contractId}")
    public ResponseEntity<?> getRiderDetails(@PathVariable String contractId) {
        return ResponseEntity.ok(insuranceCoverService.getRiderDetails(contractId));
    }

    @PostMapping("/rider-details")
    public ResponseEntity<?> saveRiderDetails(@RequestBody RiderDetails riderDetails) {
        return ResponseEntity.ok(insuranceCoverService.saveRiderDetails(riderDetails));
    }

    @PostMapping("/control/cancel")
    public ResponseEntity<?> cancelOperation() {
        insuranceCoverService.cancelOperation();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/control/search")
    public ResponseEntity<?> searchRecords(@RequestParam String criteria) {
        return ResponseEntity.ok(insuranceCoverService.searchRecords(criteria));
    }

    @PostMapping("/control/reset")
    public ResponseEntity<?> resetForm() {
        insuranceCoverService.resetForm();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/control/submit")
    public ResponseEntity<?> submitForm(@RequestBody FormData formData) {
        return ResponseEntity.ok(insuranceCoverService.submitForm(formData));
    }

    @PostMapping("/control/update-nominee")
    public ResponseEntity<?> updateNominee(@RequestBody NomineeDetails nomineeDetails) {
        return ResponseEntity.ok(insuranceCoverService.updateNominee(nomineeDetails));
    }

    @GetMapping("/control/view-images")
    public ResponseEntity<?> viewImages(@RequestParam String policyRef) {
        return ResponseEntity.ok(insuranceCoverService.viewImages(policyRef));
    }

    @PostMapping("/control/enrich")
    public ResponseEntity<?> enrichData(@RequestParam String proposalNumber) {
        return ResponseEntity.ok(insuranceCoverService.enrichData(proposalNumber));
    }

    @PostMapping("/control/handle-checkboxes")
    public ResponseEntity<?> handleCheckboxes(@RequestBody CheckboxData checkboxData) {
        return ResponseEntity.ok(insuranceCoverService.handleCheckboxes(checkboxData));
    }

    @GetMapping("/control/display-items")
    public ResponseEntity<?> displayItems() {
        return ResponseEntity.ok(insuranceCoverService.displayItems());
    }

    @PostMapping("/control/skip")
    public ResponseEntity<?> skipOperation(@RequestBody SkipReason skipReason) {
        return ResponseEntity.ok(insuranceCoverService.skipOperation(skipReason));
    }

    @PostMapping("/control/manage-comments")
    public ResponseEntity<?> manageComments(@RequestBody CommentData commentData) {
        return ResponseEntity.ok(insuranceCoverService.manageComments(commentData));
    }

    @PostMapping("/control/update-policy-status")
    public ResponseEntity<?> updatePolicyStatus(@RequestBody PolicyStatus policyStatus) {
        return ResponseEntity.ok(insuranceCoverService.updatePolicyStatus(policyStatus));
    }

    @PostMapping("/control/track-qc-process")
    public ResponseEntity<?> trackQCProcess(@RequestBody QCProcessData qcProcessData) {
        return ResponseEntity.ok(insuranceCoverService.trackQCProcess(qcProcessData));
    }

    @PostMapping("/control/commit-changes")
    public ResponseEntity<?> commitChanges() {
        insuranceCoverService.commitChanges();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/reason-of-skip")
    public ResponseEntity<?> saveReasonOfSkip(@RequestBody SkipReason skipReason) {
        return ResponseEntity.ok(insuranceCoverService.saveReasonOfSkip(skipReason));
    }

    @GetMapping("/reason-of-skip")
    public ResponseEntity<?> getReasonsOfSkip() {
        return ResponseEntity.ok(insuranceCoverService.getReasonsOfSkip());
    }

    @PutMapping("/qc-records")
    public ResponseEntity<?> updateQCRecords() {
        insuranceCoverService.updateQCRecords();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/qc-status/reset")
    public ResponseEntity<?> resetQCStatus(@RequestParam String policyRef) {
        insuranceCoverService.resetQCStatus(policyRef);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/qc-block-records")
    public ResponseEntity<?> updateQCBlockRecords() {
        insuranceCoverService.updateQCBlockRecords();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/qc-status/update-reset")
    public ResponseEntity<?> updateQcStatusAndResetForm(@RequestParam String policyRef) {
        insuranceCoverService.updateQcStatus(policyRef);
        insuranceCoverService.resetForm();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticateUser(@RequestParam String supervisorId, @RequestParam String password) {
        return ResponseEntity.ok(authenticationService.authenticate(supervisorId, password));
    }

    @PostMapping("/nominee")
    public ResponseEntity<?> addNominee(@RequestBody NomineeDetails nomineeDetails) {
        return ResponseEntity.ok(insuranceCoverService.addNominee(nomineeDetails));
    }

    @PutMapping("/nominee")
    public ResponseEntity<?> updateNominee(@RequestBody NomineeDetails nomineeDetails) {
        return ResponseEntity.ok(insuranceCoverService.updateNominee(nomineeDetails));
    }

    @GetMapping("/nominee/{contractId}")
    public ResponseEntity<?> getNominee(@PathVariable String contractId) {
        return ResponseEntity.ok(insuranceCoverService.getNominee(contractId));
    }

    @GetMapping("/nominee-info")
    public ResponseEntity<?> getNomineeInformation(@RequestParam String contractId) {
        return ResponseEntity.ok(insuranceCoverService.getNomineeInformation(contractId));
    }

    @PutMapping("/nominee-info")
    public ResponseEntity<?> updateNomineeInformation(@RequestBody NomineeDetails nomineeDetails) {
        return ResponseEntity.ok(insuranceCoverService.updateNomineeInformation(nomineeDetails));
    }

    @PostMapping("/exit")
    public ResponseEntity<?> exitForm(@RequestParam String policyRef) {
        insuranceCoverService.updatePolicyReferenceStatus(policyRef);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/nominee-name")
    public ResponseEntity<?> updateNomineeName(@RequestParam String contractId, @RequestParam String oldNomineeName, @RequestParam String newNomineeName) {
        return ResponseEntity.ok(insuranceCoverService.updateNomineeName(contractId, oldNomineeName, newNomineeName));
    }

    @GetMapping("/fund-details")
    public ResponseEntity<?> getFundDetails() {
        return ResponseEntity.ok(insuranceCoverService.getFundDetails());
    }

    @PostMapping("/dispatch-details")
    public ResponseEntity<?> saveDispatchDetails(@RequestBody DispatchDetails dispatchDetails) {
        return ResponseEntity.ok(insuranceCoverService.saveDispatchDetails(dispatchDetails));
    }

    @GetMapping("/dispatch-details/{shipmentNumber}")
    public ResponseEntity<?> getDispatchDetails(@PathVariable String shipmentNumber) {
        return ResponseEntity.ok(insuranceCoverService.getDispatchDetails(shipmentNumber));
    }

    @GetMapping("/vendor-details")
    public ResponseEntity<?> getVendorDetails(@RequestParam String user) {
        return ResponseEntity.ok(insuranceCoverService.fetchVendorDetails(user));
    }

    @PutMapping("/physical-copy-status")
    public ResponseEntity<?> updatePhysicalCopyStatus(@RequestParam String physicalCopyStatus, @RequestParam String policyNumber) {
        return ResponseEntity.ok(insuranceCoverService.updatePhysicalCopyStatus(physicalCopyStatus, policyNumber));
    }

    @PostMapping("/validate-policy")
    public ResponseEntity<?> validateAndProcessPolicyReference(@RequestParam String policyRef) {
        return ResponseEntity.ok(insuranceCoverService.validateAndProcessPolicyReference(policyRef));
    }

    @PostMapping("/enrich")
    public ResponseEntity<?> enrichPolicyData(@RequestParam String proposalNumber) {
        return ResponseEntity.ok(insuranceCoverService.enrichPolicyData(proposalNumber));
    }

    @GetMapping("/underwriting-comments")
    public ResponseEntity<?> getUnderwritingComments(@RequestParam String policyNumber) {
        return ResponseEntity.ok(insuranceCoverService.fetchUnderwritingComments(policyNumber));
    }

    @PutMapping("/underwriting-comments")
    public ResponseEntity<?> updateUnderwritingComments(@RequestBody CommentData commentData) {
        return ResponseEntity.ok(insuranceCoverService.manageUnderwritingComments(commentData));
    }
}
