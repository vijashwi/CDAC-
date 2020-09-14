<html>
<head>
<title>Welcome to FoodPLaza</title>
<link rel="stylesheet" type="text/css" href="demo.css">

</head>
<body>
<%int cid=Integer.parseInt(request.getParameter("cid")); 
String cname=request.getParameter("cname");
String cadd=request.getParameter("cadd");
String cemail=request.getParameter("cemail");
String cnum=request.getParameter("cnum");
String cpass=request.getParameter("cpass");%>
<jsp:include page="Header.jsp"></jsp:include>
<div style="margin:60 auto;">
<center><h1>Update Customer</h1></center>
<hr width="400">
<form action="CommonCustomerServlet" method="Post"  onsubmit="return adderrormsgupdatecust()">
<input type="hidden" name="action" value=updatecust />
<table  align="center" style="margin:30 auto;" cellpadding="8">

<tr><td> Customer Id</td><td><input type="text" id="cust_id" name="cust_id" readonly value=<%=cid %> oninput="hideerrormessagecust()"/></td>
<tr><td> Customer Name</td><td><input type="text" id="cust_name" name="cust_name" value=<%=cname %> oninput="hideerrormessagecust()"/></td>
<td><span id="custnameerrmsg"></span></td>
</tr>
<tr><td> Customer Address</td><td><input type="text" id="cust_add" name="cust_add" value=<%=cadd %> oninput="hideerrormessagecust()"/></td>
<td><span id="custadderrmsg"></span></td>
</tr>
<tr><td> Customer Email</td><td><input type="text" readonly id="cust_email" name="cust_email" readonly value=<%=cemail %> ></td></tr>
<tr><td> Customer Mobile Number</td><td><input type="text" id="cust_mobileno" name="cust_mobileno" value=<%=cnum %> oninput="hideerrormessagecust()" /></td>
<td><span id="custmobilenoerrmsg"></span></td>
</tr>

<tr><td> Password</td><td><input type="text" readonly id="cust_password" name="cust_password" value=<%=cpass %> ></td></tr>


</table>
<center style ="margin:40 auto;" colspan="2" align="bottom"><input type="Submit" value="Update" id="submit"/></center>
</form>
</div>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>


