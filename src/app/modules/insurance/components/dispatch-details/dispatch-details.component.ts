import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { InsuranceCoverService } from '../../services/insurance-cover.service';
import { DispatchDetailsModel } from '../../models/dispatch-details.model';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-dispatch-details',
  templateUrl: './dispatch-details.component.html',
  styleUrls: ['./dispatch-details.component.css']
})
export class DispatchDetailsComponent implements OnInit {
  dispatchForm: FormGroup;
  deliveryTypes = ['CUST', 'VEND', 'OTH'];
  destinationTypes = ['CUST', 'VEND', 'OTH'];
  weightUnits = ['Grm', 'Kg'];

  constructor(
    private fb: FormBuilder,
    private insuranceCoverService: InsuranceCoverService,
    private logger: NGXLogger
  ) {}

  ngOnInit(): void {
    this.dispatchForm = this.fb.group({
      shipNo: ['', Validators.required],
      awbNo: ['', Validators.required],
      delType: ['CUST', Validators.required],
      vendor: ['', Validators.required],
      desType: ['CUST', Validators.required],
      pickReqNo: ['', Validators.required],
      prRef: [{ value: '', disabled: true }],
      consigneeName: [{ value: '', disabled: true }],
      conAdd1: [{ value: '', disabled: true }],
      conAdd2: [{ value: '', disabled: true }],
      conAdd3: [{ value: '', disabled: true }],
      conCity: [{ value: '', disabled: true }],
      conState: [{ value: '', disabled: true }],
      desPin: [{ value: '', disabled: true }],
      wt: ['', Validators.required],
      gm: ['Grm', Validators.required],
      venCode: [{ value: '', disabled: true }]
    });

    this.loadDispatchDetails();
  }

  loadDispatchDetails(): void {
    this.insuranceCoverService.getDispatchDetails().subscribe(
      (data: DispatchDetailsModel) => {
        this.dispatchForm.patchValue(data);
      },
      error => {
        this.logger.error('Error loading dispatch details', error);
      }
    );
  }

  saveDispatchDetails(): void {
    if (this.dispatchForm.valid) {
      const dispatchDetails: DispatchDetailsModel = this.dispatchForm.getRawValue();
      this.insuranceCoverService.saveDispatchDetails(dispatchDetails).subscribe(
        response => {
          this.logger.info('Dispatch details saved successfully', response);
        },
        error => {
          this.logger.error('Error saving dispatch details', error);
        }
      );
    }
  }

  handleCheckboxChange(event: any): void {
    if (event.target.checked) {
      this.fetchDispatchDetails();
    } else {
      this.clearDispatchDetails();
    }
  }

  fetchDispatchDetails(): void {
    const policyRef = this.dispatchForm.get('shipNo').value;
    this.insuranceCoverService.getDispatchDetailsByPolicyRef(policyRef).subscribe(
      (data: DispatchDetailsModel) => {
        this.dispatchForm.patchValue({
          ...data,
          shipNo: `101${policyRef}`,
          prRef: 'POLICY BOND',
          wt: 100,
          delType: 'I',
          desType: 'CUST',
          gm: 'Grm'
        });
      },
      error => {
        this.logger.error('Error fetching dispatch details', error);
      }
    );
  }

  clearDispatchDetails(): void {
    this.dispatchForm.reset({
      delType: '',
      desType: '',
      gm: ''
    });
  }
}
