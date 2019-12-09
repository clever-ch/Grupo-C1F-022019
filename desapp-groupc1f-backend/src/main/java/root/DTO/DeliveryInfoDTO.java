package root.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeliveryInfoDTO {
	
	public long id;
	public List<String> shiftsAvailable = new ArrayList<String>();
	public List<Date> hoursAttention = new ArrayList<Date>();
	public boolean hasDelivery;
}
