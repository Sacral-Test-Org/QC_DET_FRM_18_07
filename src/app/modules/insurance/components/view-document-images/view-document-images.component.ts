import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { of } from 'rxjs';

@Component({
  selector: 'app-view-document-images',
  templateUrl: './view-document-images.component.html',
  styleUrls: ['./view-document-images.component.css']
})
export class ViewDocumentImagesComponent {

  constructor(private http: HttpClient) {}

  viewImages() {
    const v_appln_no = 'some_application_no'; // Replace with actual application number
    const pol_ref = 'some_policy_reference'; // Replace with actual policy reference

    this.retrieveSolutionId(v_appln_no, pol_ref).subscribe(v_sol_id => {
      if (v_sol_id) {
        this.retrieveContractId(v_sol_id).subscribe(v_parent_cont_id => {
          if (v_parent_cont_id) {
            this.retrievePolicyNumber(v_parent_cont_id).subscribe(v_pol_no => {
              this.logInformation(pol_ref, v_sol_id, v_parent_cont_id, v_pol_no);
              this.generateUrl(v_pol_no || pol_ref).subscribe(v_url => {
                if (v_url) {
                  window.open(v_url, '_blank');
                } else {
                  this.displayErrorMessage('URL generation failed');
                }
              });
            });
          }
        });
      }
    });
  }

  retrieveSolutionId(v_appln_no: string, pol_ref: string) {
    const query = `
      SELECT solution_id
      FROM azbj_solution_appln_bases
      WHERE application_no = :v_appln_no 
        OR contract_id = azbj_pk0_acc.get_contract_id(:pol_ref)
        AND solution_id IS NOT NULL
        AND ROWNUM = 1
    `;
    return this.http.post<any>('/api/query', { query, params: { v_appln_no, pol_ref } })
      .pipe(catchError(error => {
        this.displayErrorMessage('Error retrieving solution ID');
        return of(null);
      }));
  }

  retrieveContractId(v_sol_id: string) {
    const query = `
      SELECT contract_id
      FROM azbj_solution_appln_bases a
      WHERE solution_id = :v_sol_id
        AND PARENT_FLAG = 'Y'
        AND EXISTS (SELECT 1
                    FROM azbj_solution_appln_bases b
                    WHERE a.solution_id = b.solution_id
                      AND PARENT_FLAG IS NULL)
    `;
    return this.http.post<any>('/api/query', { query, params: { v_sol_id } })
      .pipe(catchError(error => {
        this.displayErrorMessage('Error retrieving contract ID');
        return of(null);
      }));
  }

  retrievePolicyNumber(v_parent_cont_id: string) {
    const query = `SELECT azbj_pk0_acc.get_policy_ref(:v_parent_cont_id) AS policy_number FROM dual`;
    return this.http.post<any>('/api/query', { query, params: { v_parent_cont_id } })
      .pipe(catchError(error => {
        this.displayErrorMessage('Error retrieving policy number');
        return of(null);
      }));
  }

  logInformation(pol_ref: string, v_sol_id: string, v_parent_cont_id: string, v_pol_no: string) {
    const logMessage = `PrePrintQC Log=>sol_id: ${v_sol_id} parent_cont_id: ${v_parent_cont_id} pol_no: ${v_pol_no}`;
    const query = `INSERT INTO log_table (pol_ref, log_message) VALUES (:pol_ref, :logMessage)`;
    this.http.post('/api/query', { query, params: { pol_ref, logMessage } })
      .pipe(catchError(error => {
        this.displayErrorMessage('Error logging information');
        return of(null);
      }))
      .subscribe();
  }

  generateUrl(pol_ref: string) {
    const query = `SELECT azbj_encrypt_dms_link('NB', 'PRINT_QC', :pol_ref, NULL, NULL, NULL, NULL) AS url FROM dual`;
    return this.http.post<any>('/api/query', { query, params: { pol_ref } })
      .pipe(catchError(error => {
        this.displayErrorMessage('Error generating URL');
        return of(null);
      }));
  }

  displayErrorMessage(message: string) {
    alert(message);
  }
}
