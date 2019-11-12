import { Component, OnInit } from '@angular/core';
import { MenuService } from 'src/app/services/menu-service/menu.service';
import { Menu } from 'src/app/model/menu';
import { Router } from '@angular/router';
import { DeliveryInfo } from 'src/app/model/delivery-info'
import { IDropdownSettings } from 'ng-multiselect-dropdown';
import { LinkedList } from 'ngx-bootstrap';

@Component({
  selector: 'app-create-menu',
  templateUrl: './create-menu.component.html',
  styleUrls: ['./create-menu.component.css']
})
export class CreateMenuComponent implements OnInit {

  menu: Menu = new Menu();
  deliveryInfo: DeliveryInfo = new DeliveryInfo();
  submitted = false;
  dropdownSettings: IDropdownSettings = {};
  ddlCategories = [];
  selectedItems = new LinkedList<any>();
  maxChars = 300;

  constructor(private menuService: MenuService, private router: Router) { }

  ngOnInit() {
    this.ddlCategories = [
      { item_id: 1, item_text: 'Pizza' },
      { item_id: 2, item_text: 'Beer' },
      { item_id: 3, item_text: 'Burger' },
      { item_id: 4, item_text: 'Sushi' },
      { item_id: 5, item_text: 'Empanada' },
      { item_id: 6, item_text: 'Vegetarian' },
      { item_id: 7, item_text: 'Vegan' }
    ];

    this.dropdownSettings = {
      singleSelection: false,
      defaultOpen: false,
      idField: 'item_id',
      textField: 'item_text'
    };
  }

  onItemSelect(item: any) {
    console.log('onItem Select', item);
    this.selectedItems.add(item);
  }

  onItemDeSelect(item: any) {
    console.log('onItem DeSelect', item);
    this.selectedItems.remove(item);
  }

  newMenu(): void {
    this.submitted = false;
    this.menu = new Menu();
  }

  save() {
    this.menu.categories = this.selectedItems.toArray();
    this.menu.deliveryInfo = this.deliveryInfo;
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
