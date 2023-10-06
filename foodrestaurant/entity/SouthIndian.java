package com.tyss.has_a_relationship.foodrestaurant.entity;

public class SouthIndian {
	
	private String dish;
	private int price;
	
	// Getter and Setter
	public String getDish() {
		return dish;
	}
	public void setDish(String dish) {
		this.dish = dish;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	// Constructor
	public SouthIndian(String dish, int price) {
		super();
		this.dish = dish;
		this.price = price;
	}
	
	// display method
	public void display() {
		System.out.println(this.dish + "-------------------" + this.price);
	}
}
