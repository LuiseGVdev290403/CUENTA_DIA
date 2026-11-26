import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AccountResponse } from '../models/account';
import { StoreRequest, StoreResponse } from '../models/store';


@Injectable({ providedIn: 'root' })
export class StoreServices {

  private http = inject(HttpClient);
  private apiUrl = 'http://localhost:8080/api/store';

  getAll(): Observable<StoreResponse[]> {
    return this.http.get<StoreResponse[]>(this.apiUrl);
  }

  getById(id: number): Observable<StoreResponse> {
    return this.http.get<StoreResponse>(`${this.apiUrl}/${id}`);
  }
  create(store: StoreRequest): Observable<StoreResponse> {
    return this.http.post<StoreResponse>(this.apiUrl, store);
  }
  deleted(id:number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
