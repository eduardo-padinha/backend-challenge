package com.invillia.acme.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment_table")
public class Payment {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	@Column(name="status")
	private String status;
	
	@Column(name="creditCardNumber")
	private long creditCardNumber;
	
	@Column(name="paymentDate")
	private long paymentDate;
	
	public Payment() {}
	
	public Payment(String status, long creditCardNumber, long paymentDate) {
		this.setStatus(status);
		this.setCreditCardNumber(creditCardNumber);
		this.setPaymentDate(paymentDate);
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
