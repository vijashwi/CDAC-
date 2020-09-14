<%@ page import="java.util.*"%>
<%@ page import="src.com.in.squad.khanakhaza.pojo.*"%>
<html>
<head>
<title>Welcome to FoodPLaza</title>
<link rel="stylesheet" type="text/css" href="demo.css">
<script type="text/javascript" src="validation.js"></script>

</head>
<body>
	<%
		Cart c = new Cart();
		List<Cart> li = (List<Cart>) request.getAttribute("allcartlist");
		String type = (String) session.getAttribute("login_type");
	%>

	hello<%=type%>
	<jsp:include page="Header.jsp" />

	<div style="margin: 60 auto;">
	
			<input type="hidden" name="action" value=cartlist />

			<center>
				<h1>Cart List</h1>
			</center>
			<hr width="300">
			<table border="8" align="center" style="margin: 40 auto;"
				cellpadding="10">

				<%
					if (type == null || type.equalsIgnoreCase("customer") || type.equalsIgnoreCase("admin")) {
				%>
				<tr>
					<th>Cart ID</th>
					<th>Food ID</th>
					<th>Customer Email</th>
					<th>Food Quantity</th>
					
					<%
						} else {
					%>
					<th>Cart ID</th>
					<th>Food ID</th>
					<th>Customer Email</th>
					<th>Food Quantity</th>
					<th>Update</th>
							<th>Delete</th>


					<%
						}
					%>

				</tr>

				<%
				
					for (int i = 0; i < li.size(); i++) {

						c = li.get(i);
				%>
				<tr>
					<form action="CommonCartServlet" method="post">
					<input type="hidden" name="action" value=updatecart>
					<td><input type="text" name="cid" readonly value= <%=c.getCart_id()%> /></td>
					
					<td><%=c.getFood_id()%></td>
					<td><%=c.getCust_email()%></td>
					<td><input type="number" name="quanity" value=<%=c.getFood_qty()%> /></td>
					
					<%if(type!=null || type.equalsIgnoreCase("customer")){ %>
					<td><input type="submit" value="Update" /></td>
					<%} %>

					<%
						if (type == null || type.equalsIgnoreCase("customer") || type.equalsIgnoreCase("admin")) {
					%>

					<%
						} else if (type != null || type.equalsIgnoreCase("customer")) {
					%>
					<td><a
						href="CommonCartServlet?action=deletecart&cid=<%=c.getCart_id()%>">Delete</a></td>

					<%
						}
					%>
					</form>
				</tr>

				<%
					}
				%>
				<%
					if (type == null || type.equalsIgnoreCase("customer") || type.equalsIgnoreCase("admin")) {
				%>

				<%
					} else if (type != null || type.equalsIgnoreCase("customer")) {
				%>
			</table>
			<table align="center">
				<tr>
					<td>
						<Button>
							<a href="CommonCartServlet?action=deleteall">Delete All</a>

						</Button>
					</td>
					<td>
						<Button>
							<a href="CommonOrderServlet?action=placeorder">Place Order</a>
						</Button>
					</td>
				</tr>
				<%
					}
				%>



			</table>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>


