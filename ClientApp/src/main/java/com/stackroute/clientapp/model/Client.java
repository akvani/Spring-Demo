package com.stackroute.clientapp.model;

import java.time.LocalDateTime;

public class Client {
	
	String clientid;
	String clientname;
	String location;
	LocalDateTime publishtime;
	
	public Client()
	{
		publichtime=LocalDateTime.now();
	}
	
	public String getClientid() {
		return clientid;
	}
	public void setClientid(String clientid) {
		this.clientid = clientid;
	}
	public String getClientname() {
		return clientname;
	}
	public void setClientname(String clientname) {
		this.clientname = clientname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String toString()
	{
		return "client id " + clientid + " client name is " + clientname + "locatio  " + location;
	}

}
