package com.taru.bbs.pojo;

public class Essay {
	
	String essayid;
    String essaycategoryid;
    String essayclicked;
    String essayname;
    String essayuserid;
    String essaytext;
    String essaystatus;
    String essaydatatime;
    User user;

    public String getEssaycategoryid() {
        return essaycategoryid;
    }

    public void setEssaycategoryid(String essaycategoryid) {
        this.essaycategoryid = essaycategoryid;
    }


	public String getEssayclicked() {
		return essayclicked;
	}

	public void setEssayclicked(String essayclicked) {
		this.essayclicked = essayclicked;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getEssaydatatime() {
		return essaydatatime;
	}

	public void setEssaydatatime(String essaydatatime) {
		this.essaydatatime = essaydatatime;
	}


	public String getEssaystatus() {
		return essaystatus;
	}
	public void setEssaystatus(String essaystatus) {
		this.essaystatus = essaystatus;
	}
	public String getEssayid() {
		return essayid;
	}
	public void setEssayid(String essayid) {
		this.essayid = essayid;
	}
	public String getEssayname() {
		return essayname;
	}
	public void setEssayname(String essayname) {
		this.essayname = essayname;
	}
	public String getEssayuserid() {
		return essayuserid;
	}
	public void setEssayuserid(String essayuserid) {
		this.essayuserid = essayuserid;
	}
	public String getEssaytext() {
		return essaytext;
	}
	public void setEssaytext(String essaytext) {
		this.essaytext = essaytext;
	}
	
	
	
}
