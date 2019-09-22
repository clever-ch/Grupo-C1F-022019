package model;

import java.sql.Time;
import java.util.ArrayList;

import constants.Days;
import utilities.Entity;

public class ServiceHours extends Entity {
	private Days day;
	private ArrayList<Time> hours;
	
	
	public Days getDay() {
		return day;
	}
	
	public void setDay(Days day) {
		this.day = day;
	}

	public ArrayList<Time> getHours() {
		return hours;
	}

	public void addHour(Time hour) {
		this.hours.add(hour);
	}

}
