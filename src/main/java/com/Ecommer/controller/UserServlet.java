package com.Ecommer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Ecommer.Dao.UserDao;
import com.pojo.Product;
import com.pojo.User;


public class UserServlet extends HttpServlet {
	
	User u = new User();
	
	UserDao ud = new UserDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		
		String action = request.getParameter("action");
		
		if(action!=null && action.equals("EditProfile"))
		{
			response.sendRedirect("EditProfile.jsp");
			
		}else if(action!=null && action.equals("delete"))
		{
			String email = request.getParameter("email");
			
			boolean b = ud.deleteUser(email);
			
			if(b)
			{
				response.sendRedirect("index.jsp");
			}
			
		}else
		{
			List<User> UList = ud.getUserList();
			session.setAttribute("UserList",UList);
			response.sendRedirect("UserList.jsp");
		
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		String cpass = request.getParameter("Cpassword");
		
		u.setEmail(email);
		u.setPassword(pass);
		
		String action = request.getParameter("action");
		
		if(action!=null && action.equals("AddRegisterUserNew"))
		{
			if(pass!=null && pass.equals(cpass))
			{
				boolean b = ud.adduser(u);
				
				if(b)
				{
					
					response.sendRedirect("index.jsp");
					
				}else
				{
					request.setAttribute("duplicate","You have already registered using this email id");
					RequestDispatcher rd = request.getRequestDispatcher("adduser.jsp");
					rd.include(request, response);
				}
			}else
			{
				response.sendRedirect("adduser.jsp");
			}
				
		}else if(action!=null && action.equals("updateprofile"))
		{
				
				String uname = request.getParameter("uname");
				String contact = request.getParameter("contact");
				String dob = request.getParameter("dob");
				String gender = request.getParameter("gender");
				
				u.setName(uname);
				u.setContact(contact);
				u.setGender(gender);
				u.setDob(dob);
				
				
				boolean b =  ud.updateproduct(u);
				
				
				if(b)
				{
					response.sendRedirect("index.jsp");
				}else
				{
					response.sendRedirect("EditProfile.jsp");
				}

		}else if(action != null && action.equals("changepass"))
		{
			
			if(pass!=null && pass.equals(cpass))
			{
				
				boolean b = ud.ChangPassByEmail(email,pass);
				
				if(b)
				{
					
					response.sendRedirect("EditProfile.jsp");
				}
			}else
			{
				response.sendRedirect("changepass.jsp");
			}
		}
		
	}	
		
		
}

