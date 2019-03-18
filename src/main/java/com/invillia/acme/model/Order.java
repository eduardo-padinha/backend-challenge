package com.invillia.acme.model;

public class Order {
	
	private int id;
	private String address;
	private long confirmationDate;
	private String status;
	
	public Order() {}
	
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
