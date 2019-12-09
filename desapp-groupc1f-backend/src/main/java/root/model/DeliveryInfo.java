package root.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import root.constants.Shift;
import root.utilities.Entity;

@javax.persistence.Entity
public class DeliveryInfo extends Entity{
	
	@ElementCollection
	@Enumerated(EnumType.STRING)
	private List<Shift> shiftsAvailable = new ArrayList<Shift>();
	
	@ElementCollection
	@Column(nullable = false)
	private List<LocalTime> hoursAttention = new ArrayList<LocalTime>();
	
	@Column(nullable = false)
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
	
	public void setShiftsAvailable(List<Shift> shiftsAvailables) {
		this.shiftsAvailable = shiftsAvailables;
	}

	public List<LocalTime> getHoursAttention() {
		return hoursAttention;
	}
	
	public void setHoursAttention(List<LocalTime> hsAttention) {
		this.hoursAttention = hsAttention;
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
