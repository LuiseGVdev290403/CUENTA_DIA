import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TagsRequest, TagsResponse } from '../models/tags';


@Injectable({ providedIn: 'root' })
export class TagsServices {
  private http = inject(HttpClient);
  private apiUrl = `http://localhost:8080/api/tags`;


  getAll(): Observable<TagsResponse[]> {
    return this.http.get<TagsResponse[]>(this.apiUrl);
  }

  getById(id:number): Observable<TagsResponse> {
    return this.http.get<TagsResponse>(this.apiUrl + '/' + id);
  }

  create(tags : TagsRequest): Observable<TagsResponse> {
    return this.http.post<TagsResponse>(this.apiUrl, tags);
  }

  deletedById(id:number): Observable<void> {
    return this.http.delete<void>(this.apiUrl + '/' + id);
  }

}
