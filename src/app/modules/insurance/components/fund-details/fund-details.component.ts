import { Component, OnInit } from '@angular/core';
import { InsuranceCoverService } from '../../services/insurance-cover.service';
import { FundDetail } from '../../models/fund-detail.model';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-fund-details',
  templateUrl: './fund-details.component.html',
  styleUrls: ['./fund-details.component.css']
})
export class FundDetailsComponent implements OnInit {
  fundDetails: FundDetail[] = [];
  displayedColumns: string[] = ['fundId', 'fundDescription', 'apportionment'];

  constructor(
    private insuranceCoverService: InsuranceCoverService,
    private logger: NGXLogger
  ) {}

  ngOnInit(): void {
    this.fetchFundDetails();
  }

  fetchFundDetails(): void {
    this.insuranceCoverService.getFundDetails().subscribe(
      (data: FundDetail[]) => {
        this.fundDetails = data;
        this.logger.info('Fund details fetched successfully');
      },
      (error) => {
        this.logger.error('Error fetching fund details', error);
      }
    );
  }

  addFundDetails(fundDetail: FundDetail): void {
    this.insuranceCoverService.addFundDetail(fundDetail).subscribe(
      (data: FundDetail) => {
        this.fundDetails.push(data);
        this.logger.info('Fund detail added successfully');
      },
      (error) => {
        this.logger.error('Error adding fund detail', error);
      }
    );
  }

  updateFundDetails(fundDetail: FundDetail): void {
    this.insuranceCoverService.updateFundDetail(fundDetail).subscribe(
      (data: FundDetail) => {
        const index = this.fundDetails.findIndex(fd => fd.fundId === data.fundId);
        if (index !== -1) {
          this.fundDetails[index] = data;
        }
        this.logger.info('Fund detail updated successfully');
      },
      (error) => {
        this.logger.error('Error updating fund detail', error);
      }
    );
  }
}
