import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { InsuranceCoverService } from '../../services/insurance-cover.service';
import { InsuranceCover } from '../../models/insurance-cover.model';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-insurance-cover-details',
  templateUrl: './insurance-cover-details.component.html',
  styleUrls: ['./insurance-cover-details.component.css']
})
export class InsuranceCoverDetailsComponent implements OnInit {
  coverDetailsForm: FormGroup;
  coverDetails: InsuranceCover;

  constructor(
    private fb: FormBuilder,
    private insuranceCoverService: InsuranceCoverService,
    private logger: NGXLogger
  ) {}

  ngOnInit(): void {
    this.initializeForm();
    this.fetchCoverDetails();
  }

  private initializeForm(): void {
    this.coverDetailsForm = this.fb.group({
      contractId: ['', Validators.required],
      versionNo: ['', Validators.required],
      objectId: ['', Validators.required],
      actionCode: ['', Validators.required],
      topIndicator: ['', Validators.required],
      partitionNo: ['', Validators.required],
      coverCode: ['', Validators.required],
      coverNo: ['', Validators.required],
      previousVersion: [''],
      reversingVersion: [''],
      sumInsuredWholeCover: ['', Validators.required],
      sumInsuredCompanyShare: ['', Validators.required],
      fullTermPremiumWholeCover: ['', Validators.required],
      fullTermPremiumCompanyShare: ['', Validators.required],
      agentCommissionWholeCover: ['', Validators.required],
      agentCommissionCompanyShare: ['', Validators.required],
      sharePortion: ['', Validators.required],
      cvcCode: ['', Validators.required],
      surchargeDiscount: ['', Validators.required],
      reinsurableRiskAmount: ['', Validators.required],
      pcovContractId: ['', Validators.required],
      pcovPartitionNo: ['', Validators.required],
      pcovCoverCode: ['', Validators.required],
      pcovCoverNo: ['', Validators.required]
    });
  }

  private fetchCoverDetails(): void {
    this.insuranceCoverService.getCoverDetails().subscribe(
      (data: InsuranceCover) => {
        this.coverDetails = data;
        this.coverDetailsForm.patchValue(this.coverDetails);
      },
      (error) => {
        this.logger.error('Error fetching cover details', error);
      }
    );
  }

  saveCoverDetails(): void {
    if (this.coverDetailsForm.invalid) {
      this.logger.warn('Form is invalid');
      return;
    }

    const newCoverDetails: InsuranceCover = this.coverDetailsForm.value;
    this.insuranceCoverService.saveCoverDetails(newCoverDetails).subscribe(
      (response) => {
        this.logger.info('Cover details saved successfully', response);
      },
      (error) => {
        this.logger.error('Error saving cover details', error);
      }
    );
  }

  updateCoverDetails(): void {
    if (this.coverDetailsForm.invalid) {
      this.logger.warn('Form is invalid');
      return;
    }

    const updatedCoverDetails: InsuranceCover = this.coverDetailsForm.value;
    this.insuranceCoverService.updateCoverDetails(updatedCoverDetails).subscribe(
      (response) => {
        this.logger.info('Cover details updated successfully', response);
      },
      (error) => {
        this.logger.error('Error updating cover details', error);
      }
    );
  }
}
