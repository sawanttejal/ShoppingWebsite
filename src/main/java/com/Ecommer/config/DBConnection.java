package com.Ecommer.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static Connection getconnection()
	{
		Connection con = null;
		
		String url = "jdbc:mysql://localhost:3306/ecommerce";
		String username = "root";
		String pass = "";
		
		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			
			con = DriverManager.getConnection(url,username,pass);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return con;
	}

	
}
