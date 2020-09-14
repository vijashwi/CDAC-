<html>
<%@ page import="java.util.*"%>
<%@ page import="src.com.in.squad.khanakhaza.pojo.Food"%>

<head>
<title>Welcome to FoodPLaza</title>
<link rel="stylesheet" type="text/css" href="demo.css">
<!-- <script type="text/javascript" src="validation.js"></script> -->
</head>
<body>
	<%
		Food food = new Food();
		List<Food> fli = (List<Food>) request.getAttribute("foodlist");
		String username = (String) session.getAttribute("username");
		String type = (String) session.getAttribute("login_type");
	%>


	<jsp:include page="Header.jsp" />
	<div style="margin: 60 auto;">
		<form action="#" method="get">


			<center>
				<h1>Food List</h1>
			</center>
			<hr width="300">
			<table border="1" align="center" style="margin: 40 auto;"
			cellpadding="10">
			<%
				if (type == null || type.equalsIgnoreCase("customer") || type.equalsIgnoreCase("admin")) {
			%>
			<tr>
				<th>Food ID</th>
				<th>Food Name</th>
				<th>Food Cost</th>
				<th>Food type</th>
				
				<%
					} else {
				%>
				<th>Food ID</th>
				<th>Food Name</th>
				<th>Food Cost</th>
				<th>Food type</th>
				<th>AddToCart</th>

				<%
					}
				%>
				<%if(type==null){ %>
				<th>AddToCart</th>
				<%} %>
				<%
					if (type != null && type.equalsIgnoreCase("admin")) {
				%>
				<th>Food Edit</th>
				<th>Food Delete</th>

				<%
					}
				%>



			</tr>

			<%
				for (int i = 0; i < fli.size(); i++) {
					
						food = fli.get(i);
			%>



			<tr>
				<td><%=food.getFood_id()%></td>
				<td><%=food.getFood_name()%></td>
				<td><%=food.getFood_cost()%></td>
				<td><%=food.getFood_type()%></td>

				<%
					if (type == null || type.equalsIgnoreCase("customer") || type.equalsIgnoreCase("admin")) {
				%>

				<%
					} else if (type != null || type.equalsIgnoreCase("customer")) {
				%>
				<td><a href="CommonCartServlet?action=addcart&food_id=<%=food.getFood_id()%>">AddToCart</a></td>

				<%
					}
				%>

				<%
					if (type != null && type.equalsIgnoreCase("admin")) {
				%>

				<td><a
					href="UpdateFood.jsp?fid=<%=food.getFood_id()%>&fname=<%=food.getFood_name()%>&fcost=<%=food.getFood_cost()%>">Edit</a></td>
				<td><a
					href="CommonFoodServlet?action=deletefood&fid=<%=food.getFood_id()%>">Delete</a></td>

				<%
					}
				%>
				<%if(type==null ) {%>
				<td><a href="AddCustomer.jsp">AddTocart</a></td>
				<%} %>
				<%
					}
				%>
			
		</table>
			
		</form>
		<jsp:include page="Footer.jsp"></jsp:include>
	</div>
	
</body>
</html>


