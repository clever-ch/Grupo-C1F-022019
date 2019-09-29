package model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import constants.Shift;
import utilities.Entity;

public class DeliveryInfo extends Entity {
	private List<Shift> shiftsAvailable = new ArrayList<Shift>();
	private List<LocalTime> hoursAttention = new ArrayList<LocalTime>();
	private boolean hasDelivery;
	
	public boolean isValidDeliveryInfo() {
		return hasListAttention()
				& hasShifts();
	}

	public boolean hasListAttention() {
		return this.shiftsAvailable.isEmpty() | this.shiftsAvailable != null;
	}


	public boolean hasShifts() {
		return this.hoursAttention.isEmpty() | this.hoursAttention != null;
	}


	public List<Shift> getShiftAvailable() {
		return shiftsAvailable;
	}
	
	public void addShiftAvailable(Shift shiftAvailables) {
		this.shiftsAvailable.add(shiftAvailables);
	}

	public List<LocalTime> getHoursAttention() {
		return hoursAttention;
	}

	public void setHourAttention(LocalTime hour) {
		this.hoursAttention.add(hour);
	}

	public boolean hasDelivery() {
		return hasDelivery;
	}

	public void setHasDelivery(boolean hasDelivery) {
		this.hasDelivery = hasDelivery;
	}
}
