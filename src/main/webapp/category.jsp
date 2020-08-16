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

<!-- 	Navigation --> <jsp:include page="Nav.jsp" />


 		<form action="CategoryServlet" method="post">
		 
		
			
			<h1>Insert Category</h1>
			
			<table >
				
				<tr>
					<td>Category Name</td>
					<td><input type="text" name="cname" required ></td>
				</tr>
				
				<tr>
					<td><input type="submit" value="submit"></td>
				</tr>
			
			</table>
		
		</form>
		
		
			<%
				CategoryDao cd = new CategoryDao();
				List<Category> ul = cd.getUserList();
			%>
			
			
			
			<table cellspacing="10" cellpadding="10" height="500" width="900" >
				<tr>
					
					<th>Category id</th>
					<th>Category Name</th>
					
					<th colspan="2">Action</th>
						
				</tr>
				<%
					for (Category c :ul) {
				%>
		
				<tr>
					<td><%=c.getCid()%></td>
					<td><%=c.getCatname()%></td>
					
					<td><a href="CategoryServlet?action=delete&id=<%=c.getCid()%>">Delete</a></td>
				
				</tr>
		
				<%
					}
				%>
			</table>
		
	 
	
				
<!--   footer page -->
  <jsp:include page="footer.jsp" />



</body>
</html>