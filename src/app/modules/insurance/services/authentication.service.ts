import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthenticationModel } from '../models/authentication.model';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private authUrl = 'http://your-backend-api-url/authenticate'; // Replace with your backend API URL

  constructor(private http: HttpClient) { }

  authenticate(supervisorId: string, password: string): Observable<AuthenticationModel> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });

    const body = {
      supervisorId: supervisorId.toUpperCase(),
      password: password
    };

    return this.http.post<AuthenticationModel>(this.authUrl, body, { headers: headers });
  }
}
