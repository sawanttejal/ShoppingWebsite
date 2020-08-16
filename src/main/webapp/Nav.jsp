<%

	String adminName=(String)session.getAttribute("adminName");

	String userName =(String)session.getAttribute("userName");

%>


  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="#">Flipkart Ecommerce</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
         
          <li class="nav-item active">
            <a class="nav-link" href="index.jsp?action=home">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
         
  			<!-- product list old , now i moved for admin login only -->
         
          <li class="nav-item">
            <a class="nav-link" href="search.jsp">Search</a>
          </li>
          
          
        <%if (userName!=null && adminName==null){ %>
			
			<li class="nav-item">
            	<a class="nav-link" href="UserServlet?action=EditProfile">EditProfile</a>
         	</li>
        
        	<li class="nav-item">
              	<a class="nav-link" href="ProductServlet?action=cartlist">CartList</a>
<!--  			<a class="nav-link" href="CartList.jsp">CartList</a>  -->
         	</li>
        
        
        	<li class="nav-item">
            	<a class="nav-link" href="PlaceOrderServlet?action=OrderList">MyOrderList</a>
         	</li>
         	
         	<li class="nav-item">
            	<a class="nav-link" href="feedback.jsp">Feedback</a>
         	</li>
        
		<%} %>
	
		<%if(adminName!=null && userName==null){ %>
		
			<li class="nav-item">
            	<a class="nav-link" href="ProductServlet">Product List</a>
          	</li>
	
 			<li class="nav-item">
            	<a class="nav-link" href="category.jsp">Category</a>
          	</li>
          	
          	<li class="nav-item">
            	<a class="nav-link" href="product.jsp">AddProduct</a>
          	</li>
          	
          	<li class="nav-item">
            	<a class="nav-link" href="PlaceOrderServlet">OrderList</a>
          	</li>
          	
          	<li class="nav-item">
            	<a class="nav-link" href="UserServlet">UserList</a>
          	</li>
          
          	<li class="nav-item">
            	<a class="nav-link" href="FeedbackList.jsp">Feedback List</a>
          	</li>
          
		<%} %>
		
		
		<%if (userName==null && adminName==null){ %>
	
	 		<li class="nav-item">
            	<a class="nav-link" href="adduser.jsp">Register User</a>
          	</li>
          
          	<li class="nav-item">
            	<a class="nav-link" href="login.jsp">Login</a>
          	</li>
	
	
		<%} %>
	
		<%if(userName!=null || adminName!=null) {%>
		
			<li class="nav-item">
            	<a class="nav-link" href="LoginServlet">LogOut</a>
          	</li>
		
		<%} %>

        </ul>
      </div>
    </div>
  </nav>
