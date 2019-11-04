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

  constructor(private accountService: AccountService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.accounts = this.accountService.getAccountList();
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
