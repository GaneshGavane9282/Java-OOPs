package com.tyss.schoolRegistration.Driver;

import java.util.List;
import java.util.Scanner;

import com.tyss.schoolRegistration.dao.SchoolDao;
import com.tyss.schoolRegistration.dao.StudentDao;
import com.tyss.schoolRegistration.entity.School;
import com.tyss.schoolRegistration.entity.Student;
import com.tyss.schoolRegistration.exception.SchoolAlreadyAvailable;
import com.tyss.schoolRegistration.exception.SchoolNotAvailable;
import com.tyss.schoolRegistration.exception.StudentAlreadyAvailable;

public class SchoolStudentDriver {
	
	static Scanner scanner = new Scanner(System.in);
	
	static SchoolDao dao = new SchoolDao();
	
	static StudentDao sDao = new StudentDao();
	
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
				System.out.println("Invalid Option Choosen! Please Choose Correct\n");
				break;
			}
			
		}
	}

	private static void mainMenu() {
		System.out.print("      Welcome      \n"
					   + "===================\n"
					   + "1. School Menu\n"
					   + "2. Student Menu\n"
					   + "3. Exit\n\n"
					   + "Enter the Option : ");
	}
	
	private static void schoolMenu() {
		System.out.print("\n1. Add School Details\n"
					   + "2. Search School Details\n"
					   + "3. Update School Details\n"
					   + "4. Display School Details\n"
					   + "5. Delete School Details\n"
					   + "6. Exit\n\n"
					   + "Enter the option : ");
	}
	
	private static void addSchool() {
		System.out.print("\nEnter the School Id        : ");
		int schoolId = scanner.nextInt();
		System.out.print("Enter the School Name      : ");
		String schoolName = scanner.nextLine();
		schoolName = scanner.nextLine();
		System.out.print("Enter the School Mobile No : ");
		long schoolMobNo = scanner.nextLong();
		System.out.print("Enter the School Address   : ");
		String schoolAddress = scanner.nextLine();
		schoolAddress = scanner.nextLine();
		
		try {
			dao.addSchool(schoolId, schoolName, schoolAddress, schoolMobNo);
			System.out.println("\nSchool Data Added Successfully");
		} catch (SchoolAlreadyAvailable e) {
			System.out.println("\n" + e.getMessage());
		}
	}
	
	private static void getSchool() {
		System.out.print("\nEnter the School Id         : ");
		int schoolId = scanner.nextInt();
		School school = dao.getSchool(schoolId);
		
		if (school != null) {
			System.out.println(school);
		} else {
			System.out.println("\nSchool is Not Available");
		}
	}
	

	private static void setSchool() {
		System.out.print("\nEnter the School Id         : ");
		int id = scanner.nextInt();
		System.out.print("Enter the New Mobile No      : ");
		long mobileNo = scanner.nextLong();
		School school = dao.setSchool(id, mobileNo);
		if (school != null) {
			System.out.println("\nSchool Deatils Updated Successfully");
		} else {
			System.out.println("\nSchool is Not Available");
		}		
	}
	
	private static void remove() {
		System.out.print("Enter the School Id: ");
	    int schoolId = scanner.nextInt();
	    boolean flag = dao.removeSchool(schoolId);
	     
	    if (flag) {
	    	System.out.println("\nSchool Removed Successfully");
		} else {
			System.out.println("\nSchool is Not Available");
		}	
	}
	
	private static void getAllSchool() {
		try {
			List<School> schools = dao.getAllSchool();
			//System.out.println("\nSchool Id\tSchool Name\tSchool Address\tSchool Mob");
			for (School school : schools) {
				System.out.println(school);
			}
		} catch (SchoolNotAvailable e) {
			System.out.println("\n" + e.getMessage());
		}
	}
	
	// Student Main Menu
	private static void studentMenu() {
		System.out.print("\n1. Add Student Details\n"
					   + "2. Search Student Details\n"
					   + "3. Update Student Details\n"
					   + "4. Display Student Details\n"
					   + "5. Delete Student Details\n"
					   + "6. Exit\n\n"
					   + "Enter the option : ");
	}
	
	private static void addStudent() {
		getAllSchool();
		System.out.print("\nChoose the School for Admission : ");
		int schoolChoose = scanner.nextInt();
		
		if (schoolChoose > dao.schoolSize()) {
			System.out.println("\nEntered Wrong Option");
		} else {
			int schoolId = dao.chooseSchool(schoolChoose);
			
			if (schoolId == -1) {
				System.out.println("School is not availble");
			} else {
				System.out.print("\nEnter the Student Id       : ");
				int studentId = scanner.nextInt();
				System.out.print("Enter the Student Name       : ");
				String studentName = scanner.nextLine();
				studentName = scanner.nextLine();
				System.out.print("Enter the Student Standard   : ");
				int studentStandard = scanner.nextInt();
				System.out.print("Enter the Student Address    : ");
				String address = scanner.nextLine();
				address = scanner.nextLine();
				
				try {
					boolean flag = sDao.addStudent(studentId, studentName, address, studentStandard, schoolId);
					if (flag) {
						System.out.println("\nStudent Admission done successfully");
					} 
				} catch (SchoolAlreadyAvailable | StudentAlreadyAvailable e) {
					System.out.println("\n" + e.getMessage());
				}
			}
		}
	}
	
	private static void getStudent() {
		System.out.print("Enter the Student Id        : ");
		int studentId = scanner.nextInt();
		System.out.print("Enter the School Id         : ");
		int schoolId = scanner.nextInt();
		Student student = sDao.getStudent(studentId, schoolId);
		if (student != null) {
			System.out.println(student);
		} else {
			System.out.println("\nStudent not available");
		}
	}
	
	private static void updateStudent() {
		System.out.print("Enter the Student Id        : ");
		int studentId = scanner.nextInt();
		System.out.print("Enter the School Id         : ");
		int schoolId = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter the Changed Address   : ");
		String studentAddress = scanner.nextLine();
		
		boolean flag = sDao.setStudent(studentId, schoolId, studentAddress);
		if (flag) {
			System.out.println("\nStudent Address Changed Successfully");
		} else {
			System.out.println("\nStudent not available");
		}		
	}
	
	private static void removeStudent() {
		System.out.print("Enter the Student Id        : ");
		int studentId = scanner.nextInt();
		System.out.print("Enter the School Id         : ");
		int schoolId = scanner.nextInt();
		
		boolean flag = sDao.removeStudent(studentId, schoolId);
		if (flag) {
			System.out.println("Student is Removed from School Successfully");
		} else {
			System.out.println("Student Not available");
		}
	}
	
	private static void getAllStudent() {
		try {
			List<School> schools = dao.getAllSchool();
			for (School school : schools) {
				List<Student> students = school.getStudents();
				if (students != null) {
					//System.out.println("\nStudent Id\tStudent Name\tStudent Address\tStandard\tSchool Id");
					for (Student student : students) {
						System.out.println(student);
					}
				}
				System.out.println("\n=================================\n");
			}
			
		} catch (SchoolNotAvailable e) {
			System.out.println(e.getMessage());
		}
		
	}

}
