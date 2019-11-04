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

  menu: Observable<Menu[]>;

  constructor(private menuService: MenuService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.menu = this.menuService.getMenuList();
  }

  menuDetails(id: number){
    this.router.navigate(['details', id]);
  }

  updateMenu(id: number){
    this.router.navigate(['update', id]);
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

}
