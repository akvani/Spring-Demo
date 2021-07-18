package com.stackroute.universityapp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class University {
	
	
	@Id
	String universityid;
	
	String universityname;
	
	@OneToMany
	@JsonIgnore
	List<College> colleges;

	public String getUniversityid() {
		return universityid;
	}

	public void setUniversityid(String universityid) {
		this.universityid = universityid;
	}

	public String getUniversityname() {
		return universityname;
	}

	public void setUniversityname(String universityname) {
		this.universityname = universityname;
	}

	public List<College> getColleges() {
		return colleges;
	}

	public void setColleges(List<College> colleges) {
		this.colleges = colleges;
	}
	

}
