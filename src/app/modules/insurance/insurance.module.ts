import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import { InsuranceRoutingModule } from './insurance-routing.module';
import { RiderDetailsComponent } from './components/rider-details/rider-details.component';
import { PhysicalCopyReprintComponent } from './components/physical-copy-reprint/physical-copy-reprint.component';
import { QCDataComponent } from './components/qc-data/qc-data.component';
import { ControlComponent } from './components/control/control.component';
import { ReasonOfSkipComponent } from './components/reason-of-skip/reason-of-skip.component';
import { AuthenticationComponent } from './components/authentication/authentication.component';
import { SupervisorIdInputComponent } from './components/supervisor-id-input/supervisor-id-input.component';
import { NomineeInformationComponent } from './components/nominee-information/nominee-information.component';
import { FundDetailsComponent } from './components/fund-details/fund-details.component';
import { UnderwritingCommentsComponent } from './components/underwriting-comments/underwriting-comments.component';
import { DispatchDetailsComponent } from './components/dispatch-details/dispatch-details.component';
import { VendorSelectionComponent } from './components/vendor-selection/vendor-selection.component';

@NgModule({
  declarations: [
    RiderDetailsComponent,
    PhysicalCopyReprintComponent,
    QCDataComponent,
    ControlComponent,
    ReasonOfSkipComponent,
    AuthenticationComponent,
    SupervisorIdInputComponent,
    NomineeInformationComponent,
    FundDetailsComponent,
    UnderwritingCommentsComponent,
    DispatchDetailsComponent,
    VendorSelectionComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    InsuranceRoutingModule
  ],
  entryComponents: [
    RiderDetailsComponent,
    PhysicalCopyReprintComponent,
    QCDataComponent,
    ControlComponent,
    ReasonOfSkipComponent,
    AuthenticationComponent,
    SupervisorIdInputComponent,
    NomineeInformationComponent,
    FundDetailsComponent,
    UnderwritingCommentsComponent,
    DispatchDetailsComponent,
    VendorSelectionComponent
  ]
})
export class InsuranceModule { }
