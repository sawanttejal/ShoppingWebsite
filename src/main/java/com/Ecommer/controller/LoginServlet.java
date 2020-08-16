package com.Ecommer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;

import com.Ecommer.Dao.LoginDao;
import com.pojo.User;


public class LoginServlet extends HttpServlet {

	User u = new User();

	LoginDao ld = new LoginDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("index.jsp");
	
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			HttpSession session = request.getSession();
		
			String username = request.getParameter("username");
			
			String pass = request.getParameter("password");
			
			User u = ld.getUsernamepass(username,pass);
		
			if(username != null &&(username.equals("admin@123") && pass.equals("admin")))
			{
				session.setAttribute("adminName",username);
				response.sendRedirect("index.jsp");
			}
			
			else if(u != null && (u.getEmail().equals(username) && u.getPassword().equals(pass)))
			{
				session.setAttribute("userName",username);
				response.sendRedirect("index.jsp");
			
			}
			
			else
			{
				request.setAttribute("msg","Invalid UserName and Password");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}
			
			
	}

}
