package com.Ecommer.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Ecommer.config.DBConnection;
import com.pojo.CartList;
import com.pojo.Category;
import com.pojo.Product;
import com.pojo.feedback;

public class ProductDao {
	
	Connection con = DBConnection.getconnection();
	
	
	public boolean addproduct(Product p)
	{
		String sql = "insert into product(pname,price,description,cid) values(?,?,?,?)";
		
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,p.getPname());
			ps.setDouble(2,p.getPrice());
			ps.setString(3,p.getDescription());
			ps.setInt(4,p.getCid());
			
			int b = ps.executeUpdate();
			
			if(b > 0)
			return true;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public boolean deleteproduct(int id)
	{
		String sql = "delete from product where id=?";
		
		try
		{
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			int b = ps.executeUpdate();
		
			if(b > 0)
				
			return true;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateproduct(Product p)
	{
		String sql = "update product set pname=?,price=?,description=?,cid=? where id=?";
		
		
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,p.getPname());
			ps.setDouble(2,p.getPrice());
			ps.setString(3,p.getDescription());
			ps.setInt(4,p.getCid());
			ps.setInt(5,p.getId());
			
			int i = ps.executeUpdate();
			
			if(i > 0)
			
			return true;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public List<Product> getproductList()
	{
		String sql = "Select id,pname,price,description,cid from product";
		
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<Product> ul = new ArrayList<Product>();
			
			while(rs.next())
			{
				Product p = new Product(); 
				
				p.setId(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setPrice(rs.getDouble(3));
				p.setDescription(rs.getString(4));
				p.setCid(rs.getInt(5));
				
				ul.add(p);
				
			}
				
			return ul;
				
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
 
	
	public Product getById(int id)
	{
		String sql = "select * from product where id=?";
		
		Product p1 = new Product();
		
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				p1.setId(rs.getInt(1));
				p1.setPname(rs.getString(2));
				p1.setPrice(rs.getDouble(3));
				p1.setDescription(rs.getString(4));
				p1.setCid(rs.getInt(5));
				
			}
			
			return p1;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	public List<Product> getProductByCategory(int cid) {
		
		  String sql="select * from product where cid=? ";
		
		  List<Product> pl=new ArrayList<Product>();
		  
		  try {
			  
		   PreparedStatement ps=con.prepareStatement(sql);
		   ps.setInt(1, cid);
		   
		   ResultSet rs=ps.executeQuery();
		   
		   while(rs.next()) {
			   
		    Product p = new Product();
		    
		    p.setId(rs.getInt(1));
		    p.setPname(rs.getString(2));
		    p.setPrice(rs.getDouble(3));
		    p.setDescription(rs.getString(4));
		    p.setCid(rs.getInt(5));
		    
		    pl.add(p);
		   
		   }
		   
		   return pl;
		   
		  }catch (Exception e) {
		   e.printStackTrace();
		  }
		  return null;
		 }


	public boolean addToCart(int pid, String userName) {
		
		String sql = "insert into cart(pid,email) values (?,?)";
		
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,pid);
			ps.setString(2,userName);
			
			int b = ps.executeUpdate();
			
			if(b > 0)
			{
				return true;
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return false;
	}


	public List<Product> searchByString(String search) {
		
		String sql = "select * from product where pname like '%"+search+"%' ";
		
		List<Product> li = new ArrayList<Product>();
		
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Product p = new Product();
				
				p.setId(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setPrice(rs.getDouble(3));
				p.setDescription(rs.getString(4));
				p.setCid(rs.getInt(5));
				
				li.add(p);
			}
			
			return li;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
		return null;
	}

		
	public List<CartList> cartListByEmail(String email)
	{
		String sql = "select cartid,pname,price,description,pid from product as p inner join cart as c on p.id=c.pid where email=? ";
		
		List<CartList> ul = new ArrayList<CartList>();
		
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,email);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				CartList cl = new CartList();
				
				cl.setCartid(rs.getInt(1));
				cl.setPname(rs.getString(2));
				cl.setPrice(rs.getDouble(3));
				cl.setDescription(rs.getString(4));
				cl.setPid(rs.getInt(5));
				
				ul.add(cl);
				
			}
			
			return ul;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	
	public boolean deleteCartList(int id)
	{
		String sql = "delete from cart where pid=?";
		
		try
		{
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			int b = ps.executeUpdate();
		
			if(b > 0)
				
			return true;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

		
}
