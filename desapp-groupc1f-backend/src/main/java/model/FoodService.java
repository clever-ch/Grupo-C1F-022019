package model;

import java.util.ArrayList;
import java.util.List;

import utilities.Entity;

public class FoodService extends Entity {
	private String serviceName;
	private String serviceLocation;
	private String serviceAddress;
	private String locationPointMap;	//TODO: Por ahora se deja como string. Checkear formato API para las direcciones
	private String serviceDescription;
	private String webSite;
	private String email;
	private String phone;
	private List<ServiceHours> serviceHours = new ArrayList<ServiceHours>();
	private String deliveryLocations;
	private List<Menu> serviceMenues = new ArrayList<Menu>();
	private List<FoodServiceScore> serviceScores = new ArrayList<FoodServiceScore>();
	private int maxNumberMenus;
	
	
	public String getServiceName() {
		return serviceName;
	}
	
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceLocation() {
		return serviceLocation;
	}

	public void setServiceLocation(String serviceLocation) {
		this.serviceLocation = serviceLocation;
	}

	public String getServiceAddress() {
		return serviceAddress;
	}

	public void setServiceAddress(String serviceAddress) {
		this.serviceAddress = serviceAddress;
	}

	public String getLocationPointMap() {
		return locationPointMap;
	}

	public void setLocationPointMap(String locationPointMap) {
		this.locationPointMap = locationPointMap;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<ServiceHours> getServiceHours() {
		return serviceHours;
	}

	public void addServiceHours(ServiceHours serviceHour) {
		this.serviceHours.add(serviceHour);
	}

	public String getDeliveryLocations() {
		return deliveryLocations;
	}

	public void setDeliveryLocations(String deliveryLocations) {
		this.deliveryLocations = deliveryLocations;
	}

	public List<Menu> getServiceMenues() {
		return serviceMenues;
	}

	public void addServiceMenue(Menu menu) {
		this.serviceMenues.add(menu);
	}

	public List<FoodServiceScore> getServiceScores() {
		return serviceScores;
	}

	public void addServiceScores(FoodServiceScore serviceScore) {
		this.serviceScores.add(serviceScore);
	}

	public int getMaxNumberMenus() {
		return maxNumberMenus;
	}

	public void setMaxNumberMenus(int maxNumberMenus) {
		this.maxNumberMenus = maxNumberMenus;
	}
}
