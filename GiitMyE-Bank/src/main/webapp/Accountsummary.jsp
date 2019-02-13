<%@page import="java.text.SimpleDateFormat"%>
<%@page import="dao.CustomerDAO"%>
<%@page import="model.Customer"%>
<%@page import="model.Account"%>
<%@page import="dao.AccountDAO"%>
   <%@page import="dao.AccountDAO" %>
    <%@page import="model.Account" %>
    <%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>E-Banking a Banking Application</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="E-Banking Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />
<script type="application/x-javascript">
	addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="css/custstyle.css" type="text/css" rel="stylesheet" media="all">
<link href="css/font-awesome.css" rel="stylesheet">
<!-- font-awesome icons -->
<script src="js/jquery-2.2.3.min.js"></script>
<link href="//fonts.googleapis.com/css?family=Secular+One" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
</head>
<body>
<!-- Top Section Begins Here -->	
<div class="headerw3-agile">
<div class="header-w3mdl">
<div class="container">
<div class="agileits-logo navbar-left">
<h1>
<a href="index.html"><img src="images/e.png" alt="logo" />Banking</a>
</h1>
</div>
<div class="agileits-hdright nav navbar-nav">
<div class="header-w3top">
<ul class="w3l-nav-top">
<li><i class="fa fa-phone"></i>
<span> +01 222 111 444</span>
</li>
<li><a href="mailto:example@mail.com">
<i class="fa fa-envelope-o"></i><span>mail@ebanking.com</span></a></li>
</ul>
<div class="clearfix"></div>
</div>
<div class="agile_social_banner">
<ul class="agileits_social_list">
<li><a href="#" class="w3_agile_facebook"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
<li><a href="#" class="agile_twitter"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
<li><a href="#" class="w3_agile_dribble"><i class="fa fa-dribbble" aria-hidden="true"></i></a></li>
<li><a href="#" class="w3_agile_vimeo"><i class="fa fa-vimeo" aria-hidden="true"></i></a></li>
</ul>
</div>
</div>
<div class="clearfix"></div>
</div>
</div>
</div>
<!-- Top Section Ends Here -->	
<!-- Welcome Section Begins Here -->	
<div class="banner">
<div class="header-nav">
<nav class="navbar navbar-default">
<div class="navbar-header">
<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
<span class="sr-only">Toggle navigation</span> Menu
</button>
</div>
<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
<ul class="nav navbar-nav">
	<li><a href="CustHome.jsp" class="scroll">Home</a></li>
	<li><a href="Accountsummary.jsp" class="active">Account Summary</a></li>
	<li><a href="IndividualMiniaccountsum.jsp" class="scroll">Mini Account Summary</a></li>
	<li><a href="IndividualDetailAccountSum.jsp" class="scroll">Detailed Account Summary</a></li>
	<li><a href="LogOut" class="scroll">Logout</a></li>
</ul>
<div class="clearfix"></div>
</div> 
</nav>
</div>
<div class="container">
<div class="banner-text agileits-w3layouts">
<div id="top" class="callbacks_container">
<ul class="rslides" id="slider3">
<li>
<div class="banner-textagileinfo">
<% 
String custname=(String)session.getAttribute("custname");
System.out.println("custname:"+custname);
%>
<h6>Welcome To E-Banking, <i><b><%=custname %></b></i></h6>
<div class="agileits-banner-bot">
<div class="col-md-12 col-sm-12 col-xs-12 w3l-bb-grid1">
<div class="col-md-12 text-center"><h4><b>Account Summary</b></h4></div>
<div class="col-md-12"><hr></div>
<div class="col-md-2"><b>Account Number</b></div>
<div class="col-md-2"><b>Account Type</b></div>
<div class="col-md-2"><b>Balance</b></div>
<div class="col-md-2"><b>Last Transaction</b></div>
<div class="col-md-4 text-center"><b>Statement Type</b></div>
<div class="col-md-12"><hr></div>
</div>
<%
String customerid=(String)session.getAttribute("custid");
AccountDAO acdao = new AccountDAO();
List<Account> acclist = acdao.viewAccountSummary(customerid);
SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
for(Account a:acclist){
	String ltdttran =a.getLtdttran().toGMTString();
	String url="Miniaccountsum.jsp?acno="+a.getAccountno();
	String url1="DetailAccountSum.jsp?acno="+a.getAccountno();
%>

<div class="col-md-12 col-sm-12 col-xs-12 w3l-bb-grid1">

<div class="col-md-2"> <%=a.getAccountno()%></div>
<div class="col-md-2"><%=a.getAtype()%></div>
<div class="col-md-2"><%=a.getOpeningbalance()%></div>
<div class="col-md-2"><%=sdf.format(a.getLtdttran())%></div>
<div class="col-md-4"><a href='<%=url%>'><b>Mini Statement </b></a><b>/</b>
					  <a href='<%=url1%>'><b> Detailed Statement</b></a></div>
<div class="col-md-12"><hr></div>
</div>

<%
}
%>
</div>

<div class="clearfix"></div>
</div>
</div>
</div>
</li>
</ul>
</div>
</div>
</div>
</div>
<!-- Welcome Section Ends Here -->	
<!-- About Starts Here -->
<div class="clearfix"></div>
<div class="wthree-about-bot-grid-sec">
<div class="agileits-about-pos">
<h2>secure banking</h2>
</div>
<div class="col-md-6 col-sm-6 w3ls-abg w3ls-abg1 abg1">
	<h4>Safe,secure and convenient banking</h4>
	<p>Online banking is safe when secure bank technology on the
	back end is met with alert consumers on the front end. As an
	account holder, you have a role in making sure accounts are protected.</p>
</div>
<div class="col-md-6 col-sm-6 w3ls-abg w3ls-abg2 abg4">
	<h4>It is your money.Manage it your way.</h4>
	<p>Online banking involves managing your bank accounts with a
	computer or mobile device â€” including transferring funds,
	depositing checks and paying bills. Mostbanks and credit unions,
	even those with branches, let customers access theirbank accounts via the internet.</p>
</div>
<div class="col-md-6  col-sm-6 w3ls-abg w3ls-abg1 abg2">
	<h4>Pay people. Pay bills.Transfer money.</h4>
	<p>Pay-by-Phone Systems let you call your financial institution
	with instructions to pay certain bills or to transfer funds between
	accounts. Debit Card Purchase or Payment Transactions let you make
	purchases or payments with a debit card, which also may be your ATM card.</p>
</div>
<div class="col-md-6 col-sm-6 w3ls-abg w3ls-abg2 abg3">
<h4>Mobile Privacy and Security</h4>
<p>Mobile banking is a service provided by a bank or other
financial institution that allows its customers to conduct
financial transactions remotely using a mobile device such as a
smartphone or tablet.</p>
</div>
<div class="clearfix"></div>
</div>
<!-- About Ends Here -->
<!--Services Begins Here-->
<div class="w3ls-section services">
<div class="container">
<div class="services-left">
	<h4 class="title">online banking</h4>
	<h5>any time,anywhere.</h5>
	<p class="data">Enim nim pariatur cliche reprehen chardson ad
	sqderit ad sveprehed sectetur adipiscing elit iatur clic.</p>
	<div class="more">
		<a href="#"> Read More</a>
	</div>
</div>
<div class="services-right">
	<div class="services-grid">
		<div class="col-md-2 col-sm-2 col-xs-2 sr-icon">
			<span class="fa fa-lock" aria-hidden="true"></span>
		</div>
		<div class="col-md-10 col-sm-10 col-xs-10 sr-txt">
		<h5>safe & secure</h5>
		<p>Safe Internet banking equipped with secure firewall protection against virus attacks.</p>
		</div>
		<div class="clearfix"></div>
	</div>
	<div class="services-grid">
		<div class="col-md-2 col-sm-2 col-xs-2 sr-icon">
			<span class="fa fa-clock-o" aria-hidden="true"></span>
		</div>
		<div class="col-md-10 col-sm-10 col-xs-10 sr-txt">
		<h5>save time</h5>
		<p>It provides banking throughout the year 24x7 from any place.</p>
		</div>
		<div class="clearfix"></div>
	</div>
	<div class="services-grid">
		<div class="col-md-2 col-sm-2 col-xs-2 sr-icon">
			<span class="fa fa-gg" aria-hidden="true"></span>
		</div>
		<div class="col-md-10 col-sm-10 col-xs-10 sr-txt">
		<h5>transfer money</h5>
		<p>Easy transfer of Money from one bank to another and one account to another.</p>
		</div>
		<div class="clearfix"></div>
	</div>
	<div class="services-grid">
		<div class="col-md-2 col-sm-2 col-xs-2 sr-icon">
			<span class="fa fa-credit-card-alt" aria-hidden="true"></span>
		</div>
		<div class="col-md-10 col-sm-10 col-xs-10 sr-txt">
		<h5>pay bills</h5>
		<p>You can pay any kind of bills from the comfort of your home or office.</p>
		</div>
		<div class="clearfix"></div>
	</div>
	<div class="services-grid">
		<div class="col-md-2 col-sm-2 col-xs-2 sr-icon">
			<span class="fa fa-shopping-cart" aria-hidden="true"></span>
		</div>
		<div class="col-md-10 col-sm-10 col-xs-10 sr-txt">
		<h5>Shop Online</h5>
		<p>It includes the electronic payment system from your home by avoiding long queues.</p>
		</div>
		<div class="clearfix"></div>
	</div>
	<div class="clearfix"></div>
</div>
<div class="clearfix"></div>
</div>
</div>
<!--Services Ends Here-->

<!-- Testimonials Begins Here -->
<div class="testimonials w3ls-section" id="testimonials">
<div class="container">
<h3 class="h3-w3l">Testimonials</h3>
<div class="agile_testimonials_grids">
<div class="col-md-6 col-sm-6 agile_testimonials_grid">
<div class="agile_testimonials_grid1">
<div class="w3_agile_testimonials_grid_right test-tooltip">
	<p>Vivamus sed porttitor felis. Pellentesque habitant morbi
	tristique senectus et netus et malesuada fames ac turpis egestas.Sed lorem enim, rutrum quis diam nec.</p>
</div>
<div class="w3_agile_testimonials_grid">
<div class="w3_agile_testimonials_grid_left">
<div class="col-md-3 col-sm-3 col-xs-3 w3l-testi-img">
	<img src="images/13.jpg" alt=" " class="img-responsive" />
</div>
<div class="col-md-9 col-sm-9 col-xs-9 w3l-testi-txt">
	<h4>Tyson</h4>
	<p>fames ac turpis</p>
</div>
<div class="clearfix"></div>
</div>							
</div>						
<div class="clearfix"></div>
</div>
</div>
				
<div class="col-md-6 col-sm-6 agile_testimonials_grid">
<div class="agile_testimonials_grid1">
<div class="w3_agile_testimonials_grid_right test-tooltip">
	<p>Vivamus sed porttitor felis. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis
	egestas.Sed lorem enim, rutrum quis diam nec.</p>
</div>
<div class="w3_agile_testimonials_grid">
<div class="w3_agile_testimonials_grid_left">
<div class="col-md-3 col-sm-3 col-xs-3 w3l-testi-img">
	<img src="images/10.jpg" alt=" " class="img-responsive" />
</div>						
<div class="col-md-9 col-sm-9 col-xs-9 w3l-testi-txt">
	<h4>Alejandra</h4>
	<p>fames ac turpis</p>
</div>
<div class="clearfix"></div>
</div>
</div>
<div class="clearfix"></div>
</div>
</div>					
			
<div class="col-md-6 col-sm-6 agile_testimonials_grid">
<div class="agile_testimonials_grid1">
<div class="w3_agile_testimonials_grid_right test-tooltip">
	<p>Vivamus sed porttitor felis. Pellentesque habitant morbi
	tristique senectus et netus et malesuada fames ac turpis egestas.Sed lorem enim, rutrum quis diam nec.</p>
</div>
<div class="w3_agile_testimonials_grid">
<div class="w3_agile_testimonials_grid_left">
<div class="col-md-3 col-sm-3 col-xs-3 w3l-testi-img">
	<img src="images/11.jpg" alt=" " class="img-responsive" />
</div>
<div class="col-md-9 col-sm-9 col-xs-9 w3l-testi-txt">
	<h4>Charles</h4>
	<p>fames ac turpis</p>
</div>
<div class="clearfix"></div>
</div>
</div>
<div class="clearfix"></div>
</div>
</div>

<div class="col-md-6 col-sm-6 agile_testimonials_grid">
<div class="agile_testimonials_grid1">
<div class="w3_agile_testimonials_grid_right test-tooltip">
	<p>Vivamus sed porttitor felis. Pellentesque habitant morbi
	tristique senectus et netus et malesuada fames ac turpis
	egestas.Sed lorem enim, rutrum quis diam nec.</p>
</div>
<div class="w3_agile_testimonials_grid">
<div class="w3_agile_testimonials_grid_left">
<div class="col-md-3 col-sm-3 col-xs-3 w3l-testi-img">
	<img src="images/12.jpg" alt=" " class="img-responsive" />
</div>
<div class="col-md-9 col-sm-9 col-xs-9 w3l-testi-txt">
	<h4>Jessie</h4>
	<p>fames ac turpis</p>
</div>
<div class="clearfix"></div>
</div>
</div>
<div class="clearfix"></div>
</div>
</div>
<div class="clearfix"></div>
</div>
</div>
</div>
<!-- Testimonials Ends Here -->

<!--Footer Begins Here -->
<div class="agile-footer w3ls-section">
<div class="container">
<div class="col-md-7 list-footer">
<ul class="footer-nav">
<li><a href="CustHome.jsp" class="active">Home</a></li>
<li><a href="Accountsummary.jsp" class="scroll">Account Summary</a></li>
<li><a href="IndividualMiniaccountsum.jsp" class="scroll">Mini Account Summary</a></li>
<li><a href="IndividualDetailAccountSum.jsp" class="scroll">Detailed Account Summary</a></li>
<li><a href="LogOut" class="scroll">Logout</a></li>
</ul>
<p>IMPORTANT : E-Banking never asks for your user id/password/pin no. through phone call/SMSes/e-mails.</p>
</div>
<div class="col-md-5 agileinfo-sub">
	<h6>Click the link below to start the subscription service</h6>
	<a href="#" data-toggle="modal" data-target="#myModal1">subscribe</a>
</div>
<div class="clearfix"></div>
</div>
</div>
<div class="w3_agile-copyright text-center">
<p>© 2018 E-Banking. All rights reserved | Design by <a>NIITSTUDENTS</a></p>
</div>
<!--Footer Ends Here -->

<!-- ModalSign Subscription Begins Here -->
<div class="modal bnr-modal fade" id="myModal1" tabindex="-1" role="dialog">
<div class="modal-dialog" role="document">
<div class="modal-content">
<div class="modal-header">
<img src="images/logo.png" alt="logo" />
<button type="button" class="close" data-dismiss="modal" aria-label="Close">
<span aria-hidden="true">&times;</span>
</button>
</div>
<div class="modal-body modal-spa">
	<p>E-Banking's email newsletter provides subscribers with helpful articles on important issues in the banking industry, as
	well as news about events and more! To sign up for the newsletter,fill the below form.</p>
	<form class=" wthree-subsribe" action="#" method="post">
	<input type="text" name="name" placeholder="Your Name" required="">
	<input type="email" name="email" placeholder="your Email" required=""> <input type="submit" value="SignUp">
	<div class="clearfix"></div>
	</form>
</div>
</div>
</div>
</div>
<!-- ModalSign Subscription Ends Here -->
<!-- Banner Slider Begins Here -->
<script src="js/responsiveslides.min.js"></script>
<script>
$(function() {
$("#slider3").responsiveSlides({
auto : true,pager : false,nav : true,speed : 500,namespace : "callbacks",before : function() {
$('.events').append("<li>before event fired.</li>");
},
after : function() {
$('.events').append("<li>after event fired.</li>");
}
});
});
</script>
<script src="js/SmoothScroll.min.js"></script>
<!-- smooth-scrolling-of-move-up -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
$(document).ready(function() {
$().UItoTop({
easingType : 'easeOutQuart'
});
});
</script>
<!-- //smooth-scrolling-of-move-up -->
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="js/bootstrap.js"></script>
</body>
</html>