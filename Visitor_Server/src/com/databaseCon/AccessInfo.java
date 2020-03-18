package com.databaseCon;

public class AccessInfo {
	public  String  accessname;
	public String  accesstype;
	public String  address;
	public  int    random;
	public AccessInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccessInfo(String accessname, String accesstype, String address, int random) {
		super();
		this.accessname = accessname;
		this.accesstype = accesstype;
		this.address = address;
		this.random = random;
	}
	public String getAccessname() {
		return accessname;
	}
	public void setAccessname(String accessname) {
		this.accessname = accessname;
	}
	public String getAccesstype() {
		return accesstype;
	}
	public void setAccesstype(String accesstype) {
		this.accesstype = accesstype;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getRandom() {
		return random;
	}
	public void setRandom(int random) {
		this.random = random;
	}
	@Override
	public String toString() {
		return "AccessInfo [accessname=" + accessname + ", accesstype=" + accesstype + ", address=" + address
				+ ", random=" + random + "]";
	}
	

}
