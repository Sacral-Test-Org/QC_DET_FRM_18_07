import { Component } from '@angular/core';
import { QcService } from '../../services/qc.service'; // Assuming there's a service to handle QC logic
import { Router } from '@angular/router';

@Component({
  selector: 'app-qc-submit',
  templateUrl: './qc-submit.component.html',
  styleUrls: ['./qc-submit.component.css']
})
export class QcSubmitComponent {

  constructor(private qcService: QcService, private router: Router) {}

  onSubmit() {
    // Check if the policy reference number is provided
    if (!this.qcService.policyRef) {
      alert('Policy reference number is required.');
      return;
    }

    // Determine if the user is a bot
    const isBotUser = this.qcService.isBotUser();

    // Count the number of QC status details for the given policy
    this.qcService.countQcStatusDetails(this.qcService.policyRef).subscribe(count => {
      if (count === 0) {
        // Retrieve and insert relevant data from the policy tracker
        this.qcService.retrieveAndInsertPolicyTrackerData(this.qcService.policyRef).subscribe(() => {
          this.processQcDetails();
        });
      } else {
        this.processQcDetails();
      }
    });
  }

  private processQcDetails() {
    // Loop through nominee records and insert QC details
    this.qcService.processNomineeRecords(this.qcService.policyRef).subscribe(nomineeErrors => {
      // Loop through QC records and insert QC details
      this.qcService.processQcRecords(this.qcService.policyRef).subscribe(qcErrors => {
        // Determine the overall QC status
        const overallStatus = nomineeErrors.length === 0 && qcErrors.length === 0 ? 'PASS' : 'FAIL';

        if (overallStatus === 'PASS') {
          // Handle reprint approvals
          this.qcService.handleReprintApprovals(this.qcService.policyRef).subscribe(() => {
            this.finalizeQcStatus(overallStatus);
          });
        } else {
          // Determine sub-status and handle supervisor approval if required
          this.qcService.handleFailStatus(this.qcService.policyRef).subscribe(() => {
            this.finalizeQcStatus(overallStatus);
          });
        }
      });
    });
  }

  private finalizeQcStatus(status: string) {
    // Update the QC status in various tables and log the actions
    this.qcService.updateQcStatus(this.qcService.policyRef, status).subscribe(() => {
      // Handle special conditions for rural areas and bot users
      this.qcService.handleSpecialConditions(this.qcService.policyRef).subscribe(() => {
        // Commit the transaction and clear the form
        this.qcService.commitTransaction().subscribe(() => {
          alert('QC process completed successfully.');
          this.router.navigate(['/home']); // Redirect to home or another appropriate page
        });
      });
    });
  }
}
