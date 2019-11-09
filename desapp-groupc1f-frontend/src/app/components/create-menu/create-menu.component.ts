import { Component, OnInit } from '@angular/core';
import { MenuService } from 'src/app/services/menu-service/menu.service';
import { Menu } from 'src/app/model/menu';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-menu',
  templateUrl: './create-menu.component.html',
  styleUrls: ['./create-menu.component.css']
})
export class CreateMenuComponent implements OnInit {

  menu: Menu = new Menu();
  submitted = false;

  constructor(private menuService: MenuService,
    private router: Router) { }

  ngOnInit() {
  }

  newMenu(): void {
    this.submitted = false;
    this.menu = new Menu();
  }

  save() {
    this.menuService.createMenu(this.menu)
      .subscribe(data => console.log(data), error => console.log(error));
    this.menu = new Menu();
    this.menuList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  menuList() {
    this.router.navigate(['/menus']);
  }

}
