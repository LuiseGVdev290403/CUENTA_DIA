import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AccountRequest, AccountResponse } from '../models/account';


@Injectable({providedIn: 'root'})
export class AccountServices {
  private http = inject(HttpClient);
  private apiUrl = "http://localhost:8080/api/account";

  getAll(): Observable<AccountResponse[]> {
    return this.http.get<AccountResponse[]>(this.apiUrl);
  }
  getById(id:number): Observable<AccountResponse> {
    return this.http.get<AccountResponse>(`${this.apiUrl}/${id}`);
  }

  create(account: AccountRequest) : Observable<AccountResponse> {
    return this.http.post<AccountResponse>(this.apiUrl, account);
  }

  update(id: number, account: AccountRequest) : Observable<AccountResponse> {
    return this.http.put<AccountResponse>(`${this.apiUrl}/${id}`, account);
  }
  deleted(id:number) : Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

}
