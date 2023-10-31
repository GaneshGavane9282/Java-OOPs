package com.tyss.schoolRegistration.entity;

public class Student{ 
	
	private int studentId;
	private String studentName;
	private String studentAddress;
	private int studentStandard;
	private int studentSchoolId;
	
	
	public Student(int studentId, String studentName, String studentAddress, int studentStandard, int studentSchoolId) {
		super();
		this.studentId = studentId;
		this.studentName = studentName.toLowerCase();
		this.studentAddress = studentAddress.toLowerCase();
		this.studentStandard = studentStandard;
		this.studentSchoolId = studentSchoolId;
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName.toLowerCase();
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress.toLowerCase();
	}
	public int getStudentStandard() {
		return studentStandard;
	}
	public void setStudentStandard(int studentStandard) {
		this.studentStandard = studentStandard;
	}
	public int getStudentSchoolId() {
		return studentSchoolId;
	}
	public void setStudentSchoolId(int studentSchoolId) {
		this.studentSchoolId = studentSchoolId;
	}

	@Override
	public String toString() {
		return "\n" + studentId + "\t" + studentName + "\t" + studentAddress + "\t" + studentStandard + "\t" + studentSchoolId ;
	}
	
}
