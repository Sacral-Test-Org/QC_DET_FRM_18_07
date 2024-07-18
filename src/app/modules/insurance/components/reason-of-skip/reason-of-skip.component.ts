import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { InsuranceCoverService } from '../../services/insurance-cover.service';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-reason-of-skip',
  templateUrl: './reason-of-skip.component.html',
  styleUrls: ['./reason-of-skip.component.css']
})
export class ReasonOfSkipComponent implements OnInit {
  reasonOfSkipForm: FormGroup;
  reasons: string[] = [];

  constructor(
    private fb: FormBuilder,
    private insuranceCoverService: InsuranceCoverService,
    private logger: NGXLogger
  ) {
    this.reasonOfSkipForm = this.fb.group({
      reason: ['', Validators.required],
      comments: ['']
    });
  }

  ngOnInit(): void {
    this.fetchReasonsOfSkip();
  }

  fetchReasonsOfSkip(): void {
    this.insuranceCoverService.getReasonsOfSkip().subscribe(
      (data: string[]) => {
        this.reasons = data;
        this.logger.info('Fetched reasons of skip successfully');
      },
      (error) => {
        this.logger.error('Error fetching reasons of skip', error);
      }
    );
  }

  onSave(): void {
    if (this.reasonOfSkipForm.invalid) {
      this.logger.warn('Form is invalid');
      return;
    }

    const reason = this.reasonOfSkipForm.get('reason')?.value;
    const comments = this.reasonOfSkipForm.get('comments')?.value;

    this.insuranceCoverService.saveReasonOfSkip(reason, comments).subscribe(
      () => {
        this.logger.info('Reason of skip saved successfully');
      },
      (error) => {
        this.logger.error('Error saving reason of skip', error);
      }
    );
  }

  handleSkip(): void {
    const reason = this.reasonOfSkipForm.get('reason')?.value;
    const comments = this.reasonOfSkipForm.get('comments')?.value;

    if (!reason) {
      this.logger.warn('Please Select Reason For Skipping Application');
      alert('Please Select Reason For Skipping Application');
      return;
    }

    if (reason === 'OTHERS' && !comments) {
      this.logger.warn('Please Enter comments');
      alert('Please Enter comments');
      return;
    }

    this.insuranceCoverService.handleSkipReason(reason, comments).subscribe(
      () => {
        this.logger.info('Handled skip reason successfully');
      },
      (error) => {
        this.logger.error('Error handling skip reason', error);
      }
    );
  }
}
