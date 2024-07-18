import { Component } from '@angular/core';
import { InsuranceCoverService } from '../../services/insurance-cover.service';
import { NgxLoggerLevel, LoggerService } from 'ngx-logger';

@Component({
  selector: 'app-physical-copy-reprint',
  templateUrl: './physical-copy-reprint.component.html',
  styleUrls: ['./physical-copy-reprint.component.css']
})
export class PhysicalCopyReprintComponent {
  physicalCopyStatus: string = '';
  policyRef: string = '';

  constructor(private insuranceCoverService: InsuranceCoverService, private logger: LoggerService) {}

  moveToPrintingBucket(): void {
    this.insuranceCoverService.addReprintToBucket().subscribe(
      response => {
        this.logger.log(NgxLoggerLevel.INFO, 'Reprint request added to the printing bucket successfully.');
      },
      error => {
        this.logger.log(NgxLoggerLevel.ERROR, 'Error adding reprint request to the printing bucket.', error);
      }
    );
  }

  confirmAction(): void {
    this.insuranceCoverService.confirmReprintAction().subscribe(
      response => {
        this.logger.log(NgxLoggerLevel.INFO, 'Reprint action confirmed successfully.');
      },
      error => {
        this.logger.log(NgxLoggerLevel.ERROR, 'Error confirming reprint action.', error);
      }
    );
  }

  handleOkButtonPress(): void {
    if (this.physicalCopyStatus === 'Y' || this.physicalCopyStatus === 'N') {
      this.insuranceCoverService.updatePhysicalCopyStatus(this.physicalCopyStatus, this.policyRef).subscribe(
        response => {
          this.clearForm();
          this.setFocusToPolicyRef();
          this.logger.log(NgxLoggerLevel.INFO, 'Physical copy status updated successfully.');
        },
        error => {
          this.logger.log(NgxLoggerLevel.WARN, 'Data Not Updated.', error);
        }
      );
    } else {
      this.logger.log(NgxLoggerLevel.ERROR, 'Choose any one of the above options.');
    }
  }

  handleRadioButtonChange(event: any): void {
    if (event.target.value === 'PHY_MOVE') {
      this.insuranceCoverService.updatePhysicalCopyStatus('PHY_MOVE', this.policyRef).subscribe(
        response => {
          this.logger.log(NgxLoggerLevel.INFO, 'Physical copy status updated to PHY_MOVE.');
        },
        error => {
          this.logger.log(NgxLoggerLevel.ERROR, 'Error updating physical copy status to PHY_MOVE.', error);
        }
      );
    }
  }

  validateFields(data: any): boolean {
    const requiredFields = ['CONTRACT_ID', 'VERSION_NO', 'OBJECT_ID', 'ACTION_CODE', 'TOP_INDICATOR', 'PARTITION_NO', 'COVER_CODE', 'COVER_NO'];
    for (const field of requiredFields) {
      if (!data[field]) {
        this.logger.log(NgxLoggerLevel.ERROR, `Validation failed: ${field} is mandatory.`);
        return false;
      }
    }
    return true;
  }

  private clearForm(): void {
    this.physicalCopyStatus = '';
    this.policyRef = '';
  }

  private setFocusToPolicyRef(): void {
    const policyRefElement = document.getElementById('policyRef');
    if (policyRefElement) {
      policyRefElement.focus();
    }
  }
}
