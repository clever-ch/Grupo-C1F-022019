import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs";
import { Menu } from 'src/app/model/menu';
import { Router, ActivatedRoute } from '@angular/router';
import { MenuService } from 'src/app/services/menu-service/menu.service';
import { OrderItemDTO } from '../../model/order-item-dto';
import { AuthService } from "../../services/auth-service/auth.service";
import { OrderItemService } from "../../services/orderItem-service/order-item.service";
import { MenuScoreService } from "../../services/menu-score-service/menu-score.service";
import { MenuScoreDTO } from 'src/app/model/menu-score-dto';

@Component({
  selector: 'app-menu-details',
  templateUrl: './menu-details.component.html',
  styleUrls: ['./menu-details.component.css']
})
export class MenuDetailsComponent implements OnInit {

  id: number;
  menu: Menu;
  orderItemDTO: OrderItemDTO = new OrderItemDTO();
  currentRate = 0;
  statusConfirm: boolean = false;
  menuScoreDTO: MenuScoreDTO = new MenuScoreDTO();
  orderItems: Observable<MenuScoreDTO[]> = null;
  failBuy: boolean = false;
  confirmRate: boolean = false;

  constructor(private route: ActivatedRoute,
    private router: Router,
    private menuService: MenuService,
    public authService: AuthService,
    private orderItemService: OrderItemService,
    public menuScoreService: MenuScoreService) { }

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

  addMenuEvent() {
    this.orderItemDTO.totalPrice = (this.orderItemDTO.numberMenus * this.menu.price) + this.menu.deliveryPrice;
  }

  confirmPurchase() {
    this.completeOrderItem();
    this.orderItemService.buyMenu(this.orderItemDTO).subscribe(data => this.statusConfirm = true, error => this.failBuy = true);
  }

  completeOrderItem() {
    this.orderItemDTO.tokenUser = this.authService.userData.uid;
    this.orderItemDTO.menuId = this.id;
  }

  sendRate(rate: number) {
    this.completeMenuScoreDTO(rate);
    this.menuScoreService.createMenuScore(this.menuScoreDTO).subscribe(data => this.confirmRate = true, error => console.log(error));
    //this.router.navigate(['menus']);
  }

  completeMenuScoreDTO(rate: number) {
    this.menuScoreDTO.rate = rate;
    this.menuScoreDTO.idMenu = this.id;
    this.menuScoreDTO.userToken = this.authService.userData.uid;
  }

  setVisualizacionRate() {
    this.orderItems = this.orderItemService.getAllOrderItems();
  }

}
