<%@page import="com.pojo.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Ecommerce Website</title>

  <!-- Bootstrap core CSS -->
  <link href="resources/css/bmin.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="resources/css/homecss.css" rel="stylesheet">


</head>

<style>
body  {
  background-color: #cccccc;
}
</style>


<body>

<% 
	List<Product> pl = (List<Product>) session.getAttribute("productList");
%>

<!-- 	Navigation --> <jsp:include page="Nav.jsp" />


  <!-- Page Content -->
  <div class="container">

    <div class="row">

	<!-- SiteBar --> <jsp:include page="SiteBar.jsp" />
      
 	<!-- /.col-lg-3 -->

      <div class="col-lg-9">



			<form action="ProductServlet">
			
			<table cellspacing="10" cellpadding="10" border="1" style="margin-left:auto;margin-right:auto;"height="500" width="900" >
			
				<tr>
					<th>Product Id</th>
					<th>Product Name</th>
					<th>Product Price</th>
					<th>Product description</th>
			<!-- 		<th>Selected Category</th> -->
					
					<th colspan="2">Action</th>
					
				</tr>
				
				<%
					for(Product p : pl) {
				%>
				
				
				<tr>
				
					<td><%=p.getId() %></td>
					<td><%=p.getPname() %></td>
					<td><%=p.getPrice() %></td>
					<td><%=p.getDescription() %></td>
			<%-- 		<td><%=p.getCid()%></td> --%>
					
					<td><a href="ProductServlet?action=delete&id=<%=p.getId()%>">Delete</a></td>
					
					<td><a href="ProductServlet?action=edit&id=<%=p.getId()%>">Edit</a></td>
					
				</tr>
				
				<% } %>
				
			</table>
			</form>

	</div>
      <!-- /.col-lg-9 -->
	
	</div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

  <!-- Footer -->
  
<!--   footer page -->
  <jsp:include page="footer.jsp" />
  


</body>
</html>