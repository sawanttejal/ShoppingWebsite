package com.Ecommer.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Ecommer.config.DBConnection;
import com.pojo.User;

public class LoginDao {
	
	Connection con = DBConnection.getconnection(); 
	
	public User getUsernamepass(String uname,String pass)
	{
		String sql = "select email,password from user1 where email=? and password=?";
		
		User u = new User();
		
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,uname);
			ps.setString(2,pass);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				
				//System.out.println(rs.getString(1));
				//System.out.println(rs.getString(2));
				
				return u;
			}
				
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

}
