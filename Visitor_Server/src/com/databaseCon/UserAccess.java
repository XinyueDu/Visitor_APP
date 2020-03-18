package com.databaseCon;

public class UserAccess {
	public String userID;
	public String accessname;
	public String address;
	public UserAccess() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserAccess(String userID, String accessname, String address) {
		super();
		this.userID = userID;
		this.accessname = accessname;
		this.address = address;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getAccessname() {
		return accessname;
	}
	public void setAccessname(String accessname) {
		this.accessname = accessname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserAccess [userID=" + userID + ", accessname=" + accessname + ", address=" + address + "]";
	}

	
}
