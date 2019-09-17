package model;

import java.util.List;

public class Customer extends User {
    List<Order> order;
    List<OrderHistory> orderHistory;
}
