package com.tyss.emplyee_management_system.dao;

import java.util.List;

import com.tyss.emplyee_management_system.entity.Department;
import com.tyss.emplyee_management_system.exception.DepartmentAlreadyAvailable;
import com.tyss.emplyee_management_system.exception.DepartmentCannotDeleted;
import com.tyss.emplyee_management_system.exception.DepartmentNotAvailable;

public class DepartmentDao {
	
	private static List<Department> departments = CompanyDao.getCompany().getDepartments();
	
	public boolean addDepartment(int deptID, String deptName) {
	    Department department = getDepartment(deptID);
	    if (department == null) {
			return departments.add(new Department(deptID, CompanyDao.getCompany().getCompanyID(), deptName));
		} else {
			throw new DepartmentAlreadyAvailable("Department Already Available");
		}
	}

	public Department getDepartment(int deptId) {
	    if (departments.isEmpty()) {
	        return null;
	    } else {
	        for (Department department : departments) {
	            if (department.getDeptID() == deptId) {
	                return department;
	            }
	        }
	        return null;
	    }
	}
	
	public boolean removeDepartment(int deptId) {
		if (deptId != 1) {
			Department department = getDepartment(deptId);
			if (department == null) {
				throw new DepartmentNotAvailable("Department not available!");
			} else {
				return departments.remove(department);
			}
		} else {
			throw new DepartmentCannotDeleted("You Don't Have Permission");
		}
	}
	
	public boolean setDepartment(int deptId, String deptName) {
		Department department = getDepartment(deptId);
		if (department == null) {
			throw new DepartmentNotAvailable("Department not available!");
		} else {
			department.setDeptName(deptName);
			return true;
		}
	}
	
	public List<Department> department(){
		return departments;
	}
}
