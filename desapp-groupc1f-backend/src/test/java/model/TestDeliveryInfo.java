package model;

import static org.junit.Assert.assertTrue;

import java.sql.Time;

import org.junit.Test;

import constants.Shift;
import model.factories.DeliveryInfoFactory;

public class TestDeliveryInfo {
	
	@Test
	public void testIsValidDeliveryInfo() {
		DeliveryInfo aDelivery = DeliveryInfoFactory.aDeliveryInfoComplete();
		
		assertTrue(aDelivery.isValidDeliveryInfo());
	}
	
	@Test
	public void testHasListAttention() {
		DeliveryInfo aDelivery = DeliveryInfoFactory.anyDeliveryInfo();
		aDelivery.setHourAttention(new Time(0));
		
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

