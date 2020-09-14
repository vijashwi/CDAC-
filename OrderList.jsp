<%@ page import="java.util.*"%>
<%@ page import="src.com.in.squad.khanakhaza.pojo.*"%>
<html>
<head>
<title>Welcome to FoodPLaza</title>
<link rel="stylesheet" type="text/css" href="demo.css">
</head>
<body>
	<%
		Orders o = new Orders();
		Date d = new Date();
		List<Orders> li = (List<Orders>) request.getAttribute("allorders");
		String type = (String) session.getAttribute("login_type");
	%>
	<jsp:include page="Header.jsp"></jsp:include>
	<div style="margin: 60 auto;">
		<form action="#" method="#">

			<center>
				<h1>Orders List</h1>
			</center>
			<hr width="300">
			<table border="8" align="center" style="margin: 40 auto;"
				cellpadding="10">

				<%
					if (type == null || type.equalsIgnoreCase("customer") || type.equalsIgnoreCase("admin")) {
				%>
				<tr>
					<th>Order ID</th>
					<th>Customer Email</th>
					<th>Total Bill</th>
					<th>Order Date/Time</th>
					

					<%
						} else {
					%>
					<th>Order ID</th>
					<th>Customer Email</th>
					<th>Total Bill</th>
					<th>Order Date/Time</th>
					<th>Delete Order</th>


					<%
						}
					%>
					<%
						for (int i = 0; i < li.size(); i++) {
							o = li.get(i);
					%>

				</tr>
				<tr>
					<th><%=o.getOrder_id()%></th>
					<th><%=o.getCust_email()%></th>
					<th><%=o.getTotal_bill()%></th>
					<%
						if (type != null && type.equalsIgnoreCase("admin")) {
					%>
					<th><%=d.toString()%></th>
					
					
					<%
						}
					%>

					<%
						if (type == null || type.equalsIgnoreCase("customer") || type.equalsIgnoreCase("admin")) {
					%>

					<%
						} else if (type != null || type.equalsIgnoreCase("customer")) {
					%>
					<th><%=d.toString()%></th>
					<td><a
						href="CommonOrderServlet?action=deleteorder&oid=<%=o.getOrder_id()%>">Delete</a></td>

					<%
						}
					%>

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
							<a href="CommonOrderServlet?action=deleteall">Delete All</a>

						</Button>
					</td>

				</tr>
				<%
					}
				%>



			</table>

		</form>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>


