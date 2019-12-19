import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MenuScoreService {

  private baseUrl = 'http://localhost:8080/api/v1/menuscores';

  constructor(private http: HttpClient) { }

  getAllMenuScores(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  createMenuScore(menuScoreDTO: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, menuScoreDTO);
  }
}
