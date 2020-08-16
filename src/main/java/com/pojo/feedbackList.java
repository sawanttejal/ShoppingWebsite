package com.pojo;

public class feedbackList {
	
	private int Fid;
	private String fcomment;
	private String username;
	private String pname;
	private String fdate;
	private int pid;
	
	
	public int getFid() {
		return Fid;
	}
	public void setFid(int fid) {
		Fid = fid;
	}
	public String getFcomment() {
		return fcomment;
	}
	public void setFcomment(String fcomment) {
		this.fcomment = fcomment;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getFdate() {
		return fdate;
	}
	public void setFdate(String fdate) {
		this.fdate = fdate;
	}

	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	
	
	@Override
	public String toString() {
		return "feedbackList [Fid=" + Fid + ", fcomment=" + fcomment + ", username=" + username + ", pname=" + pname
				+ ", fdate=" + fdate + ", pid=" + pid + "]";
	}
	
	
	
	
	
	
	
	
	
	
	

}
