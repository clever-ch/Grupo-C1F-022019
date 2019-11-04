import { Time } from '@angular/common';

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
}
