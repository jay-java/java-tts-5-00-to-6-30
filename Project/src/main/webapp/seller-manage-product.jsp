<%@page import="Dao.ProductDao"%>
<%@page import="Model.Product"%>
<%@page import="java.util.List"%>
<%@page import="Model.Seller"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
<head>
<title>Watches an E-Commerce online Shopping Category Flat Bootstrap Responsive Website Template| Checkout :: w3layouts</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Watches Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<!--webfont-->
<link href='//fonts.googleapis.com/css?family=PT+Sans+Narrow:400,700' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Dorsa' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<script src="js/jquery.easydropdown.js"></script>
<script src="js/simpleCart.min.js"> </script>
</head>
<body>
<%
	Seller s = null;
	if (session.getAttribute("data") != null) {
		s = (Seller) session.getAttribute("data");
	} else {
		response.sendRedirect("seller-login.jsp");
	}
	%>
	<div class="men_banner">
   	  <div class="container">
   	  	<div class="header_top">
   	  	   <div class="header_top_left">
	  	      <div class="box_11"><a href="checkout.html">
		      <h4><p>Cart: <span class="simpleCart_total"></span> (<span id="simpleCart_quantity" class="simpleCart_quantity"></span> items)</p><img src="images/bag.png" alt=""/><div class="clearfix"> </div></h4>
		      </a></div>
	          <p class="empty"><a href="javascript:;" class="simpleCart_empty">Empty Cart</a></p>
	          <div class="clearfix"> </div>
	       </div>
           <div class="header_top_right">
		  	 <div class="lang_list">
				<select tabindex="4" class="dropdown">
					<option value="" class="label" value="">$ Us</option>
					<option value="1">Dollar</option>
					<option value="2">Euro</option>
				</select>
			 </div>
			 <ul class="header_user_info">
			  <a class="login" href="login.html">
				<i class="user"> </i> 
				<li class="user_desc">My Account</li>
			  </a>
			  <div class="clearfix"> </div>
		     </ul>
		    <!-- start search-->
				<div class="search-box">
				   <div id="sb-search" class="sb-search">
					  <form>
						 <input class="sb-search-input" placeholder="Enter your search term..." type="search" name="search" id="search">
						 <input class="sb-search-submit" type="submit" value="">
						 <span class="sb-icon-search"> </span>
					  </form>
				    </div>
				 </div>
				 <!----search-scripts---->
				 <script src="js/classie1.js"></script>
				 <script src="js/uisearch.js"></script>
				   <script>
					 new UISearch( document.getElementById( 'sb-search' ) );
				   </script>
					<!----//search-scripts---->
		            <div class="clearfix"> </div>
			 </div>
		     <div class="clearfix"> </div>
	    </div>
   		<div class="header_bottom">
	     <div class="logo">
		    <h1><a href="index.html"><span class="m_1">W</span>atches</a></h1>
	     </div>
			<div class="menu">
					<ul class="megamenu skyblue">
						<li><a class="color10" href="seller-index.jsp">Home</a></li>
						<li><a class="color2" href="#">Product</a>
							<div class="megapanel">
								<div class="row">
									<div class="col1">
										<div class="h_nav">
											<h4>
												<a href="seller-upload-product.jsp">Upload Product</a>
											</h4>
										</div>
									</div>
									<div class="col1">
										<div class="h_nav">
											<h4>
												<a href="seller-manage-product.jsp">Manage Product</a>
											</h4>

										</div>
									</div>

								</div>
							</div></li>
						<li><a class="color2" href="#"><%=s.getName()%></a>
							<div class="megapanel">
								<div class="row">
									<div class="col1">
										<div class="h_nav">
											<h4>
												<a href="seller-profile.jsp">Profile</a>
											</h4>
										</div>
									</div>
									<div class="col1">
										<div class="h_nav">
											<h4>
												<a href="seller-change-password.jsp">Change Password</a>
											</h4>
										</div>
									</div>
									<div class="col1">
										<div class="h_nav">
											<h4>
												<a href="seller-logout.jsp">Logout</a>
											</h4>
										</div>
									</div>

								</div>
							</div></li>
						<div class="clearfix"></div>
					</ul>
				</div>
	        <div class="clearfix"> </div>
	    </div>
	   </div>
   </div>
   <div class="account-in">
   	 <div class="container">
		  <div class="check_box">	 
		<div class="col-md-9 cart-items">
			 <h1>My Products</h1>
				<script>$(document).ready(function(c) {
					$('.close1').on('click', function(c){
						$('.cart-header').fadeOut('slow', function(c){
							$('.cart-header').remove();
						});
						});	  
					});
			   </script>
			   
			   <%List<Product> list = ProductDao.getProductsBySid(s.getId()); %>
			   <%for(Product p:list){ %>
			 <div class="cart-header">
				 <div class="close1"><a href="#"></a></div>
				   <div class="cart-sec simpleCart_shelfItem">
						<div class="cart-item cyc">
							 <img src="image/<%=p.getImage() %>" class="img-responsive" alt=""/>
						</div>
					   <div class="cart-item-info">
						<h3><a href="#"><%=p.getPname() %></a></h3>
						<div class="delivery">
							 <p>Product Price : Rs.<%=p.getPprice() %></p>
							 <div class="clearfix"></div>
				        </div>	
				        	<div class="delivery">
							 <p>Product Category : <%=p.getPcategory() %></p>
							 <div class="clearfix"></div>
				        </div>
					   </div>
					   <div class="clearfix"></div>
				    </div>
			 </div>
			 <%} %>
			 <script>$(document).ready(function(c) {
					$('.close2').on('click', function(c){
							$('.cart-header2').fadeOut('slow', function(c){
						$('.cart-header2').remove();
					});
					});	  
					});
			 </script>
			
		 </div>
			<div class="clearfix"></div>
	     </div>
	  </div>
   </div>
  
   <div class="footer">
   	 <div class="container">
	    <div class="copy">
           <p> &copy; 2015 Watches. All Rights Reserved | Design by <a href="http://w3layouts.com/" target="_blank">W3layouts</a></p>
	    </div>
   	</div>
   </div>
</body>
</html>		