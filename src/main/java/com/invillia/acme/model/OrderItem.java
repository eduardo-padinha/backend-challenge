package com.invillia.acme.model;

public class OrderItem {

	private String description;
	private double unitPrice;
	private int quantity;
	
	public OrderItem() {}
	
	public OrderItem(String description, double unitPrice, int quantity) {
		this.setDescription(description);
		this.setUnitPrice(unitPrice);
		this.setQuantity(quantity);
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getUnitPrice() {
		return unitPrice;
	}
	
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "OrderItem{"
				+ "description=" + description +
				", unitPrice=" + unitPrice +
				", quantity=" + quantity +
				"}";
	}
}
