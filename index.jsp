<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Food Plaza-Order online Delicious Foods</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<%
		String Adminloggedinsucessfull = request.getParameter("Adminloggedinsucessfull");
		String Customerloggedinsucessfull = request.getParameter("Customerloggedinsucessfull");
	%>

	<div id="templatemo_container">

		<jsp:include page="Header.jsp" />

		<div id="templatemo_top_dishes">

			<h1>Top Dishes</h1>
			<div class="top_dishes_box">
				<img src="images/templatemo_image_01.jpg" alt="image" width="205"
					height="150" />
				<h2>Veg Hakka Noodles</h2>
				<p>
					Veg Hakka Noodles is a delicious Chinese cuisine made from noodles
					and different vegetables. <a href="#">Read more...</a>
				</p>
			</div>
			-->

			<div class="top_dishes_box">
				<img src="images/templatemo_image_02.jpg" alt="image" width="205"
					height="150" />
				<h2>Butter Chicken</h2>
				<p>
					Butter Chicken is mouth watering delicious dish of Indian Cuisine
					and British Cuisine. <a href="#">Read more...</a>
				</p>
			</div>

			<div class="top_dishes_box">
				<img src="images/templatemo_image_03.jpg" alt="image" width="205"
					height="150" />
				<h2>Chicken Biryani</h2>
				<p>
					Biryani is a Signature Dish of Indian Cuisine. Comes with both
					Chicken and Mutton. Speciality of Biryani is From Mumbai,
					Hyderabad, Lucknow, Calcutta, Cochin etc.. <a href="#">Read
						more...</a>
				</p>
			</div>

			<div class="top_dishes_box">
				<img src="images/templatemo_image_04.jpg" alt="image" width="205"
					height="150" />
				<h2>Chicken Tikka Masala</h2>
				<p>
					Chicken Tikka Masala is Delicious beautifull, spicy, delicious
					Indian Dish. <a href="#">Read more...</a>
				</p>
			</div>



			<div class="cleaner">&nbsp;</div>

		</div>
		<!-- end of top dishes -->

		<div id="templatemo_content">
			<span class="top"></span>
			<div id="templatemo_innter_content">

				<div id="templatemo_content_left">
					<h1>Welcome to our website</h1>
					<img src="images/templatemo_image_05.jpg" alt="image" width="300"
						height="200" />

					<p>Welcome to our website where we offer you a delicious and
						mouth watering Veg and Non Veg Food. We provide Multicuisine Food
						where you can order food online.</p>
					<p>Speciality of our dish is mainly Indian Cuisine and
						Barbeque. Check out our LAMB BARBEQUE, the best you will ever have
						with Barbeque sauce and Red Wine.</p>
					<a href="#">Read more...</a>

					<!--  <div style="clear: both; padding: 30px 0 20px 0;">                
                <a href="http://validator.w3.org/check?uri=referer"><img style="border:0;width:88px;height:31px" src="http://www.w3.org/Icons/valid-xhtml10" alt="Valid XHTML 1.0 Transitional" width="88" height="31" vspace="8" border="0" /></a>
<a href="http://jigsaw.w3.org/css-validator/check/referer"><img style="border:0;width:88px;height:31px"  src="http://jigsaw.w3.org/css-validator/images/vcss-blue" alt="Valid CSS!" vspace="8" border="0" /></a>
					</div> -->

					<div class="cleaner_with_height">&nbsp;</div>

				</div>
				<!-- end of content left -->

				<div id="templatemo_content_right">
					<h1>What's new?</h1>
					<div class="right_column_section">
						<h2>Special meal for you</h2>
						<img src="images/templatemo_image_06.jpg" alt="image" width="225"
							height="150" />
						<h3>
							<p>LAMB BARBEQUE.</p>
						</h3>
						<a href="#">Read more...</a>
					</div>

				</div>
				<!-- end of content right -->
				<div class="cleaner">&nbsp;</div>
			</div>
			<div class="cleaner" style="background: #fff;">&nbsp;</div>
		</div>

		<!-- <div id="templatemo_container"> -->
		<jsp:include page="Footer.jsp" />
	</div>
	</div>

</body>
</html>
