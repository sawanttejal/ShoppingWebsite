package com.Ecommer.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Ecommer.config.DBConnection;
import com.pojo.CartList;
import com.pojo.GetOrderData;
import com.pojo.MyOrderList;
import com.pojo.Product;

public class MyOrderDao {
	
	Connection con = DBConnection.getconnection();

	public boolean insertbill(double bill,String date,String email) {
		
		String sql = "insert into orderdata(TotalBill,date1,email) values(?,?,?)";
		
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1,bill);
			ps.setString(2,date);
			ps.setString(3,email);
			
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

	
	public List<MyOrderList> OrderListByEmail(String email)
	{
		String sql = "select cartid,pname,price,pid from product as p inner join cart as c on p.id=c.pid where email=? ";
		
		List<MyOrderList> ul = new ArrayList<MyOrderList>();
		
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,email);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				MyOrderList cl = new MyOrderList();
				
				cl.setOrid(rs.getInt(1));
				cl.setPname(rs.getString(2));
				cl.setPrice(rs.getDouble(3));
				cl.setPid(rs.getInt(4));
				
				ul.add(cl);
				
			}
			
			return ul;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
		
	public GetOrderData getByemail(String email)
	{
		String sql = "select * from orderdata where email=?";
		
		GetOrderData gd = new GetOrderData();
		
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,email);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				gd.setOrid(rs.getInt(1));
				gd.setTbill(rs.getDouble(2));
				gd.setDate(rs.getString(3));
				gd.setEmail(rs.getString(4));
				
			}
			
			return gd;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	public List<GetOrderData> getOrderList()
	{
		String sql = "Select OrderId,TotalBill,date1,email from orderdata";
		
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<GetOrderData> ul = new ArrayList<GetOrderData>();
			
			while(rs.next())
			{
				GetOrderData p = new GetOrderData(); 
				
				p.setOrid(rs.getInt(1));
				p.setTbill(rs.getDouble(2));
				p.setDate(rs.getString(3));
				p.setEmail(rs.getString(4));
				
				ul.add(p);
				
			}
				
			return ul;
				
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}


	public boolean deletebyemail(int id) {

		String sql = "delete from orderdata where OrderId=?";
		
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			
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


	
	
}
