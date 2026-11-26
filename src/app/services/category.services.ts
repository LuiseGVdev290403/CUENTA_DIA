import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CategoryRequest, CategoryResponse } from '../models/category';


@Injectable({ providedIn: 'root' })
export class CategoryService {

  private http = inject(HttpClient);
  private apiUrl = `http://localhost:8080/api/category`;

  getAll() : Observable<CategoryResponse[]> {
    return this.http.get<CategoryResponse[]>(this.apiUrl);
  }

  getById(id:number): Observable<CategoryResponse> {
    return this.http.get<CategoryResponse>(`${this.apiUrl}/${id}`);
  }

  create(category: CategoryRequest): Observable<CategoryResponse> {
    return this.http.post<CategoryResponse>(this.apiUrl, category);
  }

  deleted(id:number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

}
