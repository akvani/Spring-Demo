package com.org.FirstApplication;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class Employee {
	
	 String empid;
	 String empname;
	 
	 
	
	 Project project;

	 @Autowired
	 Employee(Project proj)
	 {
		 this.project=proj;
	 }
	 
	 public void displayCount()
	 {
		 System.out.println("you have created employee instance");
	 }
	
	 public void closeFile()
	 {
		 System.out.println("Employee object is closed");
	 }
	 
	 Map address;
	 
	 public Map getAddress() {
		return address;
	}

	public void setAddress(Map address) {
		this.address = address;
	}

	Employee()
	 {
		 
	 }
	 
	 Employee(Project proj,String eid)
	 {
		 this.project=proj;
		 this.empid=eid;
	 }
	 
	 public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	int salary;
	 
	 
	 public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	 

}
