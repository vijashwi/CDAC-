<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page import="src.com.in.squad.khanakhaza.pojo.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to FoodPlaza</title>
<link rel="stylesheet" type="text/css" href="demo.css">
</head>
<body>

	<%
		List<Customer> li = (List<Customer>) request.getAttribute("allcustlist");
		Customer c = new Customer();
		String type = (String) session.getAttribute("login_type");
		String uname = (String) session.getAttribute("username");
	%>
	<jsp:include page="Header.jsp"></jsp:include>
	<br>
	<br>

	<div style="margin: 60 auto;">

		<%
			if (li == null) {
		%>
		<form action="CommonCustomerServlet" method="get">
			<input type="hidden" name="action" value=searchcust>

			<center>
				<h1>Search Customer</h1>
			</center>
			<hr width="300">
			<table align="center" style="margin: 40 auto;" cellpadding="2">
				<tr>
					<td>Enter Name<input type="text" name="custname"
						placeholder="Enter Customer name"></td>
				</tr>

			</table>

			<center style="margin: 40 auto;" colspan="2" align="bottom">
				<input type="Submit" value="Search" />
			</center>
		</form>
		<%
			} else {
		%>
		<form action="CommonCustomerServlet" method="get">
			<input type="hidden" name="action" value=searchcust>

			<center>
				<h1>Search Customer</h1>
			</center>
			<hr width="300">
			<table align="center" style="margin: 40 auto;" cellpadding="2">
				<tr>
					<td>Enter Name<input type="text" name="custname"
						placeholder="Enter Customer name"></td>
				</tr>

			</table>

			<center style="margin: 40 auto;" colspan="2" align="bottom">
				<input type="Submit" value="Search" />
			</center>
		</form>
				
		<table border="8" align="center" style="margin: 40 auto;"
			cellpadding="10">


			<tr>
				<th>Customer ID</th>
				<th>Customer Name</th>
				<th>Customer Email</th>
				<th>Customer Address</th>
				<th>Customer Mobile</th>
				<th>Customer Password</th>
				<%
					if (uname != null && type.equalsIgnoreCase("admin")) {
				%>
				<th>Edit</th>
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
				<td><%=c.getCust_id()%></td>
				<td><%=c.getCust_name()%></td>
				<td><%=c.getCust_email()%></td>
				<td><%=c.getCust_add()%></td>
				<td><%=c.getMobile_num()%></td>
				<td><%=c.getCust_password()%></td>

				<%
					if (uname != null && type.equalsIgnoreCase("admin")) {
				%>
				<td><a
					href="UpdateCustomer.jsp?cid=<%=c.getCust_id()%>&cname=<%=c.getCust_name()%>&cemail=<%=c.getCust_email()%>&cadd=<%=c.getCust_add()%>&cnum=<%=c.getMobile_num()%>&cpass=<%=c.getCust_password()%>">Edit</a></td>
				<td><a
					href="CommonCustomerServlet?action=deletecust&cid=<%=c.getCust_id()%>">Delete</a></td>

				<%
					}
				%>


				<%
					}
				%>
			</tr>
		</table>

		<%
			}
		%>


	</div>
</body>
</html>