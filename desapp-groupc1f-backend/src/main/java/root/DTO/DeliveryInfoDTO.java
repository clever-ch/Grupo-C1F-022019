package root.DTO;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import root.constants.Shift;

public class DeliveryInfoDTO {
	
	public long id;
	public List<String> shiftsAvailable = new ArrayList<String>();
	public List<Date> hoursAttention = new ArrayList<Date>();
	public boolean hasDelivery;
}
