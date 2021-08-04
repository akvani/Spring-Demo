package com.stackroute.authorize.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Userprofile {

	@Id
	String emailid;
	String password;
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
