package com.Ecommer.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Ecommer.config.DBConnection;
import com.pojo.feedback;
import com.pojo.feedbackList;

public class Feedback {

	Connection con = DBConnection.getconnection();
	
		public boolean addfeedback(feedback fb) {
			
			String sql = "insert into feedback(feedbackComment,useremail,Pid,fdate) values(?,?,?,?)";
			
			try
			{
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1,fb.getFcomment());
				ps.setString(2,fb.getUsername());
				ps.setInt(3,fb.getPid());
				ps.setString(4,fb.getDate());
				
				int i = ps.executeUpdate();
				
				if (i > 0)
					return true;
			
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return false;
		}
	
	public List<feedbackList> FeedbackList()
	{
		String sql = "select Fid,feedbackComment,useremail,pname,fdate,Pid from feedback as f inner join product as p on p.id=f.Pid";
		
		List<feedbackList> ul = new ArrayList<feedbackList>();
		
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				feedbackList fb = new feedbackList();
				
				fb.setFid(rs.getInt(1));
				fb.setFcomment(rs.getString(2));
				fb.setUsername(rs.getString(3));
				fb.setPname(rs.getString(4));
				fb.setFdate(rs.getString(5));
				fb.setPid(rs.getInt(6));
			
				ul.add(fb);
				
			}
			
			return ul;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
	public boolean deleteByEmail(int fid) {
		
		String sql = "delete from feedback where fid=?";
		
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,fid);
			
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
