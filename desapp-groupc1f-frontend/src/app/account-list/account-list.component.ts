import { Observable } from "rxjs";
import { AccountService } from "./../account.service";
import { Account } from "./../account";
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-account-list',
  templateUrl: './account-list.component.html',
  styleUrls: ['./account-list.component.css']
})
export class AccountListComponent implements OnInit {

  accounts: Observable<Account[]>;
  totalPages: Array<number>;

  page = 0;
  size = 5;
  order = 'name';
  asc = true;

  isFirst = false;
  isLast = false;

  constructor(private accountService: AccountService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.accountService.getAccountList(this.page, this.size, this.order, this.asc).subscribe(
      data => {
        console.log(data);
        this.accounts = data.content;
        this.isFirst = data.first;
        this.isLast = data.last;
        this.totalPages = new Array(data.totalPages);
      },
      err => {
        console.log(err.error);
      }
    );
  }
  sort(): void {
    this.asc = !this.asc;
    this.reloadData();
  }

  rewind(): void {
    if (!this.isFirst) {
      this.page--;
      this.reloadData();
    }
  }

  forward(): void {
    if (!this.isLast) {
      this.page++;
      this.reloadData();
    }
  }

  setPage(page: number): void {
    this.page = page;
    this.reloadData();
  }

  setOrder(order: string): void {
    this.order = order;
    this.reloadData();
  }

  accountDetails(id: number){
    this.router.navigate(['details', id]);
  }

  updateAccount(id: number){
    this.router.navigate(['update', id]);
  }

  deleteAccount(id: number) {
    this.accountService.deleteAccount(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }
  
}
