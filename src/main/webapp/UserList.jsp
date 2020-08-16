<%@page import="java.util.List"%>
<%@page import="com.pojo.User"%>
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
	List<User> ul = (List<User>) session.getAttribute("UserList");
 %>
 
<!-- 	Navigation --> <jsp:include page="Nav.jsp" />

<!-- Page Content -->
  <div class="container">

 

<form action="UserServlet">

<table style="margin-left:auto;margin-right:auto;" height="500" width="900" >

	<tr>
		<th>User Id</th>
		<th>User Name</th>
		<th>Contact no.</th>
		<th>Gender</th>
		<th>Date of birth</th>
		<th>Email ID</th>
		<th>Password</th>
		<th colspan="2">Action</th>
	</tr>
	
	<%
		for(User u : ul) {
	%>
	
	
	<tr>
		<td><%=u.getUserid() %></td>
		<td><%=u.getName()%></td>
		<td><%=u.getContact()%></td>
		<td><%=u.getGender()%></td>
		<td><%=u.getDob()%></td>
		<td><%=u.getEmail()%></td>
		<td><%=u.getPassword()%></td>
		<td><a href="UserServlet?action=delete&email=<%=u.getEmail()%>">Delete</a></td>
	</tr>
	
	<% } %>
	
</table>
</form>

</div>
  <!-- /.container -->

<!--   footer page -->
  <jsp:include page="footer.jsp" />



</body>
</html>



<%-- <!-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" --%>
<%--     pageEncoding="ISO-8859-1"%> --%>
<%--    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> --%>
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="ISO-8859-1"> -->
<!-- <title>Insert title here</title> -->
<!-- </head> -->
<!-- <body> -->
<%-- <% int sr=1 ;%> --%>
<!-- <h1>Users Info</h1> -->
<!-- <table> -->

<!-- <tr> -->
<!-- <th>SrNo.</th><th>Name</th><th>Contact</th><th>Email</th><th>Gender</th><th>DOB</th> -->
<!-- </tr> -->

<!-- <c:forEach var="u" items="${ulist }"> -->

<!-- <tr> -->
<%-- <td><%=sr++ %></td> --%>
<!-- <td>${u.name }</td> -->
<!-- </tr> -->

<!-- </c:forEach> -->

<!-- </table> -->

<!-- </body> -->
<!-- </html> -->
<!-- --> -->