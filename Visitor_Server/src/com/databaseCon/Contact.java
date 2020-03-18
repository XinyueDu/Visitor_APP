package com.databaseCon;

public class Contact {
	public String userid;
	public String name;
	public String accessState;
	public String  signs;
	public String  img;
	public String tel;
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contact(String userid, String name, String accessState, String signs, String img, String tel) {
		super();
		this.userid = userid;
		this.name = name;
		this.accessState = accessState;
		this.signs = signs;
		this.img = img;
		this.tel = tel;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccessState() {
		return accessState;
	}
	public void setAccessState(String accessState) {
		this.accessState = accessState;
	}
	public String getSigns() {
		return signs;
	}
	public void setSigns(String signs) {
		this.signs = signs;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "Contact [userid=" + userid + ", name=" + name + ", accessState=" + accessState + ", signs=" + signs
				+ ", img=" + img + ", tel=" + tel + "]";
	}
	
}
