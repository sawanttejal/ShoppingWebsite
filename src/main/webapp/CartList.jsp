<%@page import="java.util.List"%>
<%@page import="com.pojo.CartList"%>
<%@page import="com.Ecommer.Dao.ProductDao"%>

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
  
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	
</head>

<style>
body  {
  background-color: #cccccc;
}

</style>


<body>

<%
	List<CartList> ul = (List<CartList>) session.getAttribute("cartlist");
// 	ProductDao pd = new ProductDao();
// 	String email =(String)session.getAttribute("userName");
// 	List<CartList> ul = pd.cartListByEmail(email);	

	

	int cartid = 1;
 %>
 
<!-- 	Navigation --> <jsp:include page="Nav.jsp" />

<!-- Page Content -->
  <div class="container">

<%-- <%	 --%>
<!--  	String cartproductdelete = (String) request.getAttribute("deleteCartProduct"); -->
        
<!-- 	if(cartproductdelete != null) {	 -->
<%-- %>	 --%>
		
<%-- <br><p><center><h6><%=cartproductdelete%></h6></center></p>	 --%>
		
<%-- <%	} %> --%>
    

<form action="PlaceOrderServlet">

	<input type="hidden" name="action" value="takeinput">
	
	<table style="margin-left:auto;margin-right:auto;" height="500" width="900" >
	
		<tr>
			<th>Serial No.</th>
			<th>Product Name</th>
			<th>Product Price</th>
			<th>Product description</th>
			<th>Product Quantity</th>
			<th>Total price</th>
			<th></th>
			<th colspan="2">Action</th>
			
		</tr>
		
		<%
		  	 double total = 0; 
			for(CartList cl : ul) {
		
		%>		
				<tr>
					<td><%=cartid++%></td>
					
					<td><input name="pname" value="<%=cl.getPname()%>" disabled></td>
					
					<td><input type="text" class ="num1" value="<%=cl.getPrice()%>" size="3" disabled></td>
					
					<td><%=cl.getDescription()%></td>
					
					<td><input type="number" value="1" class = "num2" name="qty" size="2"></td>
					
					<td><input type="text" class = "num3" name="pprice" value="<%=cl.getPrice()%>" size="5" readonly></td>
					<td></td>
					<td><a href="ProductServlet?action=cartdelete&pid=<%=cl.getPid()%>">Delete</a></td>
					
				</tr>
			
		<% 
			total = total + cl.getPrice();
			
			} %>
		
		
		<tr>
			<td colspan="2"><input type="submit" value="Place Order"></td>
			<td><b>Total price</b></td>
			<td colspan="2"><input type="text" id="total" name="total" value="<%=total %>" readonly></td>
		</tr>
		
	</table>
</form>

</div>
  <!-- /.container -->

<!--   footer page -->
  <jsp:include page="footer.jsp" />




</body>

<script>
	$(".num2").change(function(){
		var val1=$(this).val();
		var val2=$(this).closest('tr').find('.num1').val();
		$(this).closest('tr').find('.num3').val(parseInt(val1) * parseInt(val2));
		var total=0;
		$(".num3").each(function(){
			total=total+parseInt($(this).val());
	})
		//console.log(total);
		$("#total").val(total);

	});
	
	
// 		$(document).ready(function(){
		
// 			$(".num2").change(function(){
			  	
// 				var val1=parseInt($('.num2').val());
// 			    var val2=parseInt($('#num1').val());
			                
// 			   $('#num3').val(val1 * val2);
			 	
// 			   	var total = $("#num3").val();
			 	
// 			   	//$("#total").val(total);
			 	
// 			  });
// 			});
	</script>
</html>
