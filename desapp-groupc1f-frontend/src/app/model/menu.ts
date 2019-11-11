import { Time } from '@angular/common';
import { DeliveryInfo } from 'src/app/model/delivery-info'

export class Menu {
    id: number;
    menuName: string;
    description: string;
    maximunSales: number;
    price: number;
    validFromDate: Date;
    validToDate: Date;
    deliveryPrice: number;
    avgDeliveryTime: Time;
    categories: Array<string>;
    deliveryInfo: DeliveryInfo;
}
