import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { InsuranceCoverService } from '../../services/insurance-cover.service';
import { Router } from '@angular/router';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-qc-data',
  templateUrl: './qc-data.component.html',
  styleUrls: ['./qc-data.component.css']
})
export class QcDataComponent implements OnInit {
  qcForm: FormGroup;
  currentRecordIndex: number = 0;
  qcData: any[] = []; // This should be populated with the actual QC data

  constructor(
    private fb: FormBuilder,
    private insuranceCoverService: InsuranceCoverService,
    private router: Router,
    private logger: NGXLogger
  ) {
    this.qcForm = this.fb.group({
      FLG: [''],
      DESC: [{ value: '', disabled: true }],
      OPUSVAL: [{ value: '', disabled: true }],
      CI: ['N'],
      SCAN_DATE: [''],
      INS_DT: [''],
      FLG1: [''],
      MIS_USER: ['']
    });
  }

  ngOnInit(): void {
    this.loadQCData();
  }

  loadQCData(): void {
    // Load QC data from the service
    this.insuranceCoverService.getQCData().subscribe(data => {
      this.qcData = data;
      this.updateForm();
    });
  }

  updateForm(): void {
    if (this.qcData.length > 0) {
      this.qcForm.patchValue(this.qcData[this.currentRecordIndex]);
    }
  }

  handleKeyDown(event: KeyboardEvent): void {
    if (event.key === 'ArrowDown') {
      this.navigateToNextRecord();
    }
  }

  navigateToNextRecord(): void {
    if (this.currentRecordIndex === this.qcData.length - 1) {
      this.currentRecordIndex = 0;
    } else {
      this.currentRecordIndex++;
    }
    this.updateForm();
  }

  onCIRadioButtonChange(event: any): void {
    const ciValue = event.target.value;
    const flgValue = this.qcForm.get('FLG')?.value;

    if (ciValue === 'N') {
      if (flgValue === 10) {
        alert('Please select the error category first.');
        this.qcForm.get('CH1')?.setValue('Y');
        return;
      } else if (flgValue === 3) {
        this.insuranceCoverService.getSocialStatus().subscribe(status => {
          if (status.startsWith('R')) {
            alert('Do not fail the print QC if the pronunciation is the same even if the spelling is different.');
          }
        });
      } else if (flgValue === 11) {
        alert('Please select the error category first.');
        this.qcForm.get('CH6')?.setValue('Y');
        return;
      }
    } else if (ciValue === 'Y') {
      if (flgValue === 10) {
        this.qcForm.patchValue({
          CH1: 'N',
          CH2: 'N',
          CH3: 'N',
          CH4: 'N',
          CH5: 'N',
          CH27: 'N'
        });
      } else if (flgValue === 11) {
        this.qcForm.patchValue({
          CH6: 'N',
          CH7: 'N',
          CH8: 'N',
          CH9: 'N',
          CH10: 'N',
          CH28: 'N'
        });
      }
    }
  }

  updateQCRecords(): void {
    this.insuranceCoverService.updateQCRecords(this.qcForm.value).subscribe(response => {
      this.logger.info('QC records updated successfully.');
    });
  }

  navigateToQCBlock(): void {
    this.router.navigate(['/qc-block']);
  }

  showQCView(): void {
    // Logic to make the QC view visible
    document.getElementById('qc-view')?.classList.remove('hidden');
  }

  onExitButtonClick(): void {
    try {
      this.navigateToQCBlock();
      this.showQCView();
    } catch (error) {
      this.logger.error('Error navigating to QC block:', error);
    }
  }
}
