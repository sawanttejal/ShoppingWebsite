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

	<% String userName =(String)session.getAttribute("userName"); %>
	
<!-- 	Navigation --> <jsp:include page="Nav.jsp" />

<!-- Page Content -->
  <div class="container">
	
	
<form action="UserServlet" method="post" name="from1">
	
	<input type="Hidden" name="action" value="updateprofile">

	<table style="margin-left:auto;margin-right:auto;" height="500" width="900" >
			
			<tr>
				<td>Enter Name</td>
				<td><input type="text" name="uname" required></td>
			</tr>
			
			<tr>
				<td>Enter contact No.</td>
				<td><input type="text" name="contact"  required></td>
			</tr>
			
			<tr>
				<td>Enter date of birth</td>
				<td><input type="date" name="dob" required></td>
			</tr>
			
			<tr>
				<td>Select gender</td>
				<td>
					<select name="gender" required>
						<option>select gender</option>
						<option>Female</option>
						<option>Male</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td>Enter Email Id</td>
				<td><input type="text" name="email" value="<%=userName%>"></td>
			</tr>
			
			<tr>
			
			<td><a href="changepass.jsp"><i>Change Password</i></a></td>
			
			</tr>
			
			<tr>
				<td><input type="submit" value="Submit" onclick="valrequired()"></td>
				<td><input type="reset" value="reset"></td>
			</tr>
		
		</table>
</form>

 </div>
  <!-- /.container -->

  <!-- Footer -->
  
<!--   footer page -->
  <jsp:include page="footer.jsp" />
  


</body>

<script>
  function valrequired() {
    var a = document.forms["from1"]["uname"].value;
    var b = document.forms["from1"]["contact"].value;
    var c = document.forms["from1"]["dob"].value;
    var d = document.forms["from1"]["gender"].value;
    if (a == null || a == "", b == null || b == "", c == null || c == "", d == null || d == "") {
      alert("Please Fill All Required Field");
      return false;
    }
  
  }
</script>


</html>