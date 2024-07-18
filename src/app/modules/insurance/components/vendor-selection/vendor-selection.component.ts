import { Component } from '@angular/core';
import { InsuranceCoverService } from '../../services/insurance-cover.service';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-vendor-selection',
  templateUrl: './vendor-selection.component.html',
  styleUrls: ['./vendor-selection.component.css']
})
export class VendorSelectionComponent {
  vendors: any[] = [];
  selectedVendor: any = null;

  constructor(private insuranceCoverService: InsuranceCoverService, private logger: NGXLogger) {}

  onDoubleClick(): void {
    this.logger.debug('Vendor field double-clicked');
    this.fetchVendors();
  }

  fetchVendors(): void {
    this.insuranceCoverService.fetchVendorDetails().subscribe(
      (data: any[]) => {
        this.vendors = data;
        this.logger.debug('Vendors fetched successfully', data);
      },
      (error) => {
        this.logger.error('Error fetching vendors', error);
      }
    );
  }

  selectVendor(vendor: any): void {
    this.selectedVendor = vendor;
    this.logger.debug('Vendor selected', vendor);
  }
}
