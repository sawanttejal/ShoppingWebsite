<html>
<body>

<%

	String adminName=(String)session.getAttribute("adminName");

	String userName =(String)session.getAttribute("userName");

%>



<!-- <a href="adduser.jsp">Register User</a> <br> -->

<!-- <a href="category.jsp">Insert Category</a><br> -->

<!-- <a href="product.jsp">Insert Product</a><br> -->

<!-- <a href="ProductServlet">Selected Product List</a><br>  -->

<!-- <a href="login.jsp">Login</a> -->


	<h3><a href="index.jsp">Home</a></h3>
	
	<h3><a href="ProductServlet">Product List</a></h3>
	
	<h3><a href="">Search</a></h3>

	<%if (userName!=null && adminName==null){ %>
	
		<h3><a href="UserServlet?action=EditProfile">EditProfile</a></h3>
		
		<h3><a href="">CartList</a></h3>
		
		<h3><a href="">MyOrderList</a></h3>
	
	<%} %>
	
	<%if(adminName!=null && userName==null){ %>
	
		<h3><a href="category.jsp">Category</a></h3>
	
		<h3><a href="product.jsp">AddProduct</a></h3>
	
		<h3><a href="">OrderList</a></h3>
	
		<h3><a href="UserServlet">UserList</a></h3>
	
	<%} %>
	
	<%if (userName==null && adminName==null){ %>
	
		<h3><a href="adduser.jsp">Register User</a></h3>
	
		
		<h3><a href="login.jsp">Login</a></h3>
	
	<%} %>
	
	<%if(userName!=null || adminName!=null) {%>
		
		<h3><a href="LoginServlet">LogOut</a></h3>
	
	<%} %>

</body>
</html>
