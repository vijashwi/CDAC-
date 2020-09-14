<html>
<head>
<title>Welcome to FoodPLaza</title>
<link rel="stylesheet" type="text/css" href="demo.css" >
<!-- <script type="text/javascript" src="validation.js"> -->
</script>

</head>
<body>
<%			String email=(String)session.getAttribute("username");
 %>

<jsp:include page="Header.jsp" />

<div style="margin:60 auto;">
<form action="CommonOrderServlet" method="post" onsubmit="return addeerormessageoncart()" >
<input type="hidden" name="action" value=placeorder />

<center><h1>ADD ORDER</h1></center>
<hr width="400">
<table  align="center"  style="margin:40 auto;">




</tr>
<tr><td>Customer Email :</td><td><input type="text" id="cust_email" name="cust_email" value=<%=email %> placeholder="Enter Email" oninput="hideerrormsgoncart()" /></td>
<td><span id="custemailerrmsg"></span></td>
</tr>


</table>
<center style ="margin:40 auto;" colspan="2" align="center"><input type="Submit" value="Place Order" id="submit"/></center>
</form>
</div>
</body>
</html>