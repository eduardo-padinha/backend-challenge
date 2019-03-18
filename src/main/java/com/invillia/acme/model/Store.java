package com.invillia.acme.model;

public class Store {

	private String name;
	private String address;
	
	public Store() {}
	
	public Store(String name, String address) {
		this.setName(name);
		this.setAddress(address);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Store{"
				+ "name=" + name +
				", address=" + address +
				"}";
	}
}
