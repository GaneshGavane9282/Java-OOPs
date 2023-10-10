package com.testyantra.schooldatabase.entity;

public class Student {
	
		private int id;
		private String name;
		private String address;
		private long mobNo;
		private int schoolId;
		
		public Student(int id, String name, String address, long mobNo, int schoolId) {
			super();
			this.id = id;
			this.name = name.toUpperCase();
			this.address = address.toUpperCase();
			this.mobNo = mobNo;
			this.setSchoolId(schoolId);
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}


		public long getMobNo() {
			return mobNo;
		}


		public void setMobNo(long mobNo) {
			this.mobNo = mobNo;
		}


		public int getSchoolId() {
			return schoolId;
		}

		
		public void setSchoolId(int schoolId) {
			this.schoolId = schoolId;
		}


		@Override
		public String toString() {
			return id + "\t" + schoolId + "\t" + name + "\t" + mobNo + "\t" + address;
		}
		
		
		
		
		
}
