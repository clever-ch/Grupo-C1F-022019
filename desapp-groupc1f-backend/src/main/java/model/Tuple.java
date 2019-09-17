package model;

//Esta clase podria ir en otro package "utilities"
//Se podria generalizar para otras tuplas??
public class Tuple {

  public final Menu menu;
  public final int cant;
  
  public Tuple(Menu x, int y) {
    this.menu = x; 
    this.cant = y;
  } 
}
