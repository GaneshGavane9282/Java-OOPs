package com.testyantra.schooldatabase.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.testyantra.schooldatabase.entity.School;

public class SchoolDao {

	private static List<School> list = new ArrayList<School>();
	 
	public School addSchool(int id, String name, String address, long mobileNo) {
		School school = new School(id, name, address, mobileNo);
		list.add(school);
		return school;
	}
	
	public School setSchool(int id, long mobileNo) {
		School sc=null;
		for (School school : list) {
			if (school.getId() == id ) {
				sc = school;
				school.setMobileNo(mobileNo);
			}
		}
		return sc;
	}
	
	public boolean removeSchool(int id) {
	    Iterator<School> iterator = list.iterator();
	    boolean flag = false;
	    
	    while (iterator.hasNext()) {
	        School school = iterator.next();
	        if (school.getId() == id) {
	            iterator.remove(); // Safely remove the school from the list
	            flag = true;
	        }
	    }
	    
	    return flag;
	}

	
	public School getSchool(int id) {
		School sc = null;
		for (School school : list) {
			if (school.getId() == id) {
				sc = school;
			}
		}
		return sc;
	}
	
	public static List<School> getAllSchool() {
		return SchoolDao.list;
	}
}
