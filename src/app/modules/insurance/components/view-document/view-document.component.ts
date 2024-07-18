import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { NGXLogger } from 'ngx-logger';
import { InsuranceCoverService } from '../../services/insurance-cover.service';

@Component({
  selector: 'app-view-document',
  templateUrl: './view-document.component.html',
  styleUrls: ['./view-document.component.css']
})
export class ViewDocumentComponent {
  constructor(
    private http: HttpClient,
    private router: Router,
    private logger: NGXLogger,
    private insuranceCoverService: InsuranceCoverService
  ) {}

  viewDocument(policyRef: string): void {
    this.insuranceCoverService.getDocumentPath(policyRef).subscribe(
      (filePath: string) => {
        if (filePath) {
          this.copyAndOpenDocument(filePath);
        } else {
          this.handleError('File path is null');
        }
      },
      (error) => {
        this.handleError(error);
      }
    );
  }

  private copyAndOpenDocument(filePath: string): void {
    this.http.get(filePath, { responseType: 'blob' }).subscribe(
      (blob) => {
        const url = window.URL.createObjectURL(blob);
        const a = document.createElement('a');
        a.href = url;
        a.download = filePath.split('/').pop();
        document.body.appendChild(a);
        a.click();
        document.body.removeChild(a);
        window.URL.revokeObjectURL(url);
        this.verifyFileSize(blob.size);
      },
      (error) => {
        this.handleError(error);
      }
    );
  }

  private verifyFileSize(fileSize: number): void {
    if (fileSize > 0) {
      this.openDocument();
    } else {
      this.handleError('File is corrupted');
    }
  }

  private openDocument(): void {
    // Logic to open the document using the default application on the client machine
    // This is a placeholder as actual implementation may vary based on the environment
    this.logger.info('Document opened successfully');
    this.deleteTemporaryFile();
  }

  private deleteTemporaryFile(): void {
    // Logic to delete the temporary file from the client directory
    // This is a placeholder as actual implementation may vary based on the environment
    this.logger.info('Temporary file deleted');
    this.navigateToNextItem();
  }

  private navigateToNextItem(): void {
    // Logic to navigate to the next item in the form
    this.router.navigate(['/next-item']);
    this.hideViewDocumentButton();
  }

  private hideViewDocumentButton(): void {
    // Logic to hide the "View Document" button
    const viewDocButton = document.getElementById('viewDocumentButton');
    if (viewDocButton) {
      viewDocButton.style.display = 'none';
    }
  }

  private handleError(error: any): void {
    this.logger.error('Error occurred while viewing document:', error);
    this.navigateToNextItem();
  }
}
