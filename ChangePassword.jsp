<html>
<head>
<title>Welcome to FoodPLaza</title>
<link rel="stylesheet" type="text/css" href="demo.css">
<script type="text/javascript" src="validation.js"></script>
</head>
<body>
<jsp:include page="Header.jsp" />
<div style="margin:60 auto;">
<center><h1>Change Password</h1></center>
<hr width="400">
<form action="#" method="#" >
<input type="hidden" name="action" value=changepassword />
<table  align="center" style="margin:30 auto;" cellpadding="8">

<tr><td >Username </td><td><input type="text" name="username" style="width:200" ></td></tr>
<tr><td >Old Password </td><td><input type="password" name="password" style="width:200"></td></tr>
<tr><td >New Password </td><td><input type="password" name="newpassword" style="width:200"></td></tr>
</table>
<center style ="margin:40 auto;" colspan="2" align="bottom"><input type="Submit" value="Update"/></center>
</form>
</div>
<jsp:include page="Footer.jsp" />
</body>
</html>


