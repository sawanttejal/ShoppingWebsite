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
	
	  <title>Register Page</title>
	
	  <!-- Bootstrap core CSS -->
	  <link href="resources/css/bmin.css" rel="stylesheet">

	  <!-- Custom styles for this template -->
	  <link href="resources/css/homecss.css" rel="stylesheet">

</head>

<style>
body  {
  background-color: #cccccc;
}

h6 {
  color: red;
}

</style>


<body>

<%
	String duplicate = (String) request.getAttribute("duplicate");
	if(duplicate != null) {
%>

<br><p><center><h6><%=duplicate%></h6></center></p>

<% } %>


<%
	String wrongpass = (String) request.getAttribute("wrongpass");
	if(wrongpass != null) {
%>

<br><p><center><h6><%=wrongpass%></h6></center></p>

<% } %>


<!-- 	Navigation --> <jsp:include page="Nav.jsp" />

<!-- Page Content -->
  <div class="container">

   
	<form action="UserServlet"  method ="post">
	
		<input type="Hidden" name="action" value="AddRegisterUserNew">
	
		<table style="margin-left:auto;margin-right:auto;" height="500" width="900" >
	
				<tr>
					<td>Enter Email Id</td>
					<td><input type="text" name="email" required></td>
				</tr>
				
				<tr>
					<td>Enter Password</td>
					<td><input type="password" name="password" required></td>
				</tr>
				
				<tr>
				<td>Enter Confirm Password</td>
				<td><input type="password" name="Cpassword" required></td>
				</tr>
				
				<tr>
				<td><input type="submit" value="submit"></td>
				
				<td><a href="UserServlet?action=EditProfile"><i>Edit Profile</i></a></td>
				</tr>
			
			</table>
		</form>
		
</div>
  <!-- /.container -->

<!--   footer page -->
  <jsp:include page="footer.jsp" />

	
</body>
</html>