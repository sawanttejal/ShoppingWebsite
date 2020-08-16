package com.Ecommer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Ecommer.Dao.CategoryDao;
import com.pojo.Category;


public class CategoryServlet extends HttpServlet {
	
	Category c = new Category();
	
	CategoryDao cd = new CategoryDao();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		
		if(action!=null && action.equals("delete"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
		
			boolean d = cd.deleteCategory(id);
			
			if(d)
			{
				response.sendRedirect("category.jsp");
			}else
			{
				response.sendRedirect("index.jsp");
			}
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.print("enter");
		
		String cname = request.getParameter("cname");
		
		//int id = Integer.parseInt(request.getParameter("id"));
		
		c.setCatname(cname);
		
		//c.setCid(id);
		
		boolean a = cd.addCategory(c);
		
		System.out.print("p1");
		
		if(a)
		{
			System.out.print("p2");
			response.sendRedirect("category.jsp");
		}else
		{
			response.sendRedirect("index.jsp");
		}
	}

}
