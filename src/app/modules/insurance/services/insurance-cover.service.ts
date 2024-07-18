import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { InsuranceCover } from '../models/insurance-cover.model';
import { Rider } from '../models/rider.model';
import { Nominee } from '../models/nominee.model';
import { DispatchDetails } from '../models/dispatch-details.model';

@Injectable({
  providedIn: 'root'
})
export class InsuranceCoverService {
  private baseUrl = 'http://localhost:8080/api/insurance-cover';

  constructor(private http: HttpClient) {}

  // Insurance Cover Methods
  getCoverDetails(contractId: string): Observable<InsuranceCover> {
    return this.http.get<InsuranceCover>(`${this.baseUrl}/cover-details/${contractId}`);
  }

  saveCoverDetails(coverDetails: InsuranceCover): Observable<any> {
    return this.http.post(`${this.baseUrl}/cover-details`, coverDetails);
  }

  updateCoverDetails(coverDetails: InsuranceCover): Observable<any> {
    return this.http.put(`${this.baseUrl}/cover-details`, coverDetails);
  }

  deleteCoverDetails(contractId: string): Observable<any> {
    return this.http.delete(`${this.baseUrl}/cover-details/${contractId}`);
  }

  // Rider Methods
  getRiderDetails(contractId: string): Observable<Rider[]> {
    return this.http.get<Rider[]>(`${this.baseUrl}/rider-details/${contractId}`);
  }

  updateRiderDetails(riderDetails: Rider): Observable<any> {
    return this.http.put(`${this.baseUrl}/rider-details`, riderDetails);
  }

  // Reprint Methods
  addReprintToBucket(reprintRequest: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/reprint-bucket`, reprintRequest);
  }

  confirmReprintAction(confirmation: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/confirm-reprint`, confirmation);
  }

  // CI Radio Button Logic
  getSocialStatus(contractId: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/social-status/${contractId}`);
  }

  // QC Details Methods
  fetchQCDetails(contractId: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/qc-details/${contractId}`);
  }

  // Control Functionalities
  cancelOperation(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/cancel-operation`, data);
  }

  searchRecords(criteria: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/search-records`, criteria);
  }

  resetForm(policyRef: string): Observable<any> {
    return this.http.post(`${this.baseUrl}/reset-form`, { policyRef });
  }

  submitForm(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/submit-form`, data);
  }

  updateNominee(nominee: Nominee): Observable<any> {
    return this.http.put(`${this.baseUrl}/update-nominee`, nominee);
  }

  viewImages(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/view-images`, data);
  }

  enrichData(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/enrich-data`, data);
  }

  handleCheckboxes(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/handle-checkboxes`, data);
  }

  displayItems(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/display-items`, data);
  }

  skipOperation(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/skip-operation`, data);
  }

  manageComments(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/manage-comments`, data);
  }

  updatePolicyStatus(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/update-policy-status`, data);
  }

  trackQCProcess(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/track-qc-process`, data);
  }

  commitChanges(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/commit-changes`, data);
  }

  // Reason Of Skip Dropdown
  saveReasonOfSkip(reason: string, contractId: string, versionNumber: string, otherDetails: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/save-reason-of-skip`, { reason, contractId, versionNumber, otherDetails });
  }

  getReasonsOfSkip(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/reasons-of-skip`);
  }

  // Update Logic
  updateQCRecords(data: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/update-qc-records`, data);
  }

  // Nominee Information
  addNominee(nominee: Nominee): Observable<any> {
    return this.http.post(`${this.baseUrl}/add-nominee`, nominee);
  }

  getNominee(contractId: string): Observable<Nominee> {
    return this.http.get<Nominee>(`${this.baseUrl}/get-nominee/${contractId}`);
  }

  // Fund Details
  getFundDetails(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/fund-details`);
  }

  // Underwriting Comments
  fetchUnderwritingComments(policyNumber: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/underwriting-comments/${policyNumber}`);
  }

  manageUnderwritingComments(commentsData: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/manage-underwriting-comments`, commentsData);
  }

  // Dispatch Details
  saveDispatchDetails(dispatchDetails: DispatchDetails): Observable<any> {
    return this.http.post(`${this.baseUrl}/save-dispatch-details`, dispatchDetails);
  }

  getDispatchDetails(shipmentNumber: string): Observable<DispatchDetails> {
    return this.http.get<DispatchDetails>(`${this.baseUrl}/get-dispatch-details/${shipmentNumber}`);
  }

  // Vendor Details
  fetchVendorDetails(user: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/vendor-details/${user}`);
  }

  // Physical Copy Status
  updatePhysicalCopyStatus(physicalCopyStatus: string, policyNumber: string): Observable<any> {
    return this.http.put(`${this.baseUrl}/update-physical-copy-status`, { physicalCopyStatus, policyNumber });
  }

  // Submit Button
  handleSubmit(policyRef: string, userDetails: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/submit`, { policyRef, userDetails });
  }

  // Skip Reason
  handleSkipReason(reason: string, comments: string): Observable<any> {
    return this.http.post(`${this.baseUrl}/handle-skip-reason`, { reason, comments });
  }

  // View Documents
  viewDocument(policyRef: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/view-document/${policyRef}`);
  }
}
