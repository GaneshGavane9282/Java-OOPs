package com.tyss.schoolRegistration.dao;

import java.util.ArrayList;
import java.util.List;

import com.tyss.schoolRegistration.entity.School;
import com.tyss.schoolRegistration.exception.SchoolAlreadyAvailable;
import com.tyss.schoolRegistration.exception.SchoolNotAvailable;

public class SchoolDao {
	
	static List<School> schools = new ArrayList<School>();
	
	public boolean addSchool(int schoolId, String schoolName, String schoolAddress, long schoolMobNo) {
	    if (schools.isEmpty()) {
	        schools.add(new School(schoolId, schoolName, schoolAddress, schoolMobNo));
	        return true;
	    } else {
	        for (School school : schools) {
	            if (school.getSchoolId() == schoolId) {
	                throw new SchoolAlreadyAvailable("School is Already Available");
	            }
	        }
	        schools.add(new School(schoolId, schoolName, schoolAddress, schoolMobNo));
	        return true;
	    }
	}


	
	public boolean removeSchool(int schoolId) {
		if (schools.isEmpty()) {
			return false;
		} else {
			School school = getSchool(schoolId);
			if (school == null) {
				return false;
			} else {
				schools.remove(school);
				return true;
			}
		}
	}
	
	public School getSchool(int schoolId) {
		if (schools.isEmpty()) {
			return null;
		} else {
			for (School school : schools) {
				if (schoolId == school.getSchoolId()) {
					return school;
				}
			}
		}
		return null;
	}
	
	public School setSchool(int schoolId, long schoolMobNo) {
		if (schools.isEmpty()) {
			return null;
		} else {
			School school = getSchool(schoolId);
			if (school == null) {
				return null;
			} else {
				school.setSchoolMobNo(schoolMobNo);
				return school;
			}
		}
	}
	
	public List<School> getAllSchool() {
		if (schools.isEmpty()) {
			throw new SchoolNotAvailable("Schools Not Available");
		} else {
			return schools;
		}
	}
	
	public int chooseSchool(int choice) {
		if (schools.isEmpty()) {
			return -1;
		} else {
			return schools.get(choice-1).getSchoolId();
		}
	}
	
	public int schoolSize() {
		return schools.size();
	}
}
