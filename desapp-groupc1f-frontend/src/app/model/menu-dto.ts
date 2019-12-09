import { DeliveryInfoDTO } from './delivery-info-dto';
import { Time } from '@angular/common';

export class MenuDTO {
    id: number;
    menuName: string;
    description: string;
    maximunSales: number;
    price: number;
    validFromDate: Date;
    validToDate: Date;
    deliveryPrice: number;
    avgDeliveryTime: string;
    categories: Array<String>;
    deliveryInfo: DeliveryInfoDTO;
}
