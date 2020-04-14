package model.vo;

import java.io.Serializable;

public class Seat implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2312418909865931124L;
	
	private int tableNum;
	private int price;
	public Seat() {
		super();
	}
	public Seat(int tableNum, int price) {
		super();
		this.tableNum = tableNum;
		this.price = price;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Seat [tableNum=" + tableNum + ", price=" + price + "]";
	}
	
	
}
