package model;

import static org.junit.Assert.assertTrue;
import java.time.LocalTime;
import org.junit.Test;
import root.constants.Shift;
import root.model.DeliveryInfo;
import model.factories.DeliveryInfoFactory;

public class TestDeliveryInfo {
	
	@Test
	public void testIsValidDeliveryInfo() {
		DeliveryInfo aDelivery = DeliveryInfoFactory.aDeliveryInfoComplete();
		
		assertTrue(aDelivery.isValidDeliveryInfo());
	}
	
	@Test
	public void testHasListAttention() {
		final LocalTime HOUR_TO_ADD = LocalTime.of(10, 00);
		
		DeliveryInfo aDelivery = DeliveryInfoFactory.anyDeliveryInfo();
		aDelivery.setHourAttention(HOUR_TO_ADD);
		
		assertTrue(aDelivery.hasListAttention());
	}
	
	@Test
	public void testHasShifts() {
		DeliveryInfo aDelivery = DeliveryInfoFactory.anyDeliveryInfo();
		aDelivery.addShiftAvailable(Shift.Night);
		
		assertTrue(aDelivery.hasShifts());
	}
	
	@Test
	public void testAddShiftAvailable() {
		DeliveryInfo aDelivery = DeliveryInfoFactory.anyDeliveryInfo();
		aDelivery.addShiftAvailable(Shift.Morning);
		
		assertTrue(aDelivery.getShiftAvailable().contains(Shift.Morning));
	}
	
	@Test
	public void testHasDeliveryTrue() {
		DeliveryInfo aDelivery = DeliveryInfoFactory.aDeliveryInfoWithDelivery();
		
		assertTrue(aDelivery.hasDelivery());
	}
}

