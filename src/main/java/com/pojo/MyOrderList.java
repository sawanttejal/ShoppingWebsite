package com.pojo;

public class MyOrderList {
	
	private int Orid;
	private String pname;
	private double price;
	private int pid;
	
	
	public int getOrid() {
		return Orid;
	}
	public void setOrid(int orid) {
		Orid = orid;
	}
	
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	
	
	@Override
	public String toString() {
		return "MyOrderList [Orid=" + Orid + ", pname=" + pname + ", price=" + price + ", pid=" + pid + "]";
	}
	
	
	
	
	
	
	
	
	
	
		

}
