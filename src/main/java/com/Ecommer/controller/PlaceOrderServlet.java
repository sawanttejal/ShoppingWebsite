package com.Ecommer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Ecommer.Dao.MyOrderDao;
import com.Ecommer.Dao.UserDao;
import com.pojo.GetOrderData;
import com.pojo.MyOrderList;
import com.pojo.User;


public class PlaceOrderServlet extends HttpServlet {
	
	MyOrderList MyOrder = new MyOrderList();
	
	MyOrderDao MyOrD = new MyOrderDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		UserDao ud = new UserDao();
		
		String action = request.getParameter("action");
		
		if(action != null && action.equals("takeinput"))
		{
			double totalBill = Double.parseDouble(request.getParameter("total"));
			
			String userName =(String)session.getAttribute("userName");
			
			User u = ud.gteByEmail(userName);
			
			session.setAttribute("bill", totalBill);
			session.setAttribute("data",u);
			
			response.sendRedirect("PlaceOrder.jsp");
			
		
		
		}else if(action != null && action.equals("add"))
		{
			
			double Bill = Double.parseDouble(request.getParameter("bill"));
			
			String date = request.getParameter("date");
			
			String userName =(String)session.getAttribute("userName");
			
			boolean b = MyOrD.insertbill(Bill,date,userName);
			
			if(b)
			{
				response.sendRedirect("index.jsp");
			}
		
		}else if(action != null && action.equals("OrderList"))
		{
			
			String userName =(String)session.getAttribute("userName");
			
			List<MyOrderList> mylist = MyOrD.OrderListByEmail(userName);
			
			GetOrderData g = MyOrD.getByemail(userName);
			
			session.setAttribute("OrList",mylist);
			
			session.setAttribute("listOr",g);
			
			response.sendRedirect("MyOrderList.jsp");
			
		
		}else if(action != null && action.equals("delete"))
		{
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			boolean b = MyOrD.deletebyemail(id);
			
			if(b)
			{
				response.sendRedirect("index.jsp");
			}
		
		}else
		{
			 List<GetOrderData> gd = MyOrD.getOrderList();
			 session.setAttribute("OrderList",gd);
			 response.sendRedirect("OrderList.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
