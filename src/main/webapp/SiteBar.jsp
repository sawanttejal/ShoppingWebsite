
<%@page import="com.pojo.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.Ecommer.Dao.CategoryDao"%>
<%
		CategoryDao cd = new CategoryDao();
		List<Category> ul = cd.getUserList();
%>

<div class="col-lg-3">

        <h1 class="my-4">Category Name</h1>
        <div class="list-group">
        	<%
				for (Category c :ul) {
			%>
        	
          <a href="ProductServlet?action=getproductbycate&cid=<%=c.getCid()%>" class="list-group-item"><%=c.getCatname() %></a>
          
          <% } %>
        </div>

</div>
