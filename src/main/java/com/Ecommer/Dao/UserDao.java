package com.Ecommer.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Ecommer.config.DBConnection;
import com.pojo.Product;
import com.pojo.User;

public class UserDao {
	
	Connection con = DBConnection.getconnection();
	
	
	public boolean adduser(User u)
	{
		String sql = "insert into user1(email,password) values(?,?)";
		
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,u.getEmail());
			ps.setString(2,u.getPassword());
			
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
	
	public boolean updateproduct(User u)
	{
		String sql = "update user1 set uname=?,contact=?,gender=?,dob=? where email=?";
		
		
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,u.getName());
			ps.setString(2,u.getContact());
			ps.setString(3,u.getGender());
			ps.setString(4,u.getDob());
			ps.setString(5,u.getEmail());
			
			int i = ps.executeUpdate();
			
			if(i > 0)
			
			return true;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	public List<User> getUserList()
	{
		String sql = "Select uid,uname,contact,gender,dob,email,password from user1";
	
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<User> ul = new ArrayList<User>();
			
			while(rs.next())
			{
				User u = new User();
				
				u.setUserid(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setContact(rs.getString(3));
				u.setGender(rs.getString(4));
				u.setDob(rs.getString(5));
				u.setEmail(rs.getString(6));
				u.setPassword(rs.getString(7));
				
				ul.add(u);
			}
				return ul;
				
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean deleteUser(String email)
	{
		String sql = "delete from user1 where email=?";
		
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,email);
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

	public boolean ChangPassByEmail(String email,String pass) {
		
		String sql = "update user1 set password=? where email=?" ;
		
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,pass);
			ps.setString(2,email);
			
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
	
	public User gteByEmail(String userName)
	{
		String sql = "select * from user1 where email=?";
		
		User u = new User();
		
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,userName);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next())
			{
				
				u.setUserid(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setContact(rs.getString(3));
				u.setGender(rs.getString(4));
				u.setDob(rs.getString(5));
				u.setEmail(rs.getString(6));
				
			}
			
			return u;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
}

