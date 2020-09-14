<%@ page import="java.util.*"%>
<%@ page import="src.com.in.squad.khanakhaza.pojo.Food"%>
<html>
<head>
<title>Welcome to FoodPLaza</title>
<link rel="stylesheet" type="text/css" href="demo.css">

<!-- <script type="text/javascript" src="validation.js"></script> -->
</head>
<body>
	<%
		int fid = Integer.parseInt(request.getParameter("fid"));
		String fname = request.getParameter("fname");
		int fcost = Integer.parseInt(request.getParameter("fcost"));
	
	%>



	<jsp:include page="Header.jsp" />
	<div style="margin: 60 auto;">
		<center>
			<h1>Update Food</h1>
		</center>
		<hr width="400">
		<form action="CommonFoodServlet" method="Post"
			onsubmit="return adderrormessageupdatefood()">
			<input type="hidden" name="action" value=updatefood>

			<table align="center" style="margin: 30 auto;" cellpadding="8">



				<tr>
					<td>Food ID</td>
					<td><input type="text" name="food_id" value="<%=fid%>" /></td>
				</tr>
				<tr>
					<th>FOOD CATEGORY :</th>
					<td><select id="food_category" name="food_category" 
						oninput="hideerrormsgonupdatefood()">
							<option value="0">Select Category</option>
							<option value="veg">Veg</option>
							<option value="non-veg">Non-Veg</option>
					</select></td>
					<td><span id="foodcategoryerrmsg"></span></td>
				</tr>


				<tr>
					<td>Food Name</td>
					<td><input type="text" id="food_name" name="food_name"
						value=<%=fname%> oninput="hideerrormsgonupdatefood()" /></td>
					<td><span id="foodnameerrmsg"></span></td>
				</tr>
				<tr>
					<td>Food Cost</td>
					<td><input type="text" id="food_cost" name="food_cost"
						value=<%=fcost%> oninput="hideerrormsgonupdatefood()" /></td>
					<td><span id="foodcosterrmsg"></span></td>
				</tr>

<tr>
					<td>Food Quantity</td>
					<td><input type="text" id="food_cost" name="food_qty"
						 oninput="hideerrormsgonupdatefood()" /></td>
					<td><span id="foodcosterrmsg"></span></td>
				</tr>

			</table>
			<center style="margin: 40 auto;" colspan="2" align="bottom">
				<input type="Submit" value="Update" />
			</center>
		</form>
	</div>
</body>
</html>


