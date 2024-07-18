import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { InsuranceCoverService } from '../../services/insurance-cover.service';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-underwriting-comments',
  templateUrl: './underwriting-comments.component.html',
  styleUrls: ['./underwriting-comments.component.css']
})
export class UnderwritingCommentsComponent implements OnInit {
  policyNumber: string;
  userProfile: string;
  comments: any[] = [];
  isSupervisor: boolean = false;
  showUserIdField: boolean = true;

  constructor(
    private insuranceCoverService: InsuranceCoverService,
    private router: Router,
    private logger: NGXLogger
  ) {}

  ngOnInit(): void {
    this.fetchUserProfile();
  }

  fetchUserProfile(): void {
    this.insuranceCoverService.getUserProfile().subscribe(
      (profile) => {
        this.userProfile = profile;
        this.isSupervisor = this.checkIfSupervisor(profile);
        this.showUserIdField = this.shouldShowUserIdField(profile);
      },
      (error) => {
        this.logger.error('Error fetching user profile', error);
      }
    );
  }

  fetchComments(): void {
    if (!this.policyNumber) {
      alert('Please enter a policy number.');
      return;
    }

    this.insuranceCoverService.getUnderwritingComments(this.policyNumber).subscribe(
      (comments) => {
        if (comments.length === 0) {
          alert('No UW comments found for the specified policy number.');
          this.router.navigate(['/qc']);
        } else {
          this.comments = this.formatComments(comments);
        }
      },
      (error) => {
        this.logger.error('Error fetching underwriting comments', error);
      }
    );
  }

  formatComments(comments: any[]): any[] {
    return comments.map(comment => {
      comment.uw_comments = comment.uw_comments.replace(/[\r\n]+/g, ', ');
      return comment;
    });
  }

  checkIfSupervisor(profile: string): boolean {
    return profile.startsWith('P00') || profile.startsWith('UU');
  }

  shouldShowUserIdField(profile: string): boolean {
    return !profile.startsWith('P00') && !profile.startsWith('UU');
  }

  saveComments(commentsData: any): void {
    this.insuranceCoverService.manageUnderwritingComments(commentsData).subscribe(
      () => {
        alert('Comments saved successfully.');
      },
      (error) => {
        this.logger.error('Error saving underwriting comments', error);
      }
    );
  }

  hideUWCommentsView(): void {
    // Logic to hide the UW_COMMENTS view
    this.router.navigate(['/qc']);
  }
}
