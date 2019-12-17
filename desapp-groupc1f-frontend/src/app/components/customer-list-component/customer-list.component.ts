import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from "rxjs";
import { CustomerService } from "src/app/services/customer-service/customer.service";
import { CustomerDTO } from "src/app/model/customerDTO";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customers: Observable<CustomerDTO[]>;

  constructor(private customerService: CustomerService, private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.customers = this.customerService.getCustomerList();
  }

}
