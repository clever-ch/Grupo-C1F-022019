import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from "rxjs";
import { MenuService } from "src/app/services/menu-service/menu.service";
import { Menu } from "src/app/model/menu";

@Component({
  selector: 'app-menu-list',
  templateUrl: './menu-list.component.html',
  styleUrls: ['./menu-list.component.css']
})
export class MenuListComponent implements OnInit {

  menus: Observable<Menu[]>;
  currentRate = 0;

  constructor(private menuService: MenuService, private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.menus = this.menuService.getMenuList();
  }

  menuDetails(id: number){
    this.router.navigate(['menuDetails', id]);
  }

  updateMenu(id: number){
    this.router.navigate(['menuUpdate', id]);
  }

  deleteMenu(id: number) {
    this.menuService.deleteMenu(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  sendRate(rate: number) {
    console.log("El puntaje es: " + rate);
  }

}
