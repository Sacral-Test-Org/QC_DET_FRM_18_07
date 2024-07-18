import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { InsuranceCoverService } from '../../services/insurance-cover.service';
import { Rider } from '../../models/rider.model';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-rider-details',
  templateUrl: './rider-details.component.html',
  styleUrls: ['./rider-details.component.css']
})
export class RiderDetailsComponent implements OnInit {
  riderForm: FormGroup;
  riderDetails: Rider;

  constructor(
    private fb: FormBuilder,
    private insuranceCoverService: InsuranceCoverService,
    private logger: NGXLogger
  ) {}

  ngOnInit(): void {
    this.initializeForm();
    this.getRiderDetails();
  }

  private initializeForm(): void {
    this.riderForm = this.fb.group({
      coverCode: ['', Validators.required],
      sumInsuredWholeCover: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      benefitTerm: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      premiumTerm: ['', [Validators.required, Validators.pattern('^[0-9]*$')]]
    });
  }

  private getRiderDetails(): void {
    this.insuranceCoverService.getRiderDetails().subscribe(
      (data: Rider) => {
        this.riderDetails = data;
        this.riderForm.patchValue(this.riderDetails);
      },
      error => {
        this.logger.error('Error fetching rider details', error);
      }
    );
  }

  saveRiderDetails(): void {
    if (this.riderForm.valid) {
      const updatedRiderDetails: Rider = this.riderForm.value;
      this.insuranceCoverService.updateRiderDetails(updatedRiderDetails).subscribe(
        response => {
          this.logger.info('Rider details updated successfully', response);
        },
        error => {
          this.logger.error('Error updating rider details', error);
        }
      );
    } else {
      this.logger.warn('Rider form is invalid');
    }
  }
}