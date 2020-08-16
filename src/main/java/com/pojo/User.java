package com.pojo;

public class User {
	
	private int userid ;
	private String name;
	private String contact;
	private String dob;
	private String gender;
	private String email;
	private String password;
	private String cpassword;
	
	
	public int getUserid() {
		return userid;
	}
	
	
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getContact() {
		return contact;
	}
	
	
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
	public String getDob() {
		return dob;
	}
	
	
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	
	public String getGender() {
		return gender;
	}
	
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public String getEmail() {
		return email;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getPassword() {
		return password;
	}
	
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getCpassword() {
		return cpassword;
	}
	
	
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	
	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", contact=" + contact + ", dob=" + dob + ", gender="
				+ gender + ", email=" + email + ", password=" + password + ", cpassword=" + cpassword + "]";
	}
	
	
	

}
