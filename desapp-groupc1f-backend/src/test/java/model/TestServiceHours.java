package model;

import static org.junit.Assert.*;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalTime;
import org.junit.Test;
import model.factories.ServiceHoursFactory;

public class TestServiceHours {

	@Test
	public void testCanAddDayToServiceHours() {
		ServiceHours anyServiceHours = ServiceHoursFactory.anyServiceHours();
		anyServiceHours.setDay(DayOfWeek.MONDAY);
		
		assertTrue(anyServiceHours.getDay().equals(DayOfWeek.MONDAY));
	}

	@Test
	public void testNoDayAddedToServiceHours() {
		ServiceHours anyServiceHours = ServiceHoursFactory.anyServiceHours();

		assertTrue(anyServiceHours.getDay() == null);
	}
	
	@Test
	public void testCanAddHourToServiceHours() {
		final LocalTime HOUR_TO_ADD = LocalTime.of(10, 00);
		
		ServiceHours anyServiceHours = ServiceHoursFactory.anyServiceHours();
		anyServiceHours.addHour(HOUR_TO_ADD);

		assertTrue(anyServiceHours.getHours().contains(HOUR_TO_ADD));
	}
	
	@Test
	public void testNoHourAddedToServiceHours() {
		ServiceHours anyServiceHours = ServiceHoursFactory.anyServiceHours();

		assertTrue(anyServiceHours.getHours().size() == 0);
	}
	
	@Test
	public void testIsHourValidToAdd() {
		final LocalTime HOUR_TO_ADD = LocalTime.of(12, 00);
		ServiceHours anyServiceHours = ServiceHoursFactory.anyServiceHours();
		
		assertTrue(anyServiceHours.isHourValidToAdd(HOUR_TO_ADD));
	}
	
	@Test(expected = DateTimeException.class)
	public void testNotIsHourValidToAdd() {
		ServiceHours anyServiceHours = ServiceHoursFactory.anyServiceHours();
		
		assertFalse(anyServiceHours.isHourValidToAdd(LocalTime.of(25, 00)));
	}
	
	@Test
	public void testRepeatedHourIsNotValidToAdd() {
		final LocalTime HOUR_TO_ADD = LocalTime.of(12, 00);
		
		ServiceHours anyServiceHours = ServiceHoursFactory.anyServiceHours();
		anyServiceHours.addHour(HOUR_TO_ADD);
		
		assertFalse(anyServiceHours.isHourValidToAdd(HOUR_TO_ADD));
	}
}
