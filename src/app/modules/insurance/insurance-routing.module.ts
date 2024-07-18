// src/app/modules/insurance/insurance-routing.module.ts

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
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

const routes: Routes = [
  { path: 'rider-details', component: RiderDetailsComponent },
  { path: 'physical-copy-reprint', component: PhysicalCopyReprintComponent },
  { path: 'qc-data', component: QCDataComponent },
  { path: 'control', component: ControlComponent },
  { path: 'reason-of-skip', component: ReasonOfSkipComponent },
  { path: 'authentication', component: AuthenticationComponent },
  { path: 'supervisor-id-input', component: SupervisorIdInputComponent },
  { path: 'nominee-information', component: NomineeInformationComponent },
  { path: 'fund-details', component: FundDetailsComponent },
  { path: 'underwriting-comments', component: UnderwritingCommentsComponent },
  { path: 'dispatch-details', component: DispatchDetailsComponent },
  { path: 'vendor-selection', component: VendorSelectionComponent },
  { path: 'submit', component: ControlComponent }, // Assuming 'submit' is handled by ControlComponent
  { path: 'qc-block', component: QCDataComponent } // Assuming QC block is handled by QCDataComponent
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class InsuranceRoutingModule { }
