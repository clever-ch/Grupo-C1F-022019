package model.factories;

import java.sql.Time;

import constants.Shift;
import model.DeliveryInfo;

public class DeliveryInfoFactory {
	
	public static DeliveryInfo anyDeliveryInfo() {
		return new DeliveryInfo();
	}
	
	public static DeliveryInfo aDeliveryInfoComplete(){
		DeliveryInfo aDeliveryInfo = new DeliveryInfo();
		aDeliveryInfo.setHasDelivery(true);
		aDeliveryInfo.setHourAttention(new Time(0));
		aDeliveryInfo.addShiftAvailable(Shift.Morning);
		
		return aDeliveryInfo;
	}
	
	public static DeliveryInfo aDeliveryInfoWithDelivery() {
		DeliveryInfo aDeliveryInfo = new DeliveryInfo();
		aDeliveryInfo.setHasDelivery(true);
		return aDeliveryInfo;
	}
}
