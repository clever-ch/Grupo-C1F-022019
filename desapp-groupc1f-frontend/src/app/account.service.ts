import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  private baseUrl = 'http://localhost:8080/api/v1/accounts';

  constructor(private http: HttpClient) { }

  getAccount(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  getAccountList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  createAccount(account: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, account);
  }

  updateAccount(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteAccount(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }
}
