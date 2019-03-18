package com.invillia.acme.model;

public class Order {
	
	private String address;
	private long confirmationDate;
	private String status;
	
	public Order() {}
	
	public Order(String address, long confirmationDate, String status) {
		this.setAddress(address);
		this.setConfirmationDate(confirmationDate);
		this.setStatus(status);
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
				+ "address=" + address +
				", confirmationDate=" + confirmationDate +
				", status=" + status +
				"}";
	}
}
