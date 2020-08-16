package com.Ecommer.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Ecommer.config.DBConnection;
import com.pojo.Category;

public class CategoryDao {
	
	Connection con = DBConnection.getconnection();
	
	public boolean addCategory(Category c)
	{
		String sql = "insert into Category(cname) values(?)";
		
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,c.getCatname());
			
			int i = ps.executeUpdate();
			
			if(i > 0)
			{
				return true;
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean deleteCategory(int id) 
	{
	  String sql="delete from category where id=?";
	  
	  try {
	  
		  PreparedStatement ps=con.prepareStatement(sql);
		  ps.setInt(1,id);
		  int i=ps.executeUpdate();
		  
	   if(i > 0) 
	   {
		   
	    return true;
	   
	   }
	   
	  }catch (Exception e) {
	   
	   e.printStackTrace();
	  }
	  
	  return false;
	 }

	
	
	public List<Category> getUserList()
	{
		String sql = "Select id,cname from category";
		
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<Category> ul = new ArrayList<Category>();
			
			while(rs.next())
			{
				Category c = new Category(); 
				
				c.setCid(rs.getInt(1));
				c.setCatname(rs.getString(2));
				
				
				
				ul.add(c);
				
			}
				return ul;
				
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}


}
