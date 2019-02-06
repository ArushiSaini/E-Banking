<!DOCTYPE html>
<html>
<!-- Head -->
<head>
<title>E-Banking</title>
<!-- For-Mobile-Apps -->
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Multi Login & Signup Form Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //For-Mobile-Apps -->

<!-- Style.CSS --> <link rel="stylesheet" href="cssMain/style.css" type="text/css" media="all" />
<!-- Web-Fonts -->
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,600,700' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Lato:400,700,900,300' rel='stylesheet' type='text/css'>
<!-- //Web-Fonts -->
<!-- Horizontal-Tabs-JavaScript -->
<script src="jsMain/jquery-1.11.1.min.js"></script>
<script src="jsMain/easyResponsiveTabs.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function () {
		$('#horizontalTab').easyResponsiveTabs({
			type: 'default', //Types: default, vertical, accordion           
			width: 'auto', //auto or any width like 600px
			fit: true, // 100% fit in a container
		});
	});
</script>
<!-- Horizontal-Tabs-JavaScript -->
</head>
<!-- Head -->
<!-- Body -->
<body>
	<!-- Heading -->
	<h1><img src="images/e.png" alt="logo" />Banking </h1>
	<!-- //Headng -->


	<!-- Container -->
	<div class="container">

		<div class="tabs">

			<div class="sap_tabs">

				<div id="horizontalTab" style="display: block; width: 100%; margin: 0px;">

					<ul class="resp-tabs-list">
						
						<li class="resp-tab-item" aria-controls="tab_item-1" role="tab"><h2><span>Customer Login</span></h2></li>
						<li class="resp-tab-item" aria-controls="tab_item-2" role="tab"><span>Admin Login</span></li>
					
					</ul>

					<div class="resp-tabs-container">
						
						<div class="tab-1 resp-tab-content" aria-labelledby="tab_item-1">
							<!-- Form			-->
							<form action="CustLogin" method="post">
							
								<input type="text" name="uid" placeholder="Enter Customer Id" required=""/>
								<input type="password" name="password" placeholder="Enter Password" required="">
								<!-- <ul>
									<li>
										<input type="checkbox" id="brand1" value="">
										<label for="brand1"><span></span>Remember Me</label>
									</li>
								</ul> -->
								<input type="submit" value="Customer LOGIN">
							</form>
							<!-- //Form -->
						</div>

						<div class="tab-1 resp-tab-content" aria-labelledby="tab_item-2">
							
								<form action="Login" method="post">
									<input type="text" name="userid" placeholder="Enter User Id" required=""/>
								<input type="password" name="pwd" placeholder="Enter Password" required="">
								<!-- <ul>
									<li>
										<input type="checkbox" id="brand1" value="">
										<label for="brand1"><span></span>Remember Me</label>
									</li>
								</ul> -->
								<input type="submit" value="Admin LOGIN">
								</form>
							
						</div>

						

						</div>

					</div>

				</div>

			</div>

		</div>
	<!-- //Container -->



	<!-- Footer -->
	<div class="footer">

		<!-- Copyright -->
		<div class="copyright">
		
		<p>© 2018 E-Banking. All rights reserved | Design by <a>NIITSTUDENTS</a></p>
</div>
		
		<!-- //Copyright -->

	</div>
	<!-- //Footer -->



</body>
<!-- //Body -->



</html>