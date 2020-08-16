<%@page import="java.util.List"%>
<%@page import="com.pojo.GetOrderData"%>
<%@page import="com.Ecommer.Dao.Feedback"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart List</title>

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

h6 
{
	color: red;
}
</style>


<body>

<%

	List<GetOrderData> gd =  (List<GetOrderData>) session.getAttribute("OrderList");
	
	int increFid = 1 ;

 %>
 
<!-- 	Navigation --> <jsp:include page="Nav.jsp" />

<!-- Page Content -->
  <div class="container">



	<table style="margin-left:auto;margin-right:auto;" height="500" width="900" >
	
		<tr>
			<th>Serial No.</th>
			<th>Total Bill</th>
			<th>Order Date</th>
			<th>User Name</th>
			<th colspan="2">Action</th>
			
		</tr>
		
		<%
			for(GetOrderData fb : gd) {
		%>
		
		
		<tr>
			
			<td><%=increFid++%></td>
			<td><%=fb.getTbill()%></td>
			<td><%=fb.getDate()%></td>
			<td><%=fb.getEmail()%></td>
			<td><a href="PlaceOrderServlet?action=delete&id=<%=fb.getOrid()%>">Delete</a></td>
			
		</tr>
		
		<% } %>
		
		
		
	</table>

</div>
  <!-- /.container -->

<!--   footer page -->
  <jsp:include page="footer.jsp" />




</body>


</html>