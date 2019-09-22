package model;

import utilities.Entity;

public class OrderItem extends Entity {
	public OrderItem() {  }
	
	public OrderItem(Menu m, int n) { 
		this.menu = m;
		this.cant = n;
	}
	
  private Menu menu;
  private int cant;
  
  public int getPriceOrderItem() {
	  return 0;
  }
  
  public Menu getMenu() {
	return menu;
  }
	
  public void setMenu(Menu menu) {
	this.menu = menu;
  }

  public int getCant() {
	  return cant;
  }

  public void setCant(int cant) {
	  this.cant = cant;
  }
}
