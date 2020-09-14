
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="dropdown.css">
<title>Header</title>
</head>
<body>
	<%
		String username = (String) session.getAttribute("username");
		String type = (String) session.getAttribute("login_type");
	%>
	<div id="templatemo_container">

		<!--  Free CSS Template by TemplateMo.com  -->

		<div id="templatemo_header">
			<div id="site_title"></div>
		</div>
		<!-- end of header -->

		<!--displaying menu bar depend on user type= No user/Customer/Admin  -->
		<div id="templatemo_menu">
			<ul>
				<%
					if (username == null || type == null) {
				%>
				<li><a href="index.jsp"><b>Home</b></a></li>
				<li><a href="CommonFoodServlet?action=foodlist"><b>Food
							Menu</b></a></li>
				<li><a href="SearchFood.jsp"><b>Search</b></a></li>
				<li><a href="AddCustomer.jsp"><b>Register</b></a></li>
				<li><a href="LoginPage.jsp"><b>Login</b></a></li>
				<%
					} else if (username != null && type != null && type.equalsIgnoreCase("admin")) {
				%>


				<div class="navbar">
	<li><a href="index.jsp"><b>Home</b></a></li>
					<div class="dropdown">
						<button class="dropbtn">
							Customer <i class="fa fa-caret-down"></i>
						</button>
						<div class="dropdown-content">
							<a href="SearchCustomer.jsp">Search Customer</a> <a
								href="CommonCustomerServlet?action=allcustlist">Customer
								List</a>
						</div>
					</div>
				
					<li><a href="CommonFoodServlet?action=foodlist"><b>Food
								Menu</b></a></li>
					<li><a href="AddFood.jsp"><b>Register Food</b></a></li>
					<li><a href="SearchFood.jsp"><b>Search</b></a></li>

					<!-- 				<li><a href="SearchCart.jsp"><b>Search Cart</b></a></li> -->
					<li><a href="CommonCartServlet?action=allcartlist"><b>Cart-List</b></a></li>

					<li><a href="CommonOrderServlet?action=allorders"><b>Order-List</b></a></li>
					<li><a href="CommonLoginServlet"><b>Log-out</b></a></li>
				</div>





				<%
					} else if (username != null || type != null && type.equalsIgnoreCase("customer")) {
				%>
				<li><a href="index.jsp"><b>Home</b></a></li>
				<li><a href="CommonFoodServlet?action=foodlist"><b>Food
							Menu</b></a></li>
				<li><a href="CommonCartServlet?action=customercartlist"><b>Cart-List</b></a></li>
				<li><a href="CommonOrderServlet?action=myorder"><b>Order-List</b></a></li>
				<li><a href="SearchFood.jsp"><b>Search</b></a></li>
				<!-- 					<li><a href="SearchCart.jsp"><b>Search Cart</b></a></li> -->
				<li><a href="CommonLoginServlet"><b>Log-out</b></a></li>


				<%
					}
				%>
				<!--       		  <li><a href="#"><b>Show Customer</b></a></li> -->
				<!--             <li><a href="#"><b>Add Food</b></a></li> -->
				<!--           <li><a href="#"><b>Show Orders</b></a></li> -->
				<!--                 <li ><a href="#"><b>Feedback</b></a></li>    -->



				<!--             <li ><a href="#"><b>Edit Profile</b></a></li> -->
				<!--             <li ><a href="#"><b>Show Cart</b></a></li> -->
				<!--                  <li ><a href="#"><b>Feedback</b></a></li> -->





			</ul>
		</div>
		<!-- end of menu -->
	</div>
</body>
</html>