<%@page import="com.pojo.Product"%>
<%@page import="com.Ecommer.Dao.ProductDao"%>
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
		String userName =(String)session.getAttribute("userName");
	
		ProductDao pd = new ProductDao();
		List<Product> prolist = pd.getproductList();
	%>
	
<!-- 	Navigation --> <jsp:include page="Nav.jsp" />

<!-- Page Content -->
  <div class="container">
	

	<form action="FeedbackServlet" method="post">
		
		<input type="hidden" name="action" value="feedback"> 
		
		<table style="margin-left:auto;margin-right:auto;" height="500" width="900" >
		
			<tr>
				<td>Feedback Comment</td>
				<td><textaera><input type="text" name="fname" required></textaera></td>
			</tr>

			<tr>
				<td>User Name</td>
				<td><input type="text" name="email" value="<%=userName%>" ></td>
			</tr>

			<tr>
				<td>Product Name</td>
				<td><select name="pid" required>
						<option>Select -- Product</option>
						<% for(Product p : prolist){%>
						<option value=<%=p.getId()%>><%=p.getPname() %></option>
						<%} %></select>
				</td>
			</tr>
			
			<tr>
				<td>Feedback date</td>
				<td><input type="date" name="fdate" required></td>
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