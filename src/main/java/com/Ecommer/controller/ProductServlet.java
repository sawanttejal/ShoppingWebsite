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
import com.Ecommer.Dao.ProductDao;
import com.pojo.CartList;
import com.pojo.Product;
import com.pojo.feedback;


public class ProductServlet extends HttpServlet {
	
	
	CartList cl = new CartList();
	
	Product p = new Product();
	
	ProductDao pd = new ProductDao();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
	
		String action = request.getParameter("action");
		
				
		if(action != null && action.equals("delete"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			
			boolean b = pd.deleteproduct(id);
			
			if(b)
			{
				response.sendRedirect("index.jsp");
			}
			
			
			
		}else if(action != null && action.equals("edit"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			
			Product p = pd.getById(id);
			session.setAttribute("data",p);
			response.sendRedirect("UpdateProduct.jsp");
			
			
		
		}else if(action != null && action.equals("getproductbycate"))
		{
				
			int cid = Integer.parseInt(request.getParameter("cid"));
			List<Product> plc = pd.getProductByCategory(cid);
			session.setAttribute("getbycategory", plc);
			response.sendRedirect( "index.jsp");
			
			
			
		}else if(action != null && action.equals("addToCart"))
		{
			int pid = Integer.parseInt(request.getParameter("pid"));
			
			String userName =(String)session.getAttribute("userName");
			
			boolean b = pd.addToCart(pid,userName);
			
			if(b)
			{
				request.setAttribute("addtocart","Your are successfully added the product in cart");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.include(request,response);
		
				
			}else
			{
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");  //here we erite servlet name also and here we specify that jsp/html name which we want to redirect
				rd.forward(request,response);
			}
			
			
			
		}else if(action != null && action.equals("cartlist"))
		{
			String email =(String)session.getAttribute("userName");
			List<CartList> ul = pd.cartListByEmail(email);
			session.setAttribute("cartlist",ul);
			response.sendRedirect("CartList.jsp");
//			double total = 0;
//			
//			for(CartList c : ul){
//				
////				total = total + c.getPrice();
//				
//			}
//			
//			session.setAttribute("totalprice",total);
			
			
		
		}else if(action != null && action.equals("cartdelete"))
		{
			int id = Integer.parseInt(request.getParameter("pid"));
			
			boolean b = pd.deleteCartList(id);
		
			if(b)
			{
				response.sendRedirect("index.jsp");
//				request.setAttribute("deleteCartProduct","You have successfully delete this product from Cart your List");
//				RequestDispatcher rd = request.getRequestDispatcher("CartList.jsp");
//				rd.include(request,response);
			}
			
			
		
		}else
		{
			List<Product> prolist = pd.getproductList();
			session.setAttribute("productList", prolist);
			response.sendRedirect("ProductList.jsp");
		
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		String action = request.getParameter("action");
		
		
		if(action != null && action.equals("addproduct"))
		{
			String pname = request.getParameter("pname");
			Double price = Double.parseDouble(request.getParameter("price"));
			String description = request.getParameter("description");
			int cid = Integer.parseInt(request.getParameter("cid"));
					
					
			p.setPname(pname);
			p.setPrice(price);
			p.setDescription(description);
			p.setCid(cid);
			
			boolean b = pd.addproduct(p);
			if (b)
			{
				response.sendRedirect("index.jsp");
			}else
			{
				response.sendRedirect("product.jsp");
			}
			
		}else if (action != null && action.equals("updateproduct"))
		{
			String pname = request.getParameter("pname");
			Double price = Double.parseDouble(request.getParameter("price"));
			String description = request.getParameter("description");
			int cid = Integer.parseInt(request.getParameter("cid"));
					
					
			p.setPname(pname);
			p.setPrice(price);
			p.setDescription(description);
			p.setCid(cid);
			
			int id = Integer.parseInt(request.getParameter("pid"));
			
			p.setId(id);
			
			boolean b = pd.updateproduct(p);
			
			if(b)
			{
				response.sendRedirect("index.jsp");
			}
		
		}else if(action != null && action.equals("Search"))
		{
			
			String search = request.getParameter("searchProduct");
			
			List<Product> search1 = pd.searchByString(search);
			session.setAttribute("getbycategory", search1);
			response.sendRedirect( "search.jsp");
			
			
			
		}
		
		
		
	
	}

}
