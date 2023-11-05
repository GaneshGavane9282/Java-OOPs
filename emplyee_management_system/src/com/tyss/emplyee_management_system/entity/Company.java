package com.tyss.emplyee_management_system.entity;

import java.util.ArrayList;
import java.util.List;

public class Company {

	private final int companyID;
	private final String companyName;
	private final String companyGST;
	private String companyAddress;
	private List<Department> departments = new ArrayList<Department>();
	
	private static Company company;
	
	private Company(int companyID, String companyName, String companyGST, String companyAddress) {
		super();
		this.companyID = companyID;
		this.companyName = companyName.toUpperCase();
		this.companyGST = companyGST.toUpperCase();
		this.companyAddress = companyAddress.toUpperCase();
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getCompanyGST() {
		return companyGST;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> depatments) {
		this.departments = depatments;
	}

	public int getCompanyID() {
		return companyID;
	}
	
	public static Company company(int companyID, String companyName, String companyGST, String companyAddress) {
		if (company == null) {
			return company = new Company(companyID, companyName, companyGST, companyAddress);
		} else {
			return company;
		}
	}

	@Override
	public String toString() {
		return "\nCompany Id      : " + companyID 
			 + "\nCompany Name    : " + companyName 
			 + "\nCompanyGST      : " + companyGST
			 + "\nCompany Address : " + companyAddress + "\n";
			 //+ "\nDepartments     : " + departments + "\n";
	}
	
	
	
}
