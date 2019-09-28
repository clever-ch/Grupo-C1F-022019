package model;

import utilities.Entity;

public class OrderItem extends Entity {
	private Menu menu;
	private int numberMenus;
	  
	public OrderItem() {  }
	
	public OrderItem(Menu m, int n) { 
		this.menu = m;
		this.numberMenus = n;
	}
  
	public int getPriceOrderItem() {
		//TODO: Se puede calcular en base el precio del menu y la cantidad de menus
	  	return 0;
  	}
  
  	public Menu getMenu() {
	  return menu;
  	}
	
  	public void setMenu(Menu menu) {
  		this.menu = menu;
  	}

  	public int getNumberMenus() {
  		return numberMenus;
  	}

  	public void setNumberMenus(int cant) {
  		this.numberMenus = cant;
  	}
  	
  	public boolean isNumberOfMenusValid(int number) {
  		return number > 0;
  	}
}
