import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  private baseUrl = 'http://localhost:8080/api/v1/menus';

  constructor(private http: HttpClient) { }

  getMenu(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  getMenuList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  createMenu(menu: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, menu);
  }

  updateMenu(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteMenu(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }
}
