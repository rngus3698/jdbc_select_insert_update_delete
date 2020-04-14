package model.vo;

import java.io.Serializable;

public class Menu implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6737116135139583573L;
	
	private String menuName;
	private int price;
	public Menu() {
		super();
	}
	public Menu(String menuName, int price) {
		super();
		this.menuName = menuName;
		this.price = price;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Menu [menuName=" + menuName + ", price=" + price + "]";
	}
	
	
}
