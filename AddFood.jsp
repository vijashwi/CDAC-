<html>
<head>
<title>Welcome to FoodPLaza</title>
<link rel="stylesheet" type="text/css" href="demo.css">
<!-- <script type="text/javascript" src="validation.js"></script> -->
</head>
<body>

<jsp:include page="Header.jsp" />
<div style="margin:60 auto;">

<form action="CommonFoodServlet" method="post" onsubmit="return adderrormessageonaddfood()">
<input type="hidden" name="action" value=addfood >

<center><h1>ADD FOOD </h1></center>
<hr width="400">
<table  align="center"  style="margin:40 auto;" cellpadding="5">

<tr> 
<th>FOOD CATEGORY :</th><td>
<select id="food_category" name="food_category" oninput="hideerrormessageonaddfood()" >
<option value="0">Select Category</option>
<option value="1">Veg</option>
<option value="2">Non-Veg</option>
</select></td>
<td><span id="foodcategoryerrmsg"></span></td></tr>


<tr><td>Food Name </td><td><input type="text" id="food_name" name="food_name" oninput="hideerrormessageonaddfood()" /></td>
<td><span id="foodnameerrmsg"></span></td>
</tr>
<tr><td>Food Cost </td><td><input type="text" id="food_cost" name="food_cost" oninput="hideerrormessageonaddfood()"  /></td>
<td><span id="foodcosterrmsg"></span></td>
</tr>

</table>
<center style ="margin:40 auto" colspan="2" align="center"><input type="Submit" value="Save" id="submit"/></center>
</form>
</div>
</body>
</html>


