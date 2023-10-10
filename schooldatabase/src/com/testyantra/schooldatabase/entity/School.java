package com.testyantra.schooldatabase.entity;

public class School {
	
	private int id;
	private String name;
	private String address;
	private long mobileNo;
	
	
	
	public School(int id, String name, String address, long mobileNo) {
		super();
		this.id = id;
		this.name = name.toUpperCase();
		this.address = address.toUpperCase();
		this.mobileNo = mobileNo;
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

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}


	@Override
	public String toString() {
		return id + "\t" + name + "\t" + address + "\t" + mobileNo;
	}
	
	
	
	
}
