import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from "rxjs";
import { OrderItemDTO } from '../../model/order-item-dto';
import { OrderItemService } from "./../../services/orderItem-service/order-item.service";

@Component({
  selector: 'app-order-item',
  templateUrl: './order-item.component.html',
  styleUrls: ['./order-item.component.css']
})
export class OrderItemComponent implements OnInit {

  orderItems: Observable<OrderItemDTO[]>;

  constructor(private orderItemService: OrderItemService,
    private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.orderItems = this.orderItemService.getAllOrderItems();
  }
  sort(): void {
    this.reloadData();
  }

}
