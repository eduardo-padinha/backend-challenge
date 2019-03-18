package com.invillia.acme.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_table")
public class Order {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	@Column(name="address")
	private String address;
	
	@Column(name="confirmationDate")
	private long confirmationDate;
	
	@Column(name="orderStatus")
	private String status;
	
	private List<OrderItem> orderItems;
	private Payment payment;
	
	public Order() {}
	
	public Order(String address, long confirmationDate, String status) {
		this.setAddress(address);
		this.setConfirmationDate(confirmationDate);
		this.setStatus(status);
	}
	
	public Order(int id, String address, long confirmationDate, String status) {
		this.setId(id);
		this.setAddress(address);
		this.setConfirmationDate(confirmationDate);
		this.setStatus(status);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public long getConfirmationDate() {
		return confirmationDate;
	}
	
	public void setConfirmationDate(long confirmationDate) {
		this.confirmationDate = confirmationDate;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Order{"
				+ "id=" + id 
				+ "address=" + address +
				", confirmationDate=" + confirmationDate +
				", status=" + status +
				"}";
	}
}
