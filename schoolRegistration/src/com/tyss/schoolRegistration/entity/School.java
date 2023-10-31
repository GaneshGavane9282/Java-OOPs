package com.tyss.schoolRegistration.entity;

import java.util.ArrayList;
import java.util.List;

public class School {
	
	private int schoolId;
	private String schoolName;
	private String schoolAddress;
	private long schoolMobNo;
	private List<Student> students = new ArrayList<Student>();
	
	
	
	public School(int schoolId, String schoolName, String schoolAddress, long schoolMobNo) {
		super();
		this.schoolId = schoolId;
		this.schoolName = schoolName.toLowerCase();
		this.schoolAddress = schoolAddress.toLowerCase();
		this.schoolMobNo = schoolMobNo;
	}

	public int getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName.toLowerCase();
	}

	public String getSchoolAddress() {
		return schoolAddress;
	}

	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress.toLowerCase();
	}

	public long getSchoolMobNo() {
		return schoolMobNo;
	}

	public void setSchoolMobNo(long schoolMobNo) {
		this.schoolMobNo = schoolMobNo;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "\n" + schoolId + "\t" + schoolName + "\t" + schoolAddress + "\t" + schoolMobNo;
	}
	
}
