import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AccountListComponent } from './account-list/account-list.component';
import { CreateAccountComponent } from './create-account/create-account.component';
import { AccountDetailsComponent } from './account-details/account-details.component';
import { UpdateAccountComponent } from './update-account/update-account.component';
import { MenuListComponent } from './components/menu-list/menu-list.component';
import { MenuDetailsComponent } from './components/menu-details/menu-details.component';
import { UpdateMenuComponent } from './components/update-menu/update-menu.component';
import { CreateMenuComponent } from './components/create-menu/create-menu.component';
import { OrderItemComponent } from './components/order-item/order-item.component';

// Required components for which route services to be activated
import { SignInComponent } from 'src/app/components/sign-in/sign-in.component';


const routes: Routes = [
  { path: '', redirectTo: 'sign-in', pathMatch: 'full' },
  { path: 'accounts', component: AccountListComponent },
  { path: 'add', component: CreateAccountComponent },
  { path: 'details/:id', component: AccountDetailsComponent },
  { path: 'update/:id', component: UpdateAccountComponent },
  { path: 'menuUpdate/:id', component: UpdateMenuComponent },
  { path: 'menus', component: MenuListComponent },
  { path: 'menuDetails/:id', component: MenuDetailsComponent },
  { path: 'addMenu', component: CreateMenuComponent },
  { path: 'sign-in', component: SignInComponent },
  { path: 'orderItems', component: OrderItemComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
