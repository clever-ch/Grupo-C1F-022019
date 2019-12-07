import { Component, OnInit } from '@angular/core';
import { MenuService } from 'src/app/services/menu-service/menu.service';
//import { Menu } from 'src/app/model/menu';
import { Router } from '@angular/router';
//import { DeliveryInfo } from 'src/app/model/delivery-info'
import { IDropdownSettings } from 'ng-multiselect-dropdown';
import { LinkedList } from 'ngx-bootstrap';
import { DatePipe } from '@angular/common';
import { MenuDTO } from '../../model/menu-dto';
import { DeliveryInfoDTO } from '../../model/delivery-info-dto';

@Component({
  selector: 'app-create-menu',
  templateUrl: './create-menu.component.html',
  styleUrls: ['./create-menu.component.css']
})
export class CreateMenuComponent implements OnInit {

  menuDTO: MenuDTO = new MenuDTO();
  deliveryInfoDTO: DeliveryInfoDTO = new DeliveryInfoDTO();
  submitted = false;
  dropdownSettings: IDropdownSettings = {};
  ddlCategories = [];
  selectedCategories = new LinkedList<any>();
  ddlShifts = [];
  selectedShifts = new LinkedList<any>();
  maxChars = 300;
  hasDelivery = false;
  ddlhsAttention = [];
  selectedhsAttention = new LinkedList<Date>();

  pipe = new DatePipe('en-US');
  time_1 = new Date(2019,1,1,8,0);
  time_2 = new Date(2019,1,1,12,0);
  time_3 = new Date(2019,1,1,17,0);
  time_4 = new Date(2019,1,1,21,0);
  
  hour_1 = this.pipe.transform(this.time_1, 'shortTime');
  hour_2 = this.pipe.transform(this.time_2, 'shortTime');
  hour_3 = this.pipe.transform(this.time_3, 'shortTime');
  hour_4 = this.pipe.transform(this.time_4, 'shortTime');

  constructor(private menuService: MenuService, private router: Router) { }

  ngOnInit() {
    this.dropdownSettings = {
      singleSelection: false,
      defaultOpen: false,
      idField: 'item_id',
      textField: 'item_text'
    };

    this.ddlCategories = [
      { item_id: 1, item_text: 'Pizza' },
      { item_id: 2, item_text: 'Beer' },
      { item_id: 3, item_text: 'Burger' },
      { item_id: 4, item_text: 'Sushi' },
      { item_id: 5, item_text: 'Empanada' },
      { item_id: 6, item_text: 'Vegetarian' },
      { item_id: 7, item_text: 'Vegan' }
    ];

    this.ddlShifts = [
      { item_id: 1, item_text: 'Morning' },
      { item_id: 2, item_text: 'Afternoon' },
      { item_id: 3, item_text: 'Night' },
    ];

    this.ddlhsAttention = [
      { item_id: 1, item_text: this.hour_1 },
      { item_id: 2, item_text: this.hour_2 },
      { item_id: 3, item_text: this.hour_3 },
      { item_id: 4, item_text: this.hour_4 },
    ];
  }

  onItemSelect(item: any) {
    this.selectedCategories.add(item);
  }

  onItemDeSelect(item: any) {
    this.selectedCategories.remove(item);
  }

  onShiftSelect(item: any) {
    this.selectedShifts.add(item);
  }

  onShiftDeSelect(item: any) {
    this.selectedShifts.remove(item);
  }

  onHourSelect(item: any) {
    this.selectedhsAttention.add(item);
  }

  onHourDeSelect(item: any) {
    this.selectedhsAttention.remove(item);
  }
  
  createDeliveryInfo(): DeliveryInfoDTO {
    var deliveryInfo = new DeliveryInfoDTO();
    deliveryInfo.shiftsAvailable = this.selectedShifts.toArray();
    deliveryInfo.hoursAttention = this.selectedhsAttention.toArray();
    deliveryInfo.hasDelivery = this.hasDelivery;

    return deliveryInfo;
  }

  chkHasDeliveryEvent(e){
    this.hasDelivery= e.target.checked;
  }

  newMenu(): void {
    this.submitted = false;
    this.menuDTO = new MenuDTO();
  }

  save() {
    this.menuDTO.categories = this.selectedCategories.toArray();
    this.menuDTO.deliveryInfo = this.createDeliveryInfo();
    this.menuService.createMenu(this.menuDTO)
      .subscribe(data => console.log(data), error => console.log(error));
    this.menuDTO = new MenuDTO();
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
