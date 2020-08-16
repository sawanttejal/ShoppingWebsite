package com.pojo;

public class Product {
	
	private int id;
	private String pname;
	private double price;
	private String description;
	private int cid ;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
		
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", pname=" + pname + ", price=" + price + ", description=" + description + ", cid="
				+ cid + "]";
	}
	
	
	
	
	
	

}
