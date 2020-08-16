package com.pojo;

public class feedback {
	
	private int fid;
	private String fcomment;
	private String username;
	private int pid;
	private String date;
	
	
	
	public int getFid() {
		return fid;
	}
	
	
	public void setFid(int fid) {
		this.fid = fid;
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


	public String getDate() {
		return date;
	}
	
	
	public void setDate(String date) {
		this.date = date;
	}


	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	@Override
	public String toString() {
		return "feedback [fid=" + fid + ", fcomment=" + fcomment + ", username=" + username + ", pid=" + pid + ", date="
				+ date + "]";
	}

	

	
	
	
	
	
	
}
