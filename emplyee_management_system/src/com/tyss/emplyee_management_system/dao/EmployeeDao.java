package com.tyss.emplyee_management_system.dao;

import java.util.List;


import com.tyss.emplyee_management_system.entity.Department;
import com.tyss.emplyee_management_system.entity.Employee;
import com.tyss.emplyee_management_system.exception.DepartmentNotAvailable;
import com.tyss.emplyee_management_system.exception.EmployeeNotAvailable;
import com.tyss.emplyee_management_system.exception.InvalidAuthorzationException;

public class EmployeeDao {
	
	private static DepartmentDao departmentDao = new DepartmentDao();
	
	Department department;
	
	Employee employee;
	
	private static int empId = 1;
	
	public boolean addEmployee(int deptId, String empName, String empEmailId, String empPassword, double empSalary,
			String empDesignation) {
		employee = getEmployee(empId, deptId);
		if (department != null && employee == null) {
			department.getEmployees().add(new Employee(empId, deptId, empName, empEmailId, empPassword, empSalary, empDesignation));
			empId++;
			return true;
		}
		return false;
		
	}
	
	public Employee getEmployee(int empId, int deptId){
		department = departmentDao.getDepartment(deptId);
		
		if (department == null) {
			throw new DepartmentNotAvailable("Department Not available!");
		} else {
			for(Employee employee : department.getEmployees()) {
				if (employee.getEmpId() == empId) {
					return employee;
				}
			}
			return null;
		}
	}
	
	public boolean removeEmployee(int empId, int deptId) {
		employee = getEmployee(empId, deptId);
		
		if (employee == null) {
			throw new EmployeeNotAvailable("Employee Not Available!");
		} else {
			if (employee.getEmpDesignation().equalsIgnoreCase("Company Manager") || employee.getDeptId() == 1) {
				throw new InvalidAuthorzationException("\nYou don't have Authorization");
			}
			return department.getEmployees().remove(employee);
		}
	}
	
	public boolean setEmployee(int empId, int deptId, String empEmail, String oldEmpPassword, String empPassword) {
		employee = getEmployee(empId, deptId);
		if (department != null && employee == null) {
			return false;
		} else {
			if (employee.getEmpEmailId().equalsIgnoreCase(empEmail) && employee.getEmpPassword().equals(oldEmpPassword)) {
				employee.setEmpPassword(empPassword);
				return true;
			}
		}	return false;	
	}
	
	public List<Employee> getAllEmployeesInDepartment(int deptId) {
	    department = departmentDao.getDepartment(deptId);
	    if (department != null) {
	        return department.getEmployees();
	    } else {
	        return null;
	    }
	}
	
	public boolean setEmployeeDept(int empId, int oldDeptId, int newDeptId) {
		employee = getEmployee(empId, oldDeptId);
		Department newdepartment = departmentDao.getDepartment(newDeptId);
		if (department != null && employee == null && newdepartment == null) {
			return false;
		} else {
			employee.setDeptId(newDeptId);
		}	return false;	
	}
}
