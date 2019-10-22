package root.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.OneToMany;
import root.exceptions.DuplicateMenuException;
import root.exceptions.NumberOfMenusEnabledException;
import root.utilities.Entity;

@javax.persistence.Entity
public class FoodService extends Entity {
	
	private String serviceName;
	private String serviceLocation;
	private String serviceAddress;
	private String locationPointMap;	//TODO: Por ahora se deja como string. Checkear formato API para las direcciones
	private String serviceDescription;
	private String webSite;
	private String email;
	private String phone;
	
	@OneToMany
	private List<ServiceHours> serviceHours = new ArrayList<ServiceHours>();
	private String deliveryLocations;
	
	@OneToMany
	private List<Menu> serviceMenues = new ArrayList<Menu>();
	
	@OneToMany
	private List<FoodServiceScore> serviceScores = new ArrayList<FoodServiceScore>();
	private int maxNumberMenus;
	
	public boolean isValidFoodService() {
		return !isEmptyServiceName()
				& !isEmptyServiceLocation()
				& !isEmptyServiceAddress()
				& !isEmptyLocationPointM()
				& hasDescription()
				& hasWebSiteValid()
				& hasEmail()
				& hasPhoneValid()
				& hasAListOfServiceHours()
				& hasDeliveryLocation()
				& hasMenues()
				& hasMaxNumberMenuesValid();
	}
	
	public boolean isEmptyServiceName() {
		return this.serviceName == "" | this.serviceName == null;
	}

	public boolean isEmptyServiceLocation() {
		return this.serviceLocation == "" | this.serviceLocation == null;

	}

	public boolean isEmptyServiceAddress() {
		return this.serviceAddress == "" | this.serviceAddress == null;
	}

	public boolean isEmptyLocationPointM() {
		return this.locationPointMap == "" | this.locationPointMap == null;
	}

	public boolean hasDescription() {
		return this.serviceDescription != "" | this.serviceDescription != null;
	}

	public boolean hasWebSiteValid() {
		return this.webSite != "" | this.webSite != null;
	}

	public boolean hasEmail() {
		return this.email != "" | this.email != null;
	}

	public boolean hasPhoneValid() {
		return this.phone != "" | this.phone != null;
	}

	public boolean hasAListOfServiceHours() {
		return this.serviceHours.isEmpty() | this.serviceHours != null;
	}

	public boolean hasDeliveryLocation() {
		return this.deliveryLocations != "" | this.deliveryLocations != null;
	}

	public boolean hasMenues() {
		return this.serviceMenues.isEmpty() | this.serviceMenues != null;
	}

	public boolean hasMaxNumberMenuesValid() {
		return this.maxNumberMenus != 0 ;
	}

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

	public void addServiceMenu(Menu menu) {
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

	public int numberMenusEnabled() {
		int menusEnabled = 0;
		
		for (Menu menu : serviceMenues)
			menusEnabled = menusEnabled + (menu.isEnabled() ? 1 : 0);
		
		return menusEnabled;
	}
	
	public boolean meetsMaxNumberMenusEnabled() {
		return numberMenusEnabled() <= getModelConstants().numberMenusEnabled();
	}
	
	public void setSetServiceMenues(List<Menu> menues) {
		this.serviceMenues = menues;
	}
	
	public boolean containsMenu(Menu menu) {
		boolean contains = false;
		
		for (Menu m : this.serviceMenues)
			contains = contains | m.isTheSameMenu(menu);
		
		return contains;
	}
	
	public void registerMenu(Menu menu) throws NumberOfMenusEnabledException, DuplicateMenuException {
		if (!meetsMaxNumberMenusEnabled())
			throw new NumberOfMenusEnabledException("El proveedor contiene el número máximo de menús permitidos");
		else
			if (containsMenu(menu))
				throw new DuplicateMenuException("El menú ya se encuentra registrado");
			else
				addServiceMenu(menu);
	}
	
	public boolean isTheSameFoodService(FoodService foodService) {
		return this.getId() == foodService.getId() 
				| this.serviceName.equals(foodService.getServiceName());
	} 
}
