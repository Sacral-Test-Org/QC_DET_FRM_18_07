import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthenticationService } from '../../services/authentication.service';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.css']
})
export class AuthenticationComponent {
  authForm: FormGroup;
  authMessage: string = '';

  constructor(
    private fb: FormBuilder,
    private authService: AuthenticationService,
    private logger: NGXLogger
  ) {
    this.authForm = this.fb.group({
      supervisorId: ['', [Validators.required, Validators.maxLength(10), Validators.pattern('^[A-Z]*$')]],
      password: ['', [Validators.required, Validators.maxLength(10)]],
      comments: ['', [Validators.maxLength(500)]]
    });
  }

  authenticateUser() {
    const supervisorId = this.authForm.get('supervisorId')?.value;
    const password = this.authForm.get('password')?.value;

    this.authService.authenticate(supervisorId, password).subscribe(
      response => {
        if (response.success) {
          this.authMessage = 'Authentication successful!';
          this.logger.info('User authenticated successfully.');
        } else {
          this.authMessage = 'Authentication failed. Please check your credentials.';
          this.logger.warn('Authentication failed for user: ' + supervisorId);
        }
      },
      error => {
        this.authMessage = 'An error occurred during authentication. Please try again later.';
        this.logger.error('Authentication error: ', error);
      }
    );
  }

  handlePasswordInput(event: Event) {
    const inputElement = event.target as HTMLInputElement;
    inputElement.style.borderColor = 'green'; // Example visual attribute
  }

  handleCommentsField() {
    const commentsField = this.authForm.get('comments');
    if (commentsField?.value.length > 0) {
      commentsField.setErrors(null);
    }
  }
}