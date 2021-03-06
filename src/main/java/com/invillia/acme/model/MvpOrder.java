package com.invillia.acme.model;

import java.util.List;

public class MvpOrder {
	
	private int id;
	
	private String address;
	
	private long confirmationDate;
	
	private String status;
	
	private List<OrderItem> orderItems;
	
	private Payment payment;
	
	public MvpOrder() {}
	
	public MvpOrder(String address, long confirmationDate, String status) {
		this.setAddress(address);
		this.setConfirmationDate(confirmationDate);
		this.setStatus(status);
	}
	
	public MvpOrder(int id, String address, long confirmationDate, String status) {
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
