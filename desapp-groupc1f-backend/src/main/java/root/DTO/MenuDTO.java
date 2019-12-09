package root.DTO;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import root.constants.Category;
import root.constants.Shift;
import root.model.DeliveryInfo;
import root.model.Menu;

public class MenuDTO {
	
	public long id;
	public String menuName;
	public String description;
	public int maximunSales;
	public double price = 0;
	public Date validFromDate = Calendar.getInstance().getTime();
	public Date validToDate = Calendar.getInstance().getTime();
	public double deliveryPrice;
	public String avgDeliveryTime;
	public String[] categories;
	public DeliveryInfoDTO deliveryInfoDTO;
	public List<OfferDTO> offers = new ArrayList<OfferDTO>();
	public String menuState;
	public List<MenuScoreDTO> menuScore = new ArrayList<MenuScoreDTO>();
	
	public Menu convertToMenu(MenuDTO menuDTO) {
		System.out.println(menuDTO.categories);
		
		Menu newMenu = new Menu();
		newMenu.setId(menuDTO.id);
		newMenu.setMenuName(menuDTO.menuName);
		newMenu.setDescription(menuDTO.description);
		newMenu.setMaximunSales(menuDTO.maximunSales);
		newMenu.setPrice(menuDTO.price);
		newMenu.setValidFromDate(menuDTO.validFromDate);
		newMenu.setValidToDate(menuDTO.validToDate);
		newMenu.setDeliveryPrice(menuDTO.deliveryPrice);
		newMenu.setAvgDeliveryTime(java.sql.Time.valueOf(menuDTO.avgDeliveryTime));
		newMenu.setCategories(convertStringsToCategories(menuDTO.categories));
		newMenu.setDeliveryInfo(converToDeliveryInfo(menuDTO.deliveryInfoDTO));
		
		return newMenu;
	}

	private DeliveryInfo converToDeliveryInfo(DeliveryInfoDTO deliveryInfoDTO) {
		
		DeliveryInfo newDeliveryInfo = new DeliveryInfo();
		newDeliveryInfo.setId(deliveryInfoDTO.id);
		newDeliveryInfo.setShiftsAvailable(convertStringsToShifts(deliveryInfoDTO.shiftsAvailable));
		newDeliveryInfo.setHoursAttention(convertToLocalTimeHsAttention(deliveryInfoDTO.hoursAttention));
		newDeliveryInfo.setHasDelivery(deliveryInfoDTO.hasDelivery);
		
		return newDeliveryInfo;
	}

	private List<LocalTime> convertToLocalTimeHsAttention(List<Date> hoursAttention) {

		List<LocalTime> listLocalTime = new ArrayList<LocalTime>();
		
		for (Date date : hoursAttention) {
			
			Instant instant = Instant.ofEpochMilli(date.getTime());
			LocalTime hourAttention = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalTime();
			
			listLocalTime.add(hourAttention);
		}
		
		return listLocalTime;
	}

	private List<Shift> convertStringsToShifts(List<String> shiftsAvailable) {
		List<Shift> shifts = new ArrayList<Shift>();
		
		for (String strshift : shiftsAvailable) {

			Shift shift = Shift.valueOf(strshift);
			
			if (shift != null) {
				shifts.add(shift);
			}
		}
		
		return shifts;
	}

	private List<Category> convertStringsToCategories(String[] strCategories) {
		
		List<Category> categories = new ArrayList<Category>();
		
		for (String strCategory : strCategories) {

			Category categorie = Category.valueOf(strCategory);
			
			if (categorie != null) {
				categories.add(categorie);
			}
		}
		return categories;
	}
}
