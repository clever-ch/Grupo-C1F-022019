package model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import constants.Days;
import utilities.Entity;

public class ServiceHours extends Entity {
	private Days day;
	private List<Time> hours = new ArrayList<Time>();
	
	
	public Days getDay() {
		return day;
	}
	
	public void setDay(Days day) {
		this.day = day;
	}

	public List<Time> getHours() {
		return hours;
	}

	public void addHour(Time hour) {
		this.hours.add(hour);
	}

}
