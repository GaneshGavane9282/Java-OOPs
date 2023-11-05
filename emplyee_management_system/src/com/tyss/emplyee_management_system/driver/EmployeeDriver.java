package com.tyss.emplyee_management_system.driver;

import java.util.InputMismatchException;

import java.util.List;
import java.util.Scanner;

import com.tyss.emplyee_management_system.dao.CompanyDao;
import com.tyss.emplyee_management_system.dao.DepartmentDao;
import com.tyss.emplyee_management_system.dao.EmployeeDao;
import com.tyss.emplyee_management_system.entity.Department;
import com.tyss.emplyee_management_system.entity.Employee;
import com.tyss.emplyee_management_system.exception.DepartmentAlreadyAvailable;
import com.tyss.emplyee_management_system.exception.DepartmentCannotDeleted;
import com.tyss.emplyee_management_system.exception.DepartmentNotAvailable;
import com.tyss.emplyee_management_system.exception.EmployeeNotAvailable;
import com.tyss.emplyee_management_system.exception.InvalidAuthorzationException;

public class EmployeeDriver {
	
	private static Scanner scanner = new Scanner(System.in);
	
	private static DepartmentDao departmentDao = new DepartmentDao();
	
	private static EmployeeDao employeeDao = new EmployeeDao();
	
	private static int deptId;
	
	public static void main(String[] args) {
		addInbuitDeptEmp();
		
		boolean menuFlag = true;
		while (menuFlag) {
			int menuOption = mainMenu();
			
			switch (menuOption) {
			case 1:
				String companyLogin = login();
				if (companyLogin != null && companyLogin.equalsIgnoreCase("Company Manager")) {
					boolean companyFlag = true;
					
					while (companyFlag) {
						 int companyMenu = companyMenu();
						 switch (companyMenu) {
						 case 1:
							 System.out.println(CompanyDao.getCompany());
							break;
							
						 case 2:
							getAllDepartments();
							break;
							
						 case 3:
							addDepartment();
							break;
							
						 case 4:
							setDepartment();
							break;
							
						 case 5:
							removeDepartment();
							break;
							
						 case 6:
							 shiftEmployee();
							 break;
							 
						 case 7:
							 companyFlag = false;
							 break;

						 default:
							 System.out.println("\nPlease Enter the Correct Option\n");
							 break;
						}
					}
				} else {
					System.out.println("\nInvalid Credentials\n");
				}
				break;
				
			case 2:
				String departmentLogin = login();
				if (departmentLogin != null && (departmentLogin.equalsIgnoreCase("Department Manager") || departmentLogin.equalsIgnoreCase("Company Manager"))) {
					boolean departmentFlag = true;
					while (departmentFlag) {
						int departmentMenu = departmentMenu();
						
						switch (departmentMenu) {
						case 1:
							getDepartmentDetails();
							break;
							
						case 2:
							addEmployee();
							break;
							
						case 3:
							getDeptEmployee();
							break;
							
						case 4:
							removeEmployee();
							break;
						
						case 5:
							departmentFlag = false;
							break;

						default:
							System.out.println("\nPlease Enter the Correct Option\n");
							break;
						}
					}
				} else {
					System.out.println("\nInvalid Credentials\n");
				}
				break;
				
			case 3:
				String employeeLogin = login();
				if (employeeLogin != null && (employeeLogin.equalsIgnoreCase("Employee") || employeeLogin.equalsIgnoreCase("Company Manager") || employeeLogin.equalsIgnoreCase("Department Manager"))) {
					boolean employeeFlag = true;
					while (employeeFlag) {
						int employeeMenu = employeeMenu();
						
						switch (employeeMenu) {
						case 1:
							getEmployee();
							break;
						
						case 2:
							setEmployee();
							break;
							
						case 3:
							employeeFlag = false;
							break;

						default:
							System.out.println("\nPlease Enter the Correct Option\n");
							break;
						}
					}
				} else {
					System.out.println("\nInvalid Credentials\n");
				}
				break;
				
			case 4:
				menuFlag = false;
				break;

			default:
				System.out.println("\nPlease Enter the Correct Option\n\n");
				break;
			}
		}
	}
	
	private static void addInbuitDeptEmp() {
		departmentDao.addDepartment(1, "Management");
		employeeDao.addEmployee(1, "Ganesh", "ganesh@gmail.com", "ganesh@123", 10000, "Company Manager");
	}
	
	private static int mainMenu() {
        int option = 0;
        boolean flag = true;

        while (flag) {
            try {
                System.out.print("1. Company Login\n"
                        + "2. Department Login\n"
                        + "3. Employee Login\n"
                        + "4. Exit\n\n"
                        + "Enter the option : ");
                option = scanner.nextInt();
                flag = false;
            } catch (InputMismatchException e) {
                System.out.print("\nPlease Enter the Correct Option\n\n");
                scanner.nextLine(); // Clear the input buffer
            }
        }
        return option;
    }
	
	private static String login() {
		boolean flag = true;
		
		while (flag) {
			try {
				List<Department> departments = CompanyDao.getCompany().getDepartments();
				for (Department department : departments) {
					System.out.println(department);
				}
				System.out.print("\nEnter the Department Id    : ");
				int deptId = scanner.nextInt();
				Department department = departmentDao.getDepartment(deptId);
				if (department == null || department.getEmployees().isEmpty()) {
					System.out.println("\nNo Account Found! Please Create an Account\n");
					return null;
				} else {
					scanner.nextLine();
					System.out.print("\nEnter the Designation       : ");
					String empDesignation = scanner.nextLine();
					
					System.out.print("Enter the Employee Email    : ");
					String empEmail = scanner.nextLine();
					
					System.out.print("Enter the Employee Password : ");
					String empPassword = scanner.nextLine();
					
					flag = false;
					List<Employee> employees = employeeDao.getAllEmployeesInDepartment(deptId);
					
					for (Employee employee : employees) {
						if (employee.getEmpDesignation().equalsIgnoreCase(empDesignation) && employee.getEmpEmailId().equalsIgnoreCase(empEmail) && employee.getEmpPassword().equals(empPassword)) {
							EmployeeDriver.deptId = employee.getDeptId();
							return empDesignation;
						}
					}
					System.out.println("\nPlease Enter the Correct Credentials\n");
					return null;
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid input. Please enter a valid number.\n");
	            scanner.nextLine();
			}
		}
		return null;
	}
	
	private static void addEmployee() {
		Department department = departmentDao.getDepartment(1);
		 try {  
			 	scanner.nextLine();
	            System.out.print("Enter Employee Name           : ");
	            String empName = scanner.nextLine();
	            
	            System.out.print("Enter Employee Email ID       : ");
	            String empEmailId = scanner.nextLine();
	            
	            System.out.print("Enter Employee Password       : ");
	            String empPassword = scanner.nextLine();
	            
	            System.out.print("Enter Employee Salary (double): ");
	            double empSalary = scanner.nextDouble();
	            scanner.nextLine();
	            
	            System.out.print("Enter Employee Designation    : ");
	            String empDesignation = scanner.nextLine();
	     
	            boolean flag = employeeDao.addEmployee(department.getDeptID(), empName, empEmailId, empPassword, empSalary, empDesignation);
	            
	            if (flag) {
					System.out.println("\nEmployee Added Successfully\n");
				} else {
					System.out.println("\nPlease Enter the Correct Employee Details\n");
				}
	            
	        } catch (InputMismatchException | DepartmentNotAvailable e) {
	            System.out.println("\nInvalid input. Please enter a valid number.\n");
	            scanner.nextLine();
	        }
	}
	
	private static int companyMenu() {
		int option = 0;
		boolean flag = true;
		
		while (flag) {
			try {
				System.out.print("\n1. See Comapany Details\n"
							   + "2. See Department Details\n"
							   + "3. Add Department Details\n"
							   + "4. Update Department Details\n"
							   + "5. Delete Department Details\n"
							   + "6. Change Employee Department\n"
							   + "7. Exit\n\n"
							   + "Enter the Option : ");
				option = scanner.nextInt();
				flag = false;
			} catch (InputMismatchException e) {
				System.out.print("\nPlease Enter the Correct Option\n\n");
                scanner.nextLine();
			}
		}
		return option;
	}
	
	private static void getAllDepartments() {
		List<Department> departments = departmentDao.department();
		
		for (Department department : departments) {
			System.out.println(department);
		}
	}
	
	private static void addDepartment() {
		boolean dflag = true;
		
		while (dflag) {
			try {
				System.out.print("\nEnter the Department Id   : ");
				int deptId = scanner.nextInt();
				System.out.print("Enter the Department Name : ");
				String deptName = scanner.next();
				
				dflag = false;
				try {
					boolean flag = departmentDao.addDepartment(deptId, deptName);
					if (flag) {
						System.out.println("\nDepartment Added Successfully\n");
					}
				} catch (DepartmentAlreadyAvailable e) {
					System.out.println("\nPlease Add Another Department\n");
					addDepartment();
				}
			} catch (InputMismatchException e) {
				System.out.print("\nPlease Enter the Correct Option\n\n");
                scanner.nextLine();
			}
		}
	}
	
	private static void setDepartment() {
		boolean dflag = true;
		
		while (dflag) {
			try {
				System.out.print("\nEnter the Department Id       : ");
				int deptId = scanner.nextInt();
				System.out.print("Enter the New Department Name : ");
				String deptName = scanner.next();
				
				dflag = false;
				try {
					boolean flag = departmentDao.setDepartment(deptId, deptName);
					if (flag) {
						System.out.println("\nDepartment Name Updated Successfully\n");
					}
				} catch (DepartmentNotAvailable e) {
					System.out.println("\nPlease Enter Correct Department Deatils\n");
				}
			} catch (InputMismatchException e) {
				System.out.print("\nPlease Enter the Correct Option\n\n");
	            scanner.nextLine();
			}
		}
	}
	
	private static void removeDepartment() {
		boolean dflag = true;
		
		while (dflag) {
			try {
				System.out.print("\nEnter the Department Id       : ");
				int deptId = scanner.nextInt();
				dflag = false;
				try {
					boolean flag = departmentDao.removeDepartment(deptId);
					if (flag) {
						System.out.println("\nDepartment Removed Successfully\n");
					}
				} catch (DepartmentNotAvailable | DepartmentCannotDeleted e) {
					System.out.println("\nPlease Enter Correct Department Deatils\n");
				}
			} catch (InputMismatchException e) {
				System.out.print("\nPlease Enter the Correct Option\n\n");
	            scanner.nextLine();
			}
		}
	}
	
	private static void shiftEmployee() {
		boolean dflag = true;
		
		while (dflag) {
			try {
				System.out.print("Enter the Emoloyee Id       : ");
				int empId = scanner.nextInt();
				
				System.out.print("Enter the Old Department Id : ");
				int oldDeptId = scanner.nextInt();
				
				System.out.print("Enter the New Department Id : ");
				int newDeptId = scanner.nextInt();
				
				dflag = false;
				try {
					Employee employee = employeeDao.getEmployee(empId, oldDeptId);
					Department oldDepartment = departmentDao.getDepartment(oldDeptId);
					Department newDepartment = departmentDao.getDepartment(newDeptId);
					
					if (newDepartment != null && employee != null && oldDepartment != null) {
						oldDepartment.getEmployees().remove(employee);
						employee.setDeptId(newDeptId);
						boolean flag = newDepartment.getEmployees().add(employee);
						
						if (flag) {
							System.out.println("\nEmployee Shifted From Department " + oldDeptId + " to " + newDeptId + "\n");
						} else {
							System.out.println("\nEmployee not Shifted From Department " + oldDeptId + " to " + newDeptId + "\n");							
						}
						
					} else {
						System.out.println("\nPlease Enter the Correct Input\n");
					}
				} catch (DepartmentNotAvailable e) {
					System.out.println("\nPlease Enter the Correct Input\n");
				}
			} catch (InputMismatchException e) {
				System.out.print("\nPlease Enter the Correct Option\n\n");
	            scanner.nextLine();
			}
		}
	}
	
	private static int departmentMenu() {
		int option = 0;
		boolean flag = true;
		
		while (flag) {
			 try {
	             System.out.print("\n1. See Department Details\n"
	                        + "2. Add Employee Details\n"
	                        + "3. See Employee Details\n"
	                        + "4. Remove Employee Details\n"
	                        + "5. Exit\n\n"
	                        + "Enter the option         : ");
	                option = scanner.nextInt();
	                flag = false;
	            } catch (InputMismatchException e) {
	                System.out.print("\nPlease Enter the Correct Option\n\n");
	                scanner.nextLine(); // Clear the input buffer
	            }
		}
		return option;
	}
	
	private static void getDepartmentDetails() {
		System.out.println(departmentDao.getDepartment(deptId));
	}
	
	private static void getDeptEmployee() {
		Department department = departmentDao.getDepartment(deptId);
		if (department != null) {
			List<Employee> employees = department.getEmployees();
			
			for (Employee employee : employees) {
				System.out.println(employee);
			}
		} else {
			System.out.println("\nDepartment is not available\n");
		}
	}
	
	private static void removeEmployee() {
		boolean flag = true;
		
		while (flag) {
			try {
				System.out.print("\nEnter the Employee Id   : ");
				int empId = scanner.nextInt();
				
				System.out.print("Enter the Department Id   : ");
				int deptId = scanner.nextInt();
				flag = false;
				
				try {
					employeeDao.removeEmployee(empId, deptId);
				} catch (EmployeeNotAvailable | InvalidAuthorzationException e) {
					System.out.println(e.getMessage());
				}
				
			} catch (InputMismatchException e) {
				System.out.print("\nPlease Enter the Correct Option\n\n");
                scanner.nextLine();
			}
		}
	}
	
	private static int employeeMenu() {
		 int option = 0;
	     boolean flag = true;

	     while (flag) {
	        try {
	             System.out.print("\n1. See Employee Details\n"
	                        + "2. Upadate Password\n"
	                        + "3. Exit\n\n"
	                        + "Enter the option         : ");
	                option = scanner.nextInt();
	                flag = false;
	            } catch (InputMismatchException e) {
	                System.out.print("\nPlease Enter the Correct Option\n\n");
	                scanner.nextLine(); // Clear the input buffer
	            }
	        }
	        return option;
	}
	
	private static void getEmployee() {
		boolean flag = true;
		
		while (flag) {
			try {
				
				System.out.print("Enter the Employee Id   : ");
				int empId = scanner.nextInt();
				System.out.print("Enter the Department Id : ");
				int deptId = scanner.nextInt();
				
				flag = false;
				Employee employee = employeeDao.getEmployee(empId, deptId);
				System.out.println(employee);
				
			} catch (InputMismatchException | DepartmentNotAvailable e) {
				System.out.println("\nPlease Enter the Correct Input\n");
			}
		}
	}
	
	private static void setEmployee() {
		boolean flag = true;
		
		while (flag) {
			try {
				System.out.print("Enter Employee ID: ");
	            int empId = scanner.nextInt();

	            System.out.print("Enter Department ID: ");
	            int deptId = scanner.nextInt();

	            scanner.nextLine();
	            System.out.print("Enter Employee Email: ");
	            String empEmail = scanner.nextLine();
	            
	            System.out.print("Enter Old Employee Password: ");
	            String oldEmpPassword = scanner.nextLine();

	            System.out.print("Enter New Employee Password: ");
	            String empPassword = scanner.nextLine();
	            
	            flag = false;
	            boolean setFlag = employeeDao.setEmployee(empId, deptId, empEmail, oldEmpPassword, empPassword);
	            
	            if (setFlag) {
					System.out.println("\nPassword Reset Successfully");
				} else {
					System.out.println("\nPlease Enter the Correct Credentials\n");	
				}
			} catch (InputMismatchException e) {
				System.out.println("\nPlease Enter the Correct Input\n");
			}
		}
	}
}

