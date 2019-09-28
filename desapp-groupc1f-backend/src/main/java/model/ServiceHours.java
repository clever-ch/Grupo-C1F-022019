package model;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import utilities.Entity;

public class ServiceHours extends Entity {
	private DayOfWeek day;
	private List<LocalTime> hours = new ArrayList<LocalTime>();
	
	
	public DayOfWeek getDay() {
		return day;
	}
	
	public void setDay(DayOfWeek day) {
		this.day = day;
	}

	public List<LocalTime> getHours() {
		return hours;
	}

	public void addHour(LocalTime hour) {
		this.hours.add(hour);
	}
	
	public boolean isHourValidToAdd(LocalTime hour) throws DateTimeException{
		return !this.hours.contains(hour);
	}
}
