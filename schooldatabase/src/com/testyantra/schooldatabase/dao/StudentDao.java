package com.testyantra.schooldatabase.dao;

import java.util.ArrayList;
import java.util.List;

import com.testyantra.schooldatabase.entity.School;
import com.testyantra.schooldatabase.entity.Student;

public class StudentDao {
	
	private List<Student> studentList = new ArrayList<Student>();
	
	// private SchoolDao dao = new SchoolDao();
		
	public Student addStudent(int id, String name, String address, long mobNo, int schoolId) {
	    Student st = null;

	    School targetSchool = null;
	    for (School school : SchoolDao.getAllSchool()) {
	        if (schoolId == school.getId()) {
	            targetSchool = school;
	            break; 
	        }
	    }
	    if (targetSchool != null) {
	        Student student = new Student(id, name, address, mobNo, schoolId);
	        studentList.add(student);
	        st = student;
	    } else {
	        System.out.println("School with ID " + schoolId + " not found.");
	    }
	    return st;
	}

		
	
	public Student updateStudent(int id,  int schoolId, long mobNo) {
		Student st = null;
		for (School school : SchoolDao.getAllSchool()) {
			if (schoolId == school.getId()) {
				for (Student student : studentList) {
					if (student.getId() == id) {
						student.setMobNo(mobNo);
						st = student;
					}
				}
			}
		}
		return st;
	}
	
	public boolean deleteStudent(int id, int schoolId) {
		boolean flag = false;
		for (School school : SchoolDao.getAllSchool()) {
			if (schoolId == school.getId()) {
				for (Student student : studentList) {
					if (student.getId() == id) {
						studentList.remove(student);
						flag = true;
					}
				}
			}
		}
		return flag;
	}
	
	public boolean removeStudent(int schoolId) {
		boolean flag = false;
		for (School school : SchoolDao.getAllSchool()) {
			if (schoolId == school.getId()) {
				for (Student student : studentList) {
					studentList.remove(student);
				}
			}
		}
		return flag;
	}
	
	public Student getStudent(int id, int schoolId) {
		Student st = null;
		for (School school : SchoolDao.getAllSchool()) {
			if (school.getId() == schoolId) {
				for (Student student : studentList) {
					if (student.getId() == id) {
						st = student;
					}
				}
			}
		}
		return st;
	}
	
	public List<Student> getAllStudent() {
		return studentList;
	}

}
