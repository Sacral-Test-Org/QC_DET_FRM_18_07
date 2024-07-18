import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Nominee } from '../../models/nominee.model';
import { InsuranceCoverService } from '../../services/insurance-cover.service';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-nominee-information',
  templateUrl: './nominee-information.component.html',
  styleUrls: ['./nominee-information.component.css']
})
export class NomineeInformationComponent implements OnInit {
  nomineeForm: FormGroup;
  nominee: Nominee;

  constructor(
    private fb: FormBuilder,
    private insuranceCoverService: InsuranceCoverService,
    private logger: NGXLogger
  ) {}

  ngOnInit(): void {
    this.initializeForm();
    this.getNomineeInformation();
  }

  initializeForm(): void {
    this.nomineeForm = this.fb.group({
      misUser: [''],
      scanDate: ['', Validators.required],
      flag: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      insertDate: ['', Validators.required],
      flag1: [''],
      description: [{ value: '', disabled: true }],
      opusValue: [{ value: '', disabled: true }],
      ciNominee: ['N']
    });
  }

  getNomineeInformation(): void {
    this.insuranceCoverService.getNominee().subscribe(
      (data: Nominee) => {
        this.nominee = data;
        this.nomineeForm.patchValue(this.nominee);
      },
      error => {
        this.logger.error('Error fetching nominee information', error);
      }
    );
  }

  addNominee(): void {
    if (this.nomineeForm.valid) {
      const newNominee: Nominee = this.nomineeForm.getRawValue();
      this.insuranceCoverService.addNominee(newNominee).subscribe(
        response => {
          this.logger.info('Nominee added successfully', response);
        },
        error => {
          this.logger.error('Error adding nominee', error);
        }
      );
    }
  }

  updateNominee(): void {
    if (this.nomineeForm.valid) {
      const updatedNominee: Nominee = this.nomineeForm.getRawValue();
      this.insuranceCoverService.updateNominee(updatedNominee).subscribe(
        response => {
          this.logger.info('Nominee updated successfully', response);
        },
        error => {
          this.logger.error('Error updating nominee', error);
        }
      );
    }
  }
}
