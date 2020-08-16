<!DOCTYPE html>
<%@page import="com.Ecommer.Dao.ProductDao"%>
<%@page import="com.pojo.Product"%>
<%@page import="java.util.List"%>
<html lang="en">

<head>

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
	
	h6 {
	  color: red;
	}

</style>

<body>

<%
	//Product p = new Product();
	//ProductDao pd = new ProductDao();
	//List<Product> prolist = pd.getproductList();
	

	String adminName=(String)session.getAttribute("adminName");

	String userName =(String)session.getAttribute("userName");
	
	String action = request.getParameter("action");
	
%>

<!-- 	Navigation --> <jsp:include page="Nav.jsp" />


  <!-- Page Content -->
  <div class="container">

    <div class="row">

	<!-- SiteBar --> <jsp:include page="SiteBar.jsp" />
      
      
     <!-- /.col-lg-3 -->

      <div class="col-lg-9">

<%-- 	<!-- Slider Page -->  <jsp:include page="SliderPage.jsp" /> --%>
	
	<%	String add = (String) request.getAttribute("addtocart");
        
			if(add != null) {	
	%>	
		
	<br><p><center><h6><%=add%></h6></center></p>	
		
	<%	} %>
      
       
       <br> <br> <br> <br>
				<form action="ProductServlet" method="post">
				
				<input type="Hidden" name="action" value="Search">
				
					<table cellpadding="10" cellspacing="10">
						<tr>
							<td><textarea rows="1" cols="70" name="searchProduct"></textarea></td>
							<td><input type="submit" value="Search"></td>
						</tr>
					</table>
				</form>
       
       
        <div class="row">
        
          
         <%     
        
        		ProductDao pd = new ProductDao();
        		List<Product> pl=(List<Product>)session.getAttribute("getbycategory");
    			 if( (pl==null) || (action != null && action.equals("home")))
    			{
    				 pl = pd.getproductList();
     			}
    			 
    			 for(Product p : pl) {
         %>

	          <div class="col-lg-4 col-md-6 mb-4">
	            <div class="card h-100">
	              <a href="#"><img class="card-img-top" src="resources/image/<%=p.getId()%>.jpg" alt=""></a>
	              <div class="card-body">
	                <h4 class="card-title">
	                  <a href="#"><%=p.getPname()%></a>
	                </h4>
	                <h5><%=p.getPrice() %></h5>
	                
	                <% if(userName != null) { %>
	                
	                <h6><button><a href="ProductServlet?action=addToCart&pid=<%=p.getId()%>">addToCart</a></button></h6>

					<% } %>
					
					<% if(userName == null && adminName == null) { %>	                
	               
	                <h6><button><a href="login.jsp">addToCart</a></button></h6>
	               
	               	<% } %>
	               	 
	                <p class="card-text"><%=p.getDescription() %></p>
	              </div>
	              <div class="card-footer">
	                <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
	              </div>
	            </div>
	          </div>
	          <% } %>
            </div>
          </div>
		
        </div>
        <!-- /.row -->

      </div>
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

  <!-- Footer -->
  
<!--   footer page -->
  <jsp:include page="footer.jsp" />
  
  
  <!-- Bootstrap core JavaScript -->
  <script src="resources/js/js1.js"></script>
  <script src="resources/js/js2.js"></script>

</body>

</html>
