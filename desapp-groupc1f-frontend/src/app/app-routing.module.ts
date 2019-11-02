import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AccountListComponent } from './account-list/account-list.component';
import { CreateAccountComponent } from './create-account/create-account.component';

const routes: Routes = [
  { path: '', redirectTo: 'account', pathMatch: 'full' },
  { path: 'accounts', component: AccountListComponent },
  { path: 'add', component: CreateAccountComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
