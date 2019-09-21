package model;

public class OrderItem {

  private Menu menu;
  private int cant;
  
  public OrderItem(Menu m, int n) {
    this.setMenu(m); 
    this.setCant(n);
  }
  
  public int GetPriceOrderItem() {
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
