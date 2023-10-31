package com.tyss.schoolRegistration.dao;


import com.tyss.schoolRegistration.entity.School;
import com.tyss.schoolRegistration.entity.Student;
import com.tyss.schoolRegistration.exception.SchoolNotAvailable;
import com.tyss.schoolRegistration.exception.StudentAlreadyAvailable;

public class StudentDao {
	
	private SchoolDao dao = new SchoolDao();
	
	public boolean addStudent(int studentId, String studentName, String studentAddress, int studentStandard, int studentSchoolId) {
		School school = dao.getSchool(studentSchoolId);
		
		if (school == null) {
			throw new SchoolNotAvailable("School is Not School");
		} else {
			Student student = getStudent(studentId, studentSchoolId);
			if (student == null) {
				school.getStudents().add(new Student(studentId, studentName, studentAddress, studentStandard, studentSchoolId));
				return true;
			} else {
				throw new StudentAlreadyAvailable("Student is Admitted in School");
			}
		}
	}
	
	public boolean removeStudent(int studentId, int studentSchoolId) {
		School school = dao.getSchool(studentSchoolId);
		Student student = getStudent(studentId, studentSchoolId);
		
		if (student == null) {
			return false;
		} else {
			school.getStudents().remove(student);
			return true;
		}
		
	}
		
	public Student getStudent(int studentId, int studentSchoolId) {
		School school = dao.getSchool(studentSchoolId);
		
		if (school == null || school.getStudents() == null) {
			return null;
		} else {
			for (Student student  : school.getStudents()) {
				if (studentId == student.getStudentId()) {
					return student;
				}
			}	
		}
		return null;
	}
	
	public boolean setStudent(int studentId, int studentSchoolId, String studentAddress) {
		Student student = getStudent(studentId, studentSchoolId);
		
		if (student == null) {
			return false;
		} else {
			student.setStudentAddress(studentAddress);
			return true;
		}
	}
}
