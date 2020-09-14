<html>
<head>
<title>Welcome to FoodPLaza</title>
<link rel="stylesheet" type="text/css" href="demo.css">
<!-- <script type="text/javascript" src="validation.js"></script> -->
</head>

<body>

	<jsp:include page="Header.jsp" />
	<div style="margin: 60 auto;">
		<center>
			<h1>Login Page</h1>
		</center>
		<hr width="400">

		<form action="CommonLoginServlet" method="Post"
			onsubmit="return adderrormessageonLogin()">
			<input type="hidden" name="action" value=login>
			<table align="center" style="margin: 20 auto;" cellpadding="5">

				<tr>
					<td>
					<th>Login Type :</th>

					<td><select id="login_type" name="type"
						oninput="hiderrormessage()">
							<option value="0">Select Type</option>
							<option value="Admin">Admin</option>
							<option value="Customer ">Customer</option>
					</select></td>
					<td><span id="logintypeerrmsg"></span></td>
				</tr>


				<tr>
					<td>
					<th>Username</th>
					<td><input type="text" id="username" name="username"
						style="width: 200" oninput="hiderrormessage()" /></td>
					<td><span id="usernameerrmsg"></span></td>
				</tr>
				<tr>
					<td>
					<th>Password</th>
					<td><input type="password" id="password" name="password"
						style="width: 200" oninput="hiderrormessage()" /></td>
					<td><span id="passworderrmsg"></span></td>
				</tr>

			</table>

			
			<center><a href="AddCustomer.jsp">Sign-Up</a></center> 

			<center style="margin: 40 auto" colspan="2" align="bottom" />
			<input type="Submit" value="LOGIN" id="submit" />
		</form>
		<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>