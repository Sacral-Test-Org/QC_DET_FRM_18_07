import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-supervisor-id-input',
  templateUrl: './supervisor-id-input.component.html',
  styleUrls: ['./supervisor-id-input.component.css']
})
export class SupervisorIdInputComponent {
  supervisorIdForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.supervisorIdForm = this.fb.group({
      supervisorId: ['', [Validators.required, Validators.maxLength(10)]]
    });
  }

  onInputChange(event: any): void {
    const input = event.target.value.toUpperCase();
    this.supervisorIdForm.controls['supervisorId'].setValue(input, { emitEvent: false });
  }

  onInputBlur(): void {
    // Change visual attributes to indicate input acceptance
    const inputElement = document.getElementById('supervisorIdInput');
    if (inputElement) {
      inputElement.style.borderColor = 'green';
      inputElement.style.fontWeight = 'bold';
    }
  }
}