package com.pojo;

public class CartList {
	
	private int cartid;
	private String pname;
	private double price;
	private String description;
	private String email;
	private int pid;
	
	
	public int getCartid() {
		return cartid;
	}
	
	
	public void setCartid(int cartid) {
		this.cartid = cartid;
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
	
	
	public String getDescription() {
		return description;
	}
	
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getEmail() {
		return email;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public int getPid() {
		return pid;
	}
	
	
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	
	
	@Override
	public String toString() {
		return "CartList [cartid=" + cartid + ", pname=" + pname + ", price=" + price + ", description=" + description
				+ ", email=" + email + ", pid=" + pid + "]";
	}
	
	

}
