package com.invillia.acme.model;

public class Payment {

	private String status;
	private long creditCardNumber;
	private long paymentDate;
	
	public Payment() {}
	
	public Payment(String status, long creditCardNumber, long paymentDate) {
		this.setStatus(status);
		this.setCreditCardNumber(creditCardNumber);
		this.setPaymentDate(paymentDate);
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
	
	@Override
	public String toString() {
		return "Payment{"
				+ "status=" + status +
				", creditCardNumber=" + creditCardNumber +
				", paymentDate=" + paymentDate +
				"}";
	}
}
