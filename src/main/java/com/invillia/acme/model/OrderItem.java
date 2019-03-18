package com.invillia.acme.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderItem_table")
public class OrderItem {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="unitPrice")
	private double unitPrice;
	
	@Column(name="quantity")
	private int quantity;
	
	private Payment payment;
	
	public OrderItem() {}
	
	public OrderItem(String description, double unitPrice, int quantity, Payment payment) {
		this.setDescription(description);
		this.setUnitPrice(unitPrice);
		this.setQuantity(quantity);
		this.setPayment(payment);
	}
	
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
