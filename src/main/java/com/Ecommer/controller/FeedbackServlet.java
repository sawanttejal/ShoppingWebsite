package com.Ecommer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Ecommer.Dao.Feedback;
import com.pojo.feedback;


public class FeedbackServlet extends HttpServlet {
	
	feedback fb = new feedback();
	
	Feedback fd = new Feedback();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action != null && action.equals("delete"))
		{
			int fid = Integer.parseInt(request.getParameter("fid"));
			
			//System.out.print("run1");
			
			boolean b = fd.deleteByEmail(fid);
			
			if(b)
			{
				//System.out.print("run2");
				response.sendRedirect("index.jsp");
			}
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		
		if (action != null && action.equals("feedback"))
		{
		
			String feedcomment = request.getParameter("fname");
			
			String username = request.getParameter("email");
			
			int pid = Integer.parseInt(request.getParameter("pid"));
			
			String fdate = request.getParameter("fdate");
			
			
			fb.setFcomment(feedcomment);
			fb.setUsername(username);
			fb.setPid(pid);
			fb.setDate(fdate);
			
			boolean b = fd.addfeedback(fb);
			
			if(b)
			{
				response.sendRedirect("index.jsp");
			}else
			{
				response.sendRedirect("index.jsp");
			}
		
		}
	
	
	
	
	}

}
