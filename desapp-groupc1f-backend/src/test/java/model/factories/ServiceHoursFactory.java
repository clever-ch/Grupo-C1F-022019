package model.factories;

import model.ServiceHours;

public class ServiceHoursFactory {
	
	public static ServiceHours anyServiceHours() {
		return new ServiceHours();
	}
	
	public static ServiceHours aServiceHoursWithId(long id) {
		ServiceHours aServiceHours = anyServiceHours();
		aServiceHours.setId(id);
		
		return aServiceHours;
	}
}
