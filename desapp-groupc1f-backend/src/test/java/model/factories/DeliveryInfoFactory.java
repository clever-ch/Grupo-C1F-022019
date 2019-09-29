package model.factories;

import java.time.LocalTime;
import constants.Shift;
import model.DeliveryInfo;

public class DeliveryInfoFactory {
	
	public static DeliveryInfo anyDeliveryInfo() {
		return new DeliveryInfo();
	}
	
	public static DeliveryInfo aDeliveryInfoComplete(){
		final LocalTime HOUR_TO_ADD = LocalTime.of(10, 00);
		
		DeliveryInfo aDeliveryInfo = new DeliveryInfo();
		aDeliveryInfo.setHasDelivery(true);
		aDeliveryInfo.setHourAttention(HOUR_TO_ADD);
		aDeliveryInfo.addShiftAvailable(Shift.Morning);
		
		return aDeliveryInfo;
	}
	
	public static DeliveryInfo aDeliveryInfoWithDelivery() {
		DeliveryInfo aDeliveryInfo = new DeliveryInfo();
		aDeliveryInfo.setHasDelivery(true);
		return aDeliveryInfo;
	}
}
