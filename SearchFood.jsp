<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page import="src.com.in.squad.khanakhaza.pojo.Food"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to FoodPlaza</title>
<link rel="stylesheet" type="text/css" href="demo.css">
</head>
<body>
	<%
		List<Food> fli = (List<Food>) request.getAttribute("foodlist");
		String username = (String) session.getAttribute("username");
		String type = (String) session.getAttribute("login_type");
	%>

	<jsp:include page="Header.jsp"></jsp:include>
	<br>
	<br>
	<div style="margin: 60 auto;">

		<%
			if (fli == null) {
		%>
		<form action="CommonFoodServlet" method="get">
			<input type="hidden" name="action" value=searchfood>

			<center>
				<h1>Search Food</h1>
			</center>
			<hr width="300">
			<table align="center" style="margin: 40 auto;" cellpadding="2">
				<tr>
					<td>Enter Name<input type="text" name="fname"
						placeholder="Enter food name"></td>
				</tr>

			</table>

			<center style="margin: 40 auto;" colspan="2" align="bottom">
				<input type="Submit" value="Search" />
			</center>
		</form>
		<%
			} else {
		%>
		<form action="CommonFoodServlet" method="get">
			<input type="hidden" name="action" value=searchfood>

			<center>
				<h1>Search Food</h1>
			</center>
			<hr width="300">
			<table align="center" style="margin: 40 auto;" cellpadding="2">
				<tr>
					<td>Enter Name<input type="text" name="fname"
						placeholder="Enter food name"></td>
				</tr>

			</table>
			<center style="margin: 40 auto;" colspan="2" align="bottom">
				<input type="Submit" value="Search" />
			</center>
		</form>
		<br>
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
					Food food = new Food();
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
				<td><a href="AddCart.jsp?fid=<%=food.getFood_id()%>">AddToCart</a></td>

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

				<%
					}
				%>
	
				<%
					}
				%>
			
		</table>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>