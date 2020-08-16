<%@page import="com.pojo.Product"%>
<%@page import="com.pojo.Category"%>
<%@page import="com.Ecommer.Dao.CategoryDao"%>
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
			Product pl = (Product) session.getAttribute("data");
	%>

	<%
		CategoryDao cd=new CategoryDao();
		List<Category> cl = cd.getUserList();
	%>
	
<!-- 	Navigation --> <jsp:include page="Nav.jsp" />

<!-- Page Content -->
  <div class="container">


	<form action="ProductServlet" method="post">
		
	<input type="hidden" name="action" value="updateproduct">
		
		<table style="margin-left:auto;margin-right:auto;" height="500" width="900" >
			
			<tr>
				<td>Product Id</td>
				<td><input type="text" name="pid" value="<%=pl.getId()%>" ></td>
			</tr>
		
			<tr>
				<td>Name</td>
				<td><input type="text" name="pname" value="<%=pl.getPname()%>" ></td>
			</tr>

			<tr>
				<td>Price</td>
				<td><input type="text" name="price" value="<%=pl.getPrice()%>"></td>
			</tr>

			<tr>
				<td>Description</td>
				<td><textarea rows="5" cols="20" name="description"></textarea></td>
			</tr>

			<tr>
				<td>Category</td>
				<td><select name="cid" >
						<option>Select -- category</option>
						<% for( Category c : cl) { %>
						<option value=<%=c.getCid()%>><%=c.getCatname() %></option>
						<%} %></select>
				</td>
			</tr>
			
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
		
		</table>
	</form>

</div>
  <!-- /.container -->

<!--   footer page -->
  <jsp:include page="footer.jsp" />


</body>
</html>