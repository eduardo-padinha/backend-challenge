package com.invillia.acme.model;

public class OrderItem {

	private int id;
	private String description;
	private double unitPrice;
	private int quantity;
	private Payment payment;
	
	public OrderItem() {}
	
	public OrderItem(int id, String description, double unitPrice, int quantity, Payment payment) {
		this.setId(id);
		this.setDescription(description);
		this.setUnitPrice(unitPrice);
		this.setQuantity(quantity);
		this.setPayment(payment);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	@Override
	public String toString() {
		return "OrderItem{"
				+ "id=" + id
				+ "description=" + description +
				", unitPrice=" + unitPrice +
				", quantity=" + quantity +
				"}";
	}
}
