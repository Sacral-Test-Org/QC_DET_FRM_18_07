// src/app/modules/insurance/components/control/control.component.ts

import { Component } from '@angular/core';
import { InsuranceCoverService } from '../../services/insurance-cover.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-control',
  templateUrl: './control.component.html',
  styleUrls: ['./control.component.css']
})
export class ControlComponent {
  constructor(private insuranceCoverService: InsuranceCoverService, private router: Router) {}

  cancelOperation() {
    // Logic for cancel operation
    console.log('Operation cancelled');
  }

  searchRecords() {
    this.insuranceCoverService.updateQcStatus().subscribe(() => {
      this.resetForm();
    });
  }

  resetForm() {
    this.insuranceCoverService.resetQCStatus().subscribe(() => {
      // Logic to clear the form and enable the submit button
      console.log('Form reset and submit button enabled');
    });
  }

  submitForm() {
    // Logic for submit form
    console.log('Form submitted');
  }

  updateNominee() {
    // Logic for updating nominee information
    console.log('Nominee information updated');
  }

  viewImages() {
    // Logic for viewing images
    console.log('Viewing images');
  }

  enrichData() {
    // Logic for enriching data
    console.log('Data enriched');
  }

  handleCheckboxes(event: any) {
    const checkboxId = event.target.id;
    if (event.target.checked) {
      switch (checkboxId) {
        case 'CH1':
        case 'CH2':
        case 'CH3':
        case 'CH4':
        case 'CH5':
        case 'CH6':
        case 'CH7':
        case 'CH8':
        case 'CH9':
        case 'CH10':
        case 'CH27':
        case 'CH28':
          this.navigateToQCBlock();
          this.updateQCBlockRecords();
          break;
        default:
          break;
      }
    }
  }

  displayItems() {
    // Logic for displaying items
    console.log('Displaying items');
  }

  skipOperation() {
    // Logic for skip operation
    console.log('Operation skipped');
  }

  manageComments() {
    // Logic for managing comments
    console.log('Managing comments');
  }

  updatePolicyStatus() {
    // Logic for updating policy status
    console.log('Policy status updated');
  }

  trackQCProcess() {
    // Logic for tracking QC process
    console.log('QC process tracked');
  }

  commitChanges() {
    // Logic for committing changes
    console.log('Changes committed');
  }

  onCheckboxChange(event: any) {
    this.handleCheckboxes(event);
  }

  onResetButtonClick() {
    this.resetForm();
  }

  onSearchButtonClick() {
    this.searchRecords();
  }

  handleExitButtonClick() {
    this.hideUWCommentsView();
    this.showQCView();
    this.navigateToQCBlock();
  }

  private navigateToQCBlock() {
    this.router.navigate(['/qc-block']);
  }

  private updateQCBlockRecords() {
    this.insuranceCoverService.updateQCBlockRecords().subscribe(() => {
      // Logic to handle the response
      console.log('QC block records updated');
    });
  }

  private hideUWCommentsView() {
    // Logic to hide the UW_COMMENTS view
    console.log('UW_COMMENTS view hidden');
  }

  private showQCView() {
    // Logic to show the QC view
    console.log('QC view shown');
  }
}
