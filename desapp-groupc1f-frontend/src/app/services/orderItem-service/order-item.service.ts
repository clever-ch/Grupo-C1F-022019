import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderItemService {

  private baseUrl = 'http://localhost:8080/api/v1/orderItems';

  constructor(private http: HttpClient) { }

  buyMenu(orderItemDTO: Object): Observable<Object> {
    console.log("Imprimo el DTO entrante");
    console.log(orderItemDTO);
    return this.http.post(`${this.baseUrl}`, orderItemDTO);
  }

  getAllOrderItems(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
