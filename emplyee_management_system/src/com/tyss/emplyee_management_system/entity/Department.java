package com.tyss.emplyee_management_system.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department {

	private int deptID;
	private int companyId;
	private String deptName;
	private List<Employee> employees = new ArrayList<Employee>();
	
	public Department(int deptID, int companyId, String deptName) {
		super();
		this.deptID = deptID;
		this.setCompanyId(companyId);
		this.deptName = deptName.toUpperCase();
	}
	
	public int getDeptID() {
		return deptID;
	}
	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName.toUpperCase();
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "\nDepartment Id   : " + deptID 
			 + "\nDepartment Name : " + deptName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(companyId, deptID, deptName, employees);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return companyId == other.companyId && deptID == other.deptID && Objects.equals(deptName, other.deptName)
				&& Objects.equals(employees, other.employees);
	} 
	
	
}
