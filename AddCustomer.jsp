<html>
<head>
<title>Welcome to FoodPLaza</title>
<link rel="stylesheet" type="text/css" href="demo.css" >
<!-- <script type="text/javascript" src="validation.js"> -->

</head>
<body>
<jsp:include page="Header.jsp" />

<div style="margin:60 auto;">
<center><h1>CUSTOMER REGISTRATION</h1></center>
<hr width="400">

<form action="CommonCustomerServlet" method="Post" onsubmit="return add()">
<input type="hidden" name="action" value=addcust />

<table align="center" style="margin:40 auto;" cellpadding="5">

<!--  <tr><td colspan="2" align="center" ><h1>ADD CUSTOMER</h1></td></tr>  -->
 
<tr>
<td> Customer Name</td>
<td><input type="text" id="cust_name" name="cust_name" oninput="hideerrormessage()"/>
</td>
<td><span id="cust_nameerrmsg"></span></td>
</tr>

<tr>
<td> Customer Address</td>
<td><input type="text" id="cust_add" name="cust_add" oninput="hideerrormessage()"/></td>
<td><span id="cust_adderrmsg"></span></td>
</tr>

<tr>
<td> Customer Email</td>
<td><input type="text" id="cust_email" name="cust_email" oninput="hideerrormessage()"/></td>
<td><span id="cust_emailerrmsg"></span></td>
</tr>

<tr>
<td> Customer Mobile Number</td>
<td><input type="text" id="cust_mobileno" name="cust_mobileno" oninput="hideerrormessage()" /></td>
<td><span id="cust_mobilenoerrmsg"></span></td>
</tr>



<tr>
<td> Password</td>
<td><input type="password" id="cust_password" name="cust_password"  oninput="hideerrormessage()" /></td>
<td><span id="cust_passworderrmsg"></span></td>
</tr>



</table>
<center style ="margin:40 auto;" colspan="2" align="bottom"><input type="Submit" value="Register" id="submit"/></center>
</form>
<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>


