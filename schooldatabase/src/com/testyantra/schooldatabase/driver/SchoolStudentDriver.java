package com.testyantra.schooldatabase.driver;

import java.util.List;
import java.util.Scanner;

import com.testyantra.schooldatabase.dao.SchoolDao;
import com.testyantra.schooldatabase.dao.StudentDao;
import com.testyantra.schooldatabase.entity.School;
import com.testyantra.schooldatabase.entity.Student;

public class SchoolStudentDriver {
	
	static Scanner scanner = new Scanner(System.in);
	static SchoolDao dao = new SchoolDao();
	static StudentDao dao2 = new StudentDao();
	
	public static void main(String[] args) {
		boolean flag = true;
		
		while (flag) {
			mainMenu();
			int key = scanner.nextInt();
			
			switch (key) {
			case 1:
				boolean schoolFlag = true; 
				while (schoolFlag) {
					schoolMenu();
					int option = scanner.nextInt();
					switch (option) {
					case 1:
						addSchool();
						break;
					
					case 2:
						getSchool();
						break;
						
					case 3:
						setSchool();
						break;
						
					case 4:
						getAllSchool();
						break;
						
					case 5:
						remove();
						break;
						
					case 6:
						schoolFlag = false;
						break;

					default:
						System.out.println("\nInvalid Option");
						break;
					}
				}
				break;
				
			case 2:
				boolean studentFlag = true; 
				while (studentFlag) {
					studentMenu();
					int option = scanner.nextInt();
					switch (option) {
					case 1:
						addStudent();
						break;
					
					case 2:
						getStudent();
						break;
						
					case 3:
						updateStudent();
						break;
						
					case 4:
						getAllStudent();
						break;
						
					case 5:
						removeStudent();
						break;
						
					case 6:
						studentFlag = false;
						break;
					}
				}
				break;

			default:
				System.out.println("Invalid Option\n");
				break;
			}
		}
	}
	
	public static void mainMenu() {
		System.out.print("      Welcome      \n"
					   + "===================\n"
					   + "1. School Menu\n"
					   + "2. Student Menu\n"
					   + "3. Exit\n\n"
					   + "Enter the Option : ");
	}
	
	public static void schoolMenu() {
		System.out.print("\n1. Add School Details\n"
					   + "2. Search School Details\n"
					   + "3. Update School Details\n"
					   + "4. Display School Details\n"
					   + "5. Delete School Details\n"
					   + "6. Exit\n\n"
					   + "Enter the option : ");
	}
	
	public static void addSchool() {
		System.out.print("\nEnter the School Id        : ");
		int id = scanner.nextInt();
		System.out.print("Enter the School Name      : ");
		String schoolName = scanner.nextLine();
		schoolName = scanner.nextLine();
		System.out.print("Enter the School Mobile No : ");
		long mobileNo = scanner.nextLong();
		System.out.print("Enter the School Address   : ");
		String address = scanner.nextLine();
		address = scanner.nextLine();
		
		dao.addSchool(id, schoolName, address, mobileNo);
		System.out.println("School Data Added Successfully");
	}
	
	public static void getSchool() {
		List<School> list = SchoolDao.getAllSchool(); 
		if (list.isEmpty()) {
			System.out.println("School Is Not Available");
		} else {
			System.out.print("\nEnter the School Id         : ");
			int id = scanner.nextInt();
			School school = dao.getSchool(id);
			if (school.getId() == id ) { 
				System.out.println("\nId\tSchool Name\tAddress\tMobileNo");
				System.out.println(school);
				System.out.println("\nId\tSchoolId\tName\tMobileNo\tAddress");
				for (Student student : dao2.getAllStudent()) {
					if (student.getSchoolId() == id) {
						System.out.println(student);
					}
				}
			} else {
				System.out.println("School Is Not exist");
			}
		}
	}
	
	public static void setSchool() {
		System.out.print("\nEnter the School Id         : ");
		int id = scanner.nextInt();
		System.out.print("Enter the New Mobile No      : ");
		long mobileNo = scanner.nextLong();
		dao.setSchool(id, mobileNo);
		System.out.println("School Deatils Updated Successfully");
	}
	
	public static void getAllSchool() {
		List<School> list = SchoolDao.getAllSchool();
		if (list.isEmpty()) {
			System.out.println("School Is Not Available");
		} else {
			System.out.println("\nId\tSchool Name\tAddress\tMobileNo");
			for (School school : list) {
				int id = school.getId();
				System.out.println(school);
				System.out.println("\nId\tSchoolId\tName\tMobileNo\tAddress");
				for (Student student : dao2.getAllStudent()) {
					if (id == student.getId()) {
						System.out.println(student);
					}
				}
			}
		}
	}
	
	public static void remove() {
	    List<School> list = SchoolDao.getAllSchool();
	    if (list.isEmpty()) {
	        System.out.println("Schools are not available.");
	    } else {
	        System.out.print("Enter the School Id: ");
	        int id = scanner.nextInt();
	        scanner.nextLine(); // Consume the newline character
	        System.out.print("Enter the School Name: ");
	        String schoolName = scanner.nextLine().toUpperCase();

	        boolean schoolFound = false;

	        for (School school : list) {
	            if (id == school.getId() && schoolName.equals(school.getName().toUpperCase())) {
	                dao2.removeStudent(id);
	                dao.removeSchool(id);
	                schoolFound = true;
	                break; // Exit the loop once a matching school is found and removed.
	            }
	        }

	        if (schoolFound) {
	            System.out.println("School removed successfully.");
	        } else {
	            System.out.println("School not found.");
	        }
	    }
	}

	
	
	public static void studentMenu() {
		System.out.print("\n1. Add Student Details\n"
					   + "2. Search Student Details\n"
					   + "3. Update Student Details\n"
					   + "4. Display Student Details\n"
					   + "5. Delete Student Details\n"
					   + "6. Exit\n\n"
					   + "Enter the option : ");
	}
	
	public static void addStudent() {
		System.out.print("\nEnter the Student Id       : ");
		int id = scanner.nextInt();
		System.out.print("Enter the School Id        : ");
		int sId = scanner.nextInt();
		System.out.print("Enter the Student Name       : ");
		String studentName = scanner.nextLine();
		studentName = scanner.nextLine();
		System.out.print("Enter the Student Mobile No  : ");
		long mobileNo = scanner.nextLong();
		System.out.print("Enter the Student Address    : ");
		String address = scanner.nextLine();
		address = scanner.nextLine();
		
		Student student = dao2.addStudent(id, studentName, address, mobileNo, sId);
		if (student != null) {
			System.out.println("Student Data Added Successfully");
		} else {
			System.out.println("School is not available");
		}
	}
	
	public static void getStudent() {
		List<Student> list = dao2.getAllStudent();
		if (list.isEmpty()) {
			System.out.println("Student Is Not Available");
		} else {
			System.out.print("Enter the Student Id        : ");
			int id = scanner.nextInt();
			System.out.print("Enter the School Id         : ");
			int sId = scanner.nextInt();
			for (Student student : list) {
				if (student.getId() == id && student.getSchoolId() == sId) {
					System.out.println(student);
				} else {
					System.out.println("Student Is Not Available");
				}
			}
		}
	}
	
	public static void removeStudent() {
		List<Student> list = dao2.getAllStudent();
		if (list.isEmpty()) {
			System.out.println("Student Is Not Available");
		} else {
			System.out.print("Enter the Student Id        : ");
			int id = scanner.nextInt();
			System.out.print("Enter the School Id         : ");
			int sId = scanner.nextInt();
			for (Student student : list) {
				if (student.getId() == id && student.getSchoolId() == sId) {
					list.remove(student);
					System.out.println("Student deleted Successfully");
				} else {
					System.out.println("Student Is Not Available");
				}
			}
		}
	}
	
	public static void updateStudent() {
		List<Student> list = dao2.getAllStudent();
		if (list.isEmpty()) {
			System.out.println("Student Is Not Available");
		} else {
			System.out.print("Enter the Student Id        : ");
			int id = scanner.nextInt();
			System.out.print("Enter the School Id         : ");
			int sId = scanner.nextInt();
			System.out.print("Enter the Mobile No         : ");
			long mobileNo = scanner.nextLong();
			for (Student student : list) {
				if (student.getId() == id && student.getSchoolId() == sId) {
					student.setMobNo(mobileNo);
					System.out.println("Mobile No Updated Successfully");
				} else {
					System.out.println("Student Is Not Available");
				}
			}
		}
	}
	
	public static void getAllStudent() {
		List<Student> list = dao2.getAllStudent();
		
		for (Student student : list) {
			System.out.println(student);
		}
	}

}

