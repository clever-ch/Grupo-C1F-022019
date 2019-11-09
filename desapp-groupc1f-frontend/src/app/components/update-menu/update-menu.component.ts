import { Component, OnInit } from '@angular/core';
import { Menu } from 'src/app/model/menu';
import { ActivatedRoute, Router } from '@angular/router';
import { MenuService } from 'src/app/services/menu-service/menu.service';

@Component({
  selector: 'app-update-menu',
  templateUrl: './update-menu.component.html',
  styleUrls: ['./update-menu.component.css']
})
export class UpdateMenuComponent implements OnInit {

  id: number;
  menu: Menu;

  constructor(private route: ActivatedRoute,private router: Router,
    private menuService: MenuService) { }

  ngOnInit() {
    this.menu = new Menu();

    this.id = this.route.snapshot.params['id'];
    
    this.menuService.getMenu(this.id)
      .subscribe(data => {
        console.log(data)
        this.menu = data;
      }, error => console.log(error));
  }

  updateMenu() {
    this.menuService.updateMenu(this.id, this.menu)
      .subscribe(data => console.log(data), error => console.log(error));
    this.menu = new Menu();
    this.gotoList();
  }

  onSubmit() {
    this.updateMenu();    
  }

  gotoList() {
    this.router.navigate(['/menus']);
  }

  menuList() {
    this.router.navigate(['menus']);
  }

}
