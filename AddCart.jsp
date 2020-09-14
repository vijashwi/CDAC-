<html>
<head>
<title>Welcome to FoodPLaza</title>
<link rel="stylesheet" type="text/css" href="demo.css" >
<!-- <script type="text/javascript" src="validation.js"> -->
</script>

</head>
<body>
<% int fid=Integer.parseInt(request.getParameter("fid"));
String custemail=(String)session.getAttribute("username");
%>

<jsp:include page="Header.jsp" />

<div style="margin:60 auto;">
<form action="CommonCartServlet" method="Post" onsubmit="return addeerormessageoncart()" >
<input type="hidden" name="action" value=addcart />

<center><h1>ADD CART</h1></center>
<hr width="400">
<table  align="center"  style="margin:40 auto;">


<tr><td>Food ID </td><td><input type="text" id="food_id" name="food_id"  readonly value=<%=fid %> oninput="hideerrormsgoncart()"/></td>
<td><span id="foodiderrmsg"></span></td>

</tr>
<tr><td>Customer Email </td><td><input type="text" id="cust_email" name="cust_email" value=<%=custemail %> oninput="hideerrormsgoncart()" /></td>
<td><span id="custemailerrmsg"></span></td>
</tr>

<tr><td>Food Quantity </td><td><input type="text" id="food_quantity" name="food_quantity" oninput="hideerrormsgoncart()"/></td>
<td><span id="foodquantityerrmsg"></span></td>
</tr>

</table>
<center style ="margin:40 auto;" colspan="2" align="center"><input type="Submit" value="Add to Cart" id="submit"/></center>
</form>
</div>
</body>
</html>