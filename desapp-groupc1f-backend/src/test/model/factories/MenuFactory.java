package java.factories;

import model.Menu;

public class MenuFactory {
	
	public static Menu anyMenu() {
		return new Menu();
	}
}
