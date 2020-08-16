<%@page import="com.pojo.GetOrderData"%>
<%@page import="java.util.List"%>
<%@page import="com.pojo.MyOrderList"%>
<%@page import="com.Ecommer.Dao.MyOrderDao"%>
 
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
	List<MyOrderList> ul = (List<MyOrderList>) session.getAttribute("OrList");
	
	GetOrderData g = (GetOrderData) session.getAttribute("listOr");


	int Orid = 1;
 %>
 
<!-- 	Navigation --> <jsp:include page="Nav.jsp" />

<!-- Page Content -->
  <div class="container">

 

<form action="UserServlet">

<table style="margin-left:auto;margin-right:auto;" height="500" width="900" >

	<tr>
		<th>Order Id</th>
		<th>Product Name</th>
		<th>Product Price</th>
	</tr>

	<%
		for(MyOrderList u : ul) {
	%>
	
	
	<tr>
		<td><%=Orid++%></td>
		<td><%=u.getPname()%></td>
		<td><%=u.getPrice()%></td>
	</tr>
	
	<% } %>
	
	
	
	<tr>
		<td><b>Order Date</b></td>
		<td colspan="2"><%=g.getDate()%></td>
		<td><b>Total Bill</b></td>
		<td colspan="2"><%=g.getTbill()%></td>
	</tr>
	
</table>
</form>

</div>
  <!-- /.container -->

<!--   footer page -->
  <jsp:include page="footer.jsp" />



</body>
</html>
