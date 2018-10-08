package com.taru.bbs.pojo;

import java.util.List;

public class User {
	String id;
	String username;
	String password;
	String telphone;
    String photo;
	String userdatatime;
	List<Essay> essay;
	public String getUserdatatime() {
		return userdatatime;
	}

	public void setUserdatatime(String userdatatime) {
		this.userdatatime = userdatatime;
	}






	public void setEssay(List<Essay> essay) {
		this.essay = essay;
	}

	public List<Essay> getEssay() {
		return essay;
	}


	public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	
	
}
