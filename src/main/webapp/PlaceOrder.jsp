<%@page import="java.time.LocalDate"%>
<%@page import="java.util.List"%>
<%@page import="com.pojo.User"%>
<%@page import="com.pojo.CartList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Ecommerce Website</title>

  <!-- Bootstrap core CSS -->
  <link href="resources/css/bmin.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="resources/css/homecss.css" rel="stylesheet">
  
<style>
body  {
  background-color: #cccccc;
}

</style>

</head>

<body>


<%
	//List<CartList> ul = (List<CartList>) session.getAttribute("cartlist");

	User u = (User) session.getAttribute("data");

	double Bill = (Double) session.getAttribute("bill");
	
	LocalDate date = LocalDate.now();

%>	


<!-- 	Navigation --> <jsp:include page="Nav.jsp" />



<!-- Page Content -->
  <div class="container">

<form action="PlaceOrderServlet">

	<input type="hidden" name="action" value="add">
	
	
	<table style="margin-left:auto;margin-right:auto;" height="500" width="900" >
	
	
		<tr>
			<td>Customer Name</td>
			<td><input type="text" name="cname" value="<%=u.getName()%>" readonly>
		</tr>
		
		
		<tr>
			<td>Contact No.</td>
			<td><input type="number" name="ccon" max="10" value="<%=u.getContact()%>" readonly>
		</tr>
		
		<tr>
			<td>Total Bill</td>
			<td><input type="text" name="bill" value="<%=Bill%>" readonly>
		</tr>
		
		<tr>
			<td>Payment Date</td>
			<td><input type="date" name="date" value="<%=date%>" readonly></td>
		</tr>
		
		<tr>
			<td>Select card</td>
			<td>
				<select name="card">
					<option>select card</option>
					<option>Debit Card</option>
					<option>Credit Card</option>
				</select>
			</td>
		</tr>
		
		<tr>
			<td>Enter Card No :</td>
			<td><input type="text" name="cardno" required></td>
		</tr>
		
		<tr>
			<td>Enter CVV No :</td>
			<td><input type="text" name="cvvno" required></td>
		</tr>
		
		<tr>
			<td><input type="submit"  value="Payment" onclick="myFunction()"></td>
			<td><input type="reset" value="reset"></td>
		</tr>
			
	
	</table>
</form>


</div>
  <!-- /.container -->



<!--   footer page -->
  <jsp:include page="footer.jsp" />


</body>

<script>
 function myFunction() {
   alert("Sucessfully placed your Order");
   window.location = 'index.jsp';
}
 </script> 

</html>