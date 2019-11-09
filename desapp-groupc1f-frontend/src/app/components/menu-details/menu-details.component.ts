import { Component, OnInit } from '@angular/core';
import { Menu } from 'src/app/model/menu';
import { Router, ActivatedRoute } from '@angular/router';
import { MenuService } from 'src/app/services/menu-service/menu.service';

@Component({
  selector: 'app-menu-details',
  templateUrl: './menu-details.component.html',
  styleUrls: ['./menu-details.component.css']
})
export class MenuDetailsComponent implements OnInit {

  id: number;
  menu: Menu;

  constructor(private route: ActivatedRoute, private router: Router,
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

  list() {
    this.router.navigate(['menus']);
  }

}
