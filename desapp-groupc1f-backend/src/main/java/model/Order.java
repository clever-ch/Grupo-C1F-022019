package model;

import java.util.ArrayList;
import java.util.Date;
import constants.DeliveryState;
import java.time.LocalTime;


public class Order {
	ArrayList<Tuple> MenuAmount = new ArrayList<Tuple>();	
    boolean hasDelivery;
    Date creationDate;
    Date deliveredDate;
    LocalTime deliveryTime;
    DeliveryState deliveryState;
}
