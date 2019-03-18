package com.invillia.acme.model;

public class Payment {

	private int id;
	
	private String status;
	
	private long creditCardNumber;
	
	private long paymentDate;
	
	private int orderId;
	
	private int orderItemId;
	
	public Payment() {}
	
	public Payment(String status, long creditCardNumber, long paymentDate, int orderItemId, int orderId) {
		this.setStatus(status);
		this.setCreditCardNumber(creditCardNumber);
		this.setPaymentDate(paymentDate);
		this.setOrderId(orderId);
		this.setOrderItemId(orderItemId);
	}
	
	public Payment(int id, String status, long creditCardNumber, long paymentDate) {
		this.setId(id);
		this.setStatus(status);
		this.setCreditCardNumber(creditCardNumber);
		this.setPaymentDate(paymentDate);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public long getCreditCardNumber() {
		return creditCardNumber;
	}
	
	public void setCreditCardNumber(long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	
	public long getPaymentDate() {
		return paymentDate;
	}
	
	public void setPaymentDate(long paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	@Override
	public String toString() {
		return "Payment{"
				+ "id=" + id
				+ "status=" + status +
				", creditCardNumber=" + creditCardNumber +
				", paymentDate=" + paymentDate +
				"}";
	}
}
