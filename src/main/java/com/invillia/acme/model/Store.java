package com.invillia.acme.model;

public class Store {

	private int id;
	
	private String name;
	
	private String address;
	
	public Store() {}
	
	public Store(String name, String address) {
		this.setName(name);
		this.setAddress(address);
	}
	
	public Store(int id, String name, String address) {
		this.setId(id);
		this.setName(name);
		this.setAddress(address);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
				+ "id=" + id
				+ "name=" + name +
				", address=" + address +
				"}";
	}
}
