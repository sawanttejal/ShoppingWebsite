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


h6 {
  color: red;
}

</style>

<body>

<%
 	String msg = (String) request.getAttribute("msg");
 	if(msg != null) {
%>

<br><p><center><h6><%=msg%></h6></center></p>

<% }%>
	
<!-- 	Navigation --> <jsp:include page="Nav.jsp" />

<form action="LoginServlet" method="post">

	<table style="margin-left:auto;margin-right:auto;" height="500" width="900" >
		
	<tr>
		<td>Enter Username</td>
		<td><input type="text" name="username" required></td>
	</tr>
	
	<tr>
		<td>Enter Password</td>
		<td><input type="password" name="password" required></td>
	</tr>	
	
	<tr>
		<td><input type="submit" value="Login"></td>
		<td><a href="adduser.jsp"><i>Click here for Register</i></a></td>
	</tr>
	
	</table>

</form>

  <!--   footer page -->
  <jsp:include page="footer.jsp" />
  

</body>
</html>