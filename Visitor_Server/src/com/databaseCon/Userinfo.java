package com.databaseCon;

public class Userinfo {
	public String userID;
	public String username;
	public String password;
	public String email;
	public String state;
	public String userimg;
	
	
	public Userinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Userinfo(String userID, String username, String password, String email, String state, String userimg) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.email = email;
		this.state = state;
		this.userimg = userimg;
	}



	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}
	
	public String getUserimg() {
		return userimg;
	}

	public void setUserimg(String userimg) {
		this.userimg = userimg;
	}



	@Override
	public String toString() {
		return "Userinfo [userID=" + userID + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", state=" + state + ", userimg=" + userimg + "]";
	}
	
}
