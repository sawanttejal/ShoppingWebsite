package com.pojo;

public class Category {

	private String catname;
	private int cid;
	
	public String getCatname() {
		return catname;
	}


	public void setCatname(String catname) {
		this.catname = catname;
	}

	

	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	@Override
	public String toString() {
		return "Category [catname=" + catname + ", cid=" + cid + "]";
	}

	
	
}
