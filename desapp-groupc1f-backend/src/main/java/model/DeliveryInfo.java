package model;

import java.sql.Time;
import java.util.List;

import constants.Shift;
import utilities.Entity;

public class DeliveryInfo extends Entity {
	private List<Shift> shiftsAvailable;
	private List<Time> hoursAttention;
	private boolean hasDelivery;
	
	public List<Shift> getShiftAvailable() {
		return shiftsAvailable;
	}
	
	public void addShiftAvailable(Shift shiftAvailables) {
		this.shiftsAvailable.add(shiftAvailables);
	}

	public List<Time> getHoursAttention() {
		return hoursAttention;
	}

	public void setHourAttention(Time hour) {
		this.hoursAttention.add(hour);
	}

	public boolean hasDelivery() {
		return hasDelivery;
	}

	public void setHasDelivery(boolean hasDelivery) {
		this.hasDelivery = hasDelivery;
	}
}
