package com.tyss.emplyee_management_system.entity;

public class Employee {
	
	private int empId;
	private int deptId;
	private String empName;
	private String empEmailId;
	private String empPassword;
	private double empSalary;
	private String empDesignation;
	
	public Employee(int empId, int deptId, String empName, String empEmailId, String empPassword, double empSalary,
			String empDesignation) {
		super();
		this.empId = empId;
		this.deptId = deptId;
		this.empName = empName.toUpperCase();
		this.empEmailId = empEmailId.toLowerCase();
		this.empPassword = empPassword;
		this.empSalary = empSalary;
		this.empDesignation = empDesignation.toUpperCase();
	}

	public String getEmpEmailId() {
		return empEmailId;
	}

	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	@Override
	public String toString() {
		return "\nEmployee Id          : " + empId 
			 + "\nDepartment Id        : " + deptId 
			 + "\nEmployee Name        : " + empName 
			 + "\nEmployee Email Id    : " + empEmailId
			 + "\nEmployee Password    : " + empPassword 
			 + "\nEmployee Salary      : " + empSalary 
			 + "\nEmployee Designation : " + empDesignation + "\n";
	}
	
	
}
