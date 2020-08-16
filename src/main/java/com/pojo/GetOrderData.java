package com.pojo;

public class GetOrderData {
	
	private int orid;
	private double tbill;
	private String date;
	private String email;
	
	
	public int getOrid() {
		return orid;
	}
	public void setOrid(int orid) {
		this.orid = orid;
	}
	public double getTbill() {
		return tbill;
	}
	public void setTbill(double tbill) {
		this.tbill = tbill;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Override
	public String toString() {
		return "GetOrderData [orid=" + orid + ", tbill=" + tbill + ", date=" + date + ", email=" + email + "]";
	}
	
	
	

}
