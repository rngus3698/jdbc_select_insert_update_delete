package model.vo;

import java.io.Serializable;
import java.sql.Date;

public class MenuOrder implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6828418449727642714L;
	
	private int tableNum;
	private int price;
	private String menu;
	private Date orderDate;
	public MenuOrder() {
		super();
	}
	
	public MenuOrder(int tableNum, int price, String menu) {
		super();
		this.tableNum = tableNum;
		this.price = price;
		this.menu = menu;
	}

	public MenuOrder(int tableNum, int price, String menu, Date orderDate) {
		super();
		this.tableNum = tableNum;
		this.price = price;
		this.menu = menu;
		this.orderDate = orderDate;
	}
	public int getTableNum() {
		return tableNum;
	}
	public void setTableNum(int tableNum) {
		this.tableNum = tableNum;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "MenuOrder [tableNum=" + tableNum + ", price=" + price + ", menu=" + menu + ", orderDate=" + orderDate
				+ "]";
	}
	
	
	
}
