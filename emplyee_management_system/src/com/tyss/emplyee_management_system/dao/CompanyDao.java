package com.tyss.emplyee_management_system.dao;

import com.tyss.emplyee_management_system.entity.Company;

public class CompanyDao {
	
	private static Company company = Company.company(1, "MG Technologies", "09UY37VF43233I", "Pune"); 
	
	public static Company getCompany() {
		return company;
	}
	
}	
