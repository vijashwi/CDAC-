// display error mesage FOR CUSTTOMER

function add() {
	var name=/^[A-Za-z]+$/;
	var cust_name=document.getElementById("cust_name").value;
	var cust_add=document.getElementById("cust_add").value;
	
    var patt1 = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var cust_email=document.getElementById("cust_email").value;
	
	 var phoneno = /^\d{10}$/;
	var cust_mobileno=document.getElementById("cust_mobileno").value;
	
	var cust_city=document.getElementById("cust_city").value;
	
	var passw = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;
	var cust_password=document.getElementById("cust_password").value;


	
	if(!name.test(cust_name)){
		document.getElementById("cust_nameerrmsg").innerHTML="please enter name";
		
	}
	if(cust_add==""){
	document.getElementById("cust_adderrmsg").innerHTML="please enter address";
	}
	
	if (!patt1.test(cust_email)) {
    document.getElementById("cust_emailerrmsg").innerHTML="Please provide a valid email address";
	<!--    cust_email.focus; -->
 	}
  	if(!phoneno.test(cust_mobileno)){
  	      document.getElementById("cust_mobilenoerrmsg").innerHTML="Please provide a valid mobile number";
 	} 
 	if(cust_city==""){
 	document.getElementById("cust_cityerrmsg").innerHTML="Please enter City";
 	}
 	
 	if(!passw.test(cust_password)){
 	document.getElementById("cust_passworderrmsg").innerHTML="Enter valid password";
 	}
	return false;
}

//DISPLAY ERROR MESSAGE FOR ADD CART


function addeerormessageoncart(){
	var pat = /[0-9]/;
	var food_id=document.getElementById("food_id").value;
	
    var patt1 = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var cust_email=document.getElementById("cust_email").value;
	var food_quantity=document.getElementById("food_quantity").value;
	
	if(!pat.test(food_id)){
		document.getElementById("foodiderrmsg").innerHTML="Enter food id";
	}
	if(!patt1.test(cust_email)){
		document.getElementById("custemailerrmsg").innerHTML="Enter valid email address";
	}
	if(!pat.test(food_quantity)){
		document.getElementById("foodquantityerrmsg").innerHTML="Enter valid quantity";
	}
	return false;
}
//DISPAY ERROR MESSAGE ON ADD FOOD

function adderrormessageonaddfood(){
	
	var food_category=document.getElementById("food_category").value;
	var food_name=document.getElementById("food_name").value;
	var pat11=/[0-9]/;
	var food_cost=document.getElementById("food_cost").value;
	if(food_category==0){
		alert(food_category);
		document.getElementById("foodcategoryerrmsg").innerHTML="please select type of food";
	}
	if(food_name==""){
		document.getElementById("foodnameerrmsg").innerHTML="please enter food name";

	}
	if(!pat11.test(food_cost)){
		document.getElementById("foodcosterrmsg").innerHTML="Enter cost";
	}
	return false;
}

//Display Error message on Login Page

function adderrormessageonLogin() {
	
	var login_type=document.getElementById("login_type").value;
	var pattern = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var username=document.getElementById("username").value;
	
	var passwr = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;
	var password=document.getElementById("password").value;
	if(login_type==0){
		document.getElementById("logintypeerrmsg").innerHTML="please select type of food";
	}
	if(!pattern.test(username)){
		document.getElementById("usernameerrmsg").innerHTML="Enter valid username";
	}
	if(!passwr.test(password)){
		document.getElementById("passworderrmsg").innerHTML="Enter valid password";
	}
	
	return false;
}
//DISPLAY ERROR PAGE ON UPDATE CUSTOMER
function adderrormsgupdatecust(){
	var name=/^[A-Za-z]+$/;
	var cust_name=document.getElementById("cust_name").value;
	var cust_add=document.getElementById("cust_add").value;
	
	var phoneno=/\d{10}/;
	var cust_mobileno=document.getElementById("cust_mobileno").value;

	
	if(!name.test(cust_name)){
		document.getElementById("custnameerrmsg").innerHTML="Enter valid name";
	}
	if(cust_add==""){
		document.getElementById("custadderrmsg").innerHTML="please enter address";
	}
	
	if(!phoneno.test(cust_mobileno)){
		document.getElementById("custmobilenoerrmsg").innerHTML="please enter 10 digit number";
	}
	return false;
}

//DISPLAY ERROR MESSAGE ON UPDATE FOOD

function adderrormessageupdatefood(){
	 var food_category=document.getElementById("food_category").value;
	 var food_name=document.getElementById("food_name").value;
	 var pattern=/[0-9]/;
	 var food_cost=document.getElementById("food_cost").value;
	 
	 
	 if(food_category==0){
		 document.getElementById("foodcategoryerrmsg").innerHTML="please select food category";
	 }
	 if(food_name==""){
		 document.getElementById("foodnameerrmsg").innerHTML="enter food name";
	 }
	 if(!pattern.test(food_cost)){
		 document.getElementById("foodcosterrmsg").innerHTML="enter proper food cost";
	 }
	 return false;
}


//HIDE ERROR MESSAGE ON UPDTE FOOD

function hideerrormsgonupdatefood(){
	if(food_category!=0){
		 document.getElementById("foodcategoryerrmsg").innerHTML="";
	}
	if(food_name!=""){
		 document.getElementById("foodnameerrmsg").innerHTML="";
	 }
	 if(food_cost!=""){
		 document.getElementById("foodcosterrmsg").innerHTML="";
	 }
}




//HIDE error message on UPDATE CUSTOMER

function hideerrormessagecust(){
	if(cust_name!=""){
		document.getElementById("custnameerrmsg").innerHTML="";
	}
	if(cust_add!=""){
		document.getElementById("custadderrmsg").innerHTML="";
	}
if(cust_mobileno!=""){
	document.getElementById("custmobilenoerrmsg").innerHTML="";

	}
}

//HIDE ERROR MESSAGE OF LOGIN PAGE

function hiderrormessage() {
	if(login_type!=0){
		document.getElementById("logintypeerrmsg").innerHTML="";	
	}
	if(username!=""){
		document.getElementById("usernameerrmsg").innerHTML="";	
	}
	if(password!=""){
		document.getElementById("passworderrmsg").innerHTML="";	
	}
	
}




//HIDE ERROR MESSAGE ON ADD FOOD

function hideerrormessageonaddfood(){
	

if(food_category!=0){
	document.getElementById("foodcategoryerrmsg").innerHTML="";

}
if(food_name!=""){
	document.getElementById("foodnameerrmsg").innerHTML="";

}
if(food_cost!=""){
	document.getElementById("foodcosterrmsg").innerHTML="";

}
}
//HIde error mesage on ADD CART

function hideerrormsgoncart() {
	if(food_id!=""){
		document.getElementById("foodiderrmsg").innerHTML="";
	}
	if(cust_email!=""){
		document.getElementById("custemailerrmsg").innerHTML="";
	}
	if(food_quantity!=""){
		document.getElementById("foodquantityerrmsg").innerHTML="";	
	}		
}

//hide error message for ADD CUSTOMER

function hideerrormessage(){
		if(cust_name !=""){
			document.getElementById("cust_nameerrmsg").innerHTML= " ";
			}

		if(cust_add!=""){
		document.getElementById("cust_adderrmsg").innerHTML= " ";
		}

		if(cust_email!=""){
		document.getElementById("cust_emailerrmsg").innerHTML="";
		}
			
		if(cust_mobileno!=""){
  	     document.getElementById("cust_mobilenoerrmsg").innerHTML="";
 		}
 		
	 
 		if(cust_city!=""){
 		document.getElementById("cust_cityerrmsg").innerHTML="";
 		}
 		
 		if(cust_password!=""){
 		document.getElementById("cust_passworderrmsg").innerHTML="";
 		}
	}

	