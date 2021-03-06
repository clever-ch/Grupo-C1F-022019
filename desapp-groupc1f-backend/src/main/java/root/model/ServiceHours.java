package root.model;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;
import root.utilities.Entity;

@javax.persistence.Entity
public class ServiceHours extends Entity {
	
	private DayOfWeek day;
	
	@ElementCollection
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
	
	public boolean isHourValidToAdd(LocalTime hour){
		return !this.hours.contains(hour);
	}
	
	public void registerHour(LocalTime hour) throws DateTimeException {
		if (isHourValidToAdd(hour))
			throw new DateTimeException("El horario ya fue registrado");
		else
			addHour(hour);
	}
}
