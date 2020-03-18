package com.databaseCon;

public class Message {
	public String userid;
	public String contactname;
	public String  reason;
	public String data;
	public String  time;
	public String  state;
	public String  contactimg;
	public String  tel;
	public String  photo;
	public String comments;
	public String username;
	public String userimg;
	public int messageid;
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Message(String userid, String contactname, String reason, String data, String time, String state,
			String contactimg, String tel, String photo, String comments, String username, String userimg, int messageid) {
		super();
		this.userid = userid;
		this.contactname = contactname;
		this.reason = reason;
		this.data = data;
		this.time = time;
		this.state = state;
		this.contactimg = contactimg;
		this.tel = tel;
		this.photo = photo;
		this.comments = comments;
		this.username = username;
		this.userimg = userimg;
		this.messageid=messageid;
	}

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String getContactname() {
		return contactname;
	}

	public void setContactname(String contactname) {
		this.contactname = contactname;
	}

	public String getContactimg() {
		return contactimg;
	}

	public void setContactimg(String contactimg) {
		this.contactimg = contactimg;
	}

	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserimg() {
		return userimg;
	}
	public void setUserimg(String userimg) {
		this.userimg = userimg;
	}
	
	public int getMessageid() {
		return messageid;
	}

	public void setMessageid(int messageid) {
		this.messageid = messageid;
	}

	@Override
	public String toString() {
		return "Message [userid=" + userid + ", contactname=" + contactname + ", reason=" + reason + ", data=" + data
				+ ", time=" + time + ", state=" + state + ", contactimg=" + contactimg + ", tel=" + tel + ", photo="
				+ photo + ", comments=" + comments + ", username=" + username + ", userimg=" + userimg + ", messageid="
				+ messageid + "]";
	}
	
}
